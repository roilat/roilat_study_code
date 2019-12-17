package cn.roilat.framework.config.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LogInvokeInfoInterceptor implements HandlerInterceptor {
    
    Logger           logger = LoggerFactory.getLogger("sytem.host");

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse, Object o) throws Exception {
        logger.info("调用接口{}：{}", httpServletRequest.getMethod(),httpServletRequest.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object o,
                                Exception e) throws Exception {
    }
}