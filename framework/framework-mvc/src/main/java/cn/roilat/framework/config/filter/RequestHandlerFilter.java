package cn.roilat.framework.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.roilat.framework.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

@WebFilter(urlPatterns = "/*", filterName = "LogFilter2")
public class RequestHandlerFilter implements Filter {
    Logger logger = LoggerFactory.getLogger("sytem.filter.log2");

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
        String contentType = ((HttpServletRequest) servletRequest).getContentType();
        String requestMethod = ((HttpServletRequest) servletRequest).getMethod();
        if (HttpMethod.POST.name().equals(requestMethod)
            || HttpMethod.PUT.name().equals(requestMethod)) {
            if (!StringUtils.isEmpty(contentType) && !contentType.startsWith("application/json")) {
                ((HttpServletResponse) servletResponse)
                    .setStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
                return ;
            }
        }
        chain.doFilter(servletRequest, servletResponse);
    }

}
