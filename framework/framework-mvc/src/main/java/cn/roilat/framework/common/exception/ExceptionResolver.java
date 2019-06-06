package cn.roilat.framework.common.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.roilat.framework.common.result.WebErrorResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 先到这里，然后才重定向到errorController的,这个异常的处理优先级低于GlobalDefaultExceptionHandler,但是两者之间是互补关系.及一个异常先到GlobalDefaultExceptionHandler中如果没有找到处理类,则到这个类中.
 * 
 * @author roilat-J
 * @version $Id: ExceptionResolver.java, v 0.1 2019年3月15日 下午6:05:03 roilat-J Exp $
 */
@Configuration
public class ExceptionResolver implements HandlerExceptionResolver {
    Logger logger = LoggerFactory.getLogger("system.exception.resolver");
    @Value("${server.error.path}")
    private String errorView;
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object handler, Exception ex) {

        logger.error("system.exceptionResolver", handler, ex);
        WebErrorResult errorResult = null;
        

        if (errorResult == null) {
            errorResult = new WebErrorResult();
            errorResult.setCode(response.getStatus());
            errorResult.setMsg("系统内部未知异常");
        }

        request.setAttribute("resultMsg", errorResult);

        return new ModelAndView(errorView);
    }

}
