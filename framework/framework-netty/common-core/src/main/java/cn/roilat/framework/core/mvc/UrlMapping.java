package cn.roilat.framework.core.mvc;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface UrlMapping {
	// 访问的url路径，类似于requestmapping
	public String value();

	public HttpMethod method() default HttpMethod.ALL;
}

enum HttpMethod {
	ALL,
	GET,
	POST,
	PUT,
	DELETE,
	HEAD,
	OPTION;
}