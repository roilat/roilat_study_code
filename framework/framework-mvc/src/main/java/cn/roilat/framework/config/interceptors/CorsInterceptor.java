package cn.roilat.framework.config.interceptors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.roilat.framework.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;


/**
 * 统一解决系统中的跨域问题
 * @author roilat-J
 */
public class CorsInterceptor implements HandlerInterceptor {

    /**
     * 跨域配置列表
     */
    private List<CORSConfig> corsConfigs = new ArrayList<CORSConfig>();

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String origin = httpServletRequest.getHeader("Origin");
        if ("OPTIONS".equals(httpServletRequest.getMethod())) {
            if (StringUtils.isEmpty(origin)) {
                doCORSError("This cross site request has an illegal origin property!", httpServletResponse, HttpStatus.BAD_REQUEST.value());
                return false;
            }
            for (CORSConfig corsConfig : corsConfigs) {
                if (corsConfig.isAccredit(httpServletRequest.getRequestURI(), origin)) {
                    //是跨域访问，则直接设置头信息并正常返回
                    String acah = httpServletRequest.getHeader("Access-Control-Request-Headers");
                    String acrm = httpServletRequest.getHeader("Access-Control-Request-Method");
                    httpServletResponse.addHeader("Access-Control-Allow-Origin", origin);
                    httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
                    httpServletResponse.addHeader("Access-Control-Allow-Methods", StringUtils.isEmpty(acrm)?"GET,POST":acrm);
                    httpServletResponse.addHeader("Access-Control-Max-Age", "3600");
                    httpServletResponse.addHeader("Access-Control-Allow-Headers", StringUtils.isEmpty(acah) ? "Access-Control-Allow-Headers," : acah + ",Access-Control-Allow-Headers");
                    httpServletResponse.setStatus(HttpStatus.OK.value());
                    return false;
                }
            }
            doCORSError("This cross site request is Forbidden!", httpServletResponse, HttpStatus.FORBIDDEN.value());
            return false;
        } else {
            return true;
        }
    }

    private void doCORSError(String errorMsg, HttpServletResponse response, int httpStatus) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", errorMsg);
        response.setStatus(httpStatus);
        response.getWriter().write(jsonObject.toJSONString());
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        String origin = httpServletRequest.getHeader("Origin");
        if (StringUtils.isNotEmpty(origin)) {
            httpServletResponse.addHeader("Access-Control-Allow-Origin", origin);
            httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
            httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, POST");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    public void setCorsUriAccreditMap(Map<String, String> corsUriAccreditMap) {
        initCorsConfigs(corsUriAccreditMap);
    }
    private void initCorsConfigs(Map<String, String> corsUriAccreditMap){
        if(!CollectionUtils.isEmpty(corsUriAccreditMap)){
            Iterator<Map.Entry<String,String>> iterator = corsUriAccreditMap.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String,String> entry = iterator.next();
                String uri;
                if(StringUtils.isNotEmpty(uri = entry.getKey())){
                    corsConfigs.add(new CORSConfig(uri, entry.getValue() == null ? new String[0] : entry.getValue().split(","), uri.indexOf("*") >= 0));
                }
            }
        }
    }
}

class CORSConfig {

    String uriPattern;
    Pattern pattern;
    String[] whiteList;
    Boolean isPattern;

    CORSConfig(String uriPattern, String[] whiteList,Boolean isPattern) {
        this.pattern = Pattern.compile(uriPattern.replaceAll("\\+","\\\\+").replaceAll("\\.","\\\\.").replaceAll("\\*{2}","\\\\w{0,}(/\\\\w{0,}){0,}").replaceAll("\\*","\\\\w{0,}"));
        this.uriPattern = uriPattern;
        this.whiteList = whiteList;
        this.isPattern = isPattern;
    }

    boolean isAccredit(String requestUri, String origin) {
        boolean isMatched = isPattern ? pattern.matcher(requestUri).matches() : requestUri.startsWith(uriPattern);
        if (isMatched) {
            for (String s : whiteList) {
                if (origin.equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

}