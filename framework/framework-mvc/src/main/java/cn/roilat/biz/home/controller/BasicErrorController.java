package cn.roilat.biz.home.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.roilat.framework.common.result.WebErrorResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("${server.error.path}")
public class BasicErrorController extends AbstractErrorController {

    protected static final Logger   logger = LoggerFactory.getLogger("system.error");
    protected final ErrorProperties errorProperties;
    @Autowired
    protected ApplicationContext    applicationContext;

    /**
     * Create a new {@link org.springframework.boot.autoconfigure.web.BasicErrorController} instance.
     */
    public BasicErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
        this(errorAttributes, errorProperties, Collections.<ErrorViewResolver> emptyList());
    }

    /**
     * Create a new {@link org.springframework.boot.autoconfigure.web.BasicErrorController} instance.
     */
    public BasicErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties,
                                List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, errorViewResolvers);
        Assert.notNull(errorProperties, "ErrorProperties must not be null");
        this.errorProperties = errorProperties;
    }

    @Override
    public String getErrorPath() {
        return this.errorProperties.getPath();
    }

    @RequestMapping(produces = "text/html")
    @ResponseBody
    public Object errorHtml(HttpServletRequest request, HttpServletResponse response) {
        WebErrorResult errorResult = (WebErrorResult) request.getAttribute("resultMsg");
        response.setStatus(errorResult.getCode());
        response.setContentType("application/json;charset=UTF-8");
        try {
            response.getWriter().write(JSONObject.toJSONString(errorResult));
        } catch (IOException e) {
            logger.error("错误处理返回结果时异常", e);
        }
        return null;
    }

    @RequestMapping
    @ResponseBody
    public Object error(HttpServletRequest request, HttpServletResponse response) {
        WebErrorResult errorResult = (WebErrorResult) request.getAttribute("resultMsg");
        response.setStatus(errorResult.getCode());
        return request.getAttribute("resultMsg");
    }

    /**
     * Determine if the stacktrace attribute should be included.
     */
    protected boolean isIncludeStackTrace(HttpServletRequest request, MediaType produces) {
        ErrorProperties.IncludeStacktrace include = getErrorProperties().getIncludeStacktrace();
        if (include == ErrorProperties.IncludeStacktrace.ALWAYS) {
            return true;
        }
        if (include == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM) {
            return getTraceParameter(request);
        }
        return false;
    }

    protected ErrorProperties getErrorProperties() {
        return this.errorProperties;
    }

}
