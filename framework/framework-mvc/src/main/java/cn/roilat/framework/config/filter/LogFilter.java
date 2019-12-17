package cn.roilat.framework.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {
    Logger logger = LoggerFactory.getLogger("sytem.filter.log");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain chain) throws IOException, ServletException {
        chain.doFilter(servletRequest, servletResponse);
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        logger.info("调用接口{}：{}", request.getMethod(), request.getRequestURI());
    }

}
