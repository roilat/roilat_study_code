package cn.roilat.framework.core.netty.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import cn.roilat.framework.core.mvc.URLHandlerFactory;
import cn.roilat.framework.result.ResponseResult;
import cn.roilat.framework.result.ResultCodeEnum;
import cn.roilat.framework.utils.StringUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpDataFactory;
import org.springframework.beans.BeanUtils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseHandler<T> extends ChannelInboundHandlerAdapter {

    public abstract void readData(ChannelHandlerContext ctx, T msg);

    // 解析收到的文件
    public static final HttpDataFactory factory = new DefaultHttpDataFactory(DefaultHttpDataFactory.MAXSIZE); // 最小值为16384L

    /**********
     * 获取IP
     *
     * @param ctx
     * @param request
     * @return
     */
    public String getClientIp(ChannelHandlerContext ctx, HttpRequest request) {
        String clientIp = request.headers().get("X-Forwarded-For");
        if (clientIp == null) {
            InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
            clientIp = insocket.getAddress().getHostAddress();
        }
        return clientIp;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        readData(ctx, (T) msg);
    }

    /**
     * 用于下载调用的反射方法
     **/
    public void downloadInvokeMethod(ChannelHandlerContext ctx, String uri, String bodyContent) {
        String uriPath = uri.contains("?") ? uri.substring(0, uri.indexOf("?")) : uri;
        Object obj = URLHandlerFactory.urlToClassmapping.get(uriPath);
        Method method = URLHandlerFactory.urlMappingToMethod.get(uriPath);

        Object[] args = null;
        Parameter[] parameters = method.getParameters();
        if (parameters != null && parameters.length > 1) {
            args = new Object[parameters.length]; // 方法中的参数
            args[0] = ctx;
            for (int i = 1; i < parameters.length; i++) {
                Parameter parameter = parameters[i];
                Class<?> clazz = parameter.getType();
                if (List.class.isAssignableFrom(clazz)) {
                    // 获取集合泛型中真实的类型
                    Class<?> actualClass = (Class<?>) ((ParameterizedType) parameter.getParameterizedType())
                            .getActualTypeArguments()[0];
                    args[i] = JSON.parseArray(bodyContent, actualClass);
                } else if (BeanUtils.isSimpleProperty(clazz)) {
                    // 基本数据类型
                    args[i] = JSON.parseObject(bodyContent).get(parameter.getName());
                } else {
                    // 引用类型,比如:自定义对象
                    JSONObject json = JSONObject.parseObject(bodyContent);
                    if (uri.contains("?")) {
                        String param = uri.substring(uri.indexOf("?") + 1);
                        json.putAll(parseUriParam(param));
                    }
                    args[i] = JSON.toJavaObject(json, clazz);
                }
            }
        }

        try {
            method.invoke(obj, args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private Map<String, Object> parseUriParam(String paramStr) {
        Map<String, Object> map = new HashMap<String, Object>();
        String[] params = paramStr.split("&");
        for (String param : params) {
			if(StringUtil.isNotEmpty(param)) {
				String[] temp = param.split("=");
				if(temp.length == 1) {
					map.put(temp[0], null);
				}else {
					map.put(temp[0], temp[1]);
				}
			}
		}
        return map;
    }

    public Object invokeMethod(String uri, String content) {
        // 通过url获取对应处理类
        String urlPath = uri.contains("?") ? uri.substring(0, uri.indexOf("?")) : uri;
        Object obj = URLHandlerFactory.urlToClassmapping.get(urlPath);
        Method method = URLHandlerFactory.urlMappingToMethod.get(urlPath);
        if (obj == null || method == null) {
            return ResponseResult.fail(ResultCodeEnum.RESOURCE_NOTFOUND);
        }
        Object[] args = null;
        // 对应参数的类型
        // Class<?>[] paramsType = method.getParameterTypes();
        // 对应参数的名称
        Parameter[] parameters = method.getParameters();
        if (parameters != null && parameters.length > 0) {
            args = new Object[parameters.length]; // 方法中的参数
            Map<String,Object> urlParamMap = null;
            if (uri.contains("?")) {
                String param = uri.substring(uri.indexOf("?") + 1);
                urlParamMap = parseUriParam(param);
            }
            for (int i = 0; i < parameters.length; i++) {
                Parameter parameter = parameters[i];
                Class<?> clazz = parameter.getType();
                if (List.class.isAssignableFrom(clazz)) {
                    // 获取集合泛型中真实的类型
                    Class<?> actualClass = (Class<?>) ((ParameterizedType) parameter.getParameterizedType())
                            .getActualTypeArguments()[0];
                    args[i] = JSON.parseArray(content, actualClass);
                } else if (BeanUtils.isSimpleProperty(clazz)) {
                    // 基本数据类型
                    args[i] = JSON.parseObject(StringUtil.isEmpty(content) ? "{}" : content).get(parameter.getName());
                } else {
                    // 引用类型。比如：自定义对象
                    JSONObject json = JSONObject.parseObject(StringUtil.isEmpty(content) ? "{}" : content);
                    if(urlParamMap != null){
                        json.putAll(urlParamMap);
                    }
                    args[i] = JSON.toJavaObject(json, clazz);
                }
            }
        }
        try {
            Object result = method.invoke(obj, args);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseResult.fail("传输数据格式错误，请检查");
    }

    public void writeData2Client(ChannelHandlerContext ctx, Object result) {
        FullHttpResponse response = null;
        try {
            response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
                    Unpooled.wrappedBuffer(result.toString().getBytes("utf-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, "application/json");
        response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes() + "");
        response.headers().set(HttpHeaderNames.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
        ctx.writeAndFlush(response);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
