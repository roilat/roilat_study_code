package cn.roilat.framework.core.netty.handler;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.QueryStringDecoder;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DownloadHandler extends BaseHandler<FullHttpRequest> {
	
	@Override
	public void readData(ChannelHandlerContext ctx, FullHttpRequest request) {
		String uri = request.uri();
		if(uri.contains("download")){
			String bodyContent = null;
			boolean isPost = HttpMethod.POST.equals(request.method()) ? true : false;
			if(isPost){
				ByteBuf buf = request.content();
				bodyContent = buf.toString(Charset.defaultCharset());
				buf.release();
			}else{
				QueryStringDecoder decoderQuery = new QueryStringDecoder(uri);
				Map<String, List<String>> uriAttributes = decoderQuery.parameters();
				JSONObject parameters = new JSONObject();
				for (Entry<String, List<String>> attr : uriAttributes.entrySet()) {
					String key = attr.getKey();
					String value = attr.getValue().get(0);
					parameters.put(key, value);
				}
				bodyContent = parameters.toJSONString();
			}
			super.downloadInvokeMethod(ctx,uri,bodyContent);
		}else{
			ctx.fireChannelRead(request);
		}
	}
}
