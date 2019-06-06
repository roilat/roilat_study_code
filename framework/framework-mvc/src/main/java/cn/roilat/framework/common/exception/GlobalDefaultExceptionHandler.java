package cn.roilat.framework.common.exception;

import javax.servlet.http.HttpServletResponse;

import cn.roilat.framework.common.result.WebErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 *  暂时不用
 * @author roilat-J
 * @version $Id: GlobalDefaultExceptionHandler.java, v 0.1 2019年3月18日 上午11:42:19 roilat-J Exp $
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(SevenBoException.class)
    @ResponseBody
    public WebErrorResult linjiezhijiaExceptionHandler(SevenBoException exception, HttpServletResponse response) {
        WebErrorResult result = build(exception.getExceptionCodeEnums());
        response.setStatus(result.getCode());
        return result;
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public WebErrorResult bindExceptionHandler(BindException exception, HttpServletResponse response) {
        WebErrorResult result = new WebErrorResult();
        result.setCode(HttpStatus.BAD_REQUEST.value());
        result.setMsg(exception.getMessage());
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return result;
    }

    /**
         * 处理 Exception 类型的异常
         * 方法名为任意名，入参一般使用 Exception 异常类，方法返回值可自定义。
         * @param e
         * @return
         */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public WebErrorResult defaultExceptionHandler(Exception e) {
        WebErrorResult result = new WebErrorResult();
        result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        result.setMsg(e.getMessage());
        return result;
    }

    
    
    public WebErrorResult build(SevenBoErrorCodeEnums errorCodeEnums) {
        if (errorCodeEnums != null) {
            WebErrorResult result = new WebErrorResult();
            switch (errorCodeEnums) {
                case ID_NOT_EXISTS:
                    result.setCode(HttpStatus.NOT_FOUND.value());
                    result.setMsg("你访问的资源不存在！");
                    break;

                default:
                    break;
            }

            return result;
        } else {
            return null;
        }
    }
}
