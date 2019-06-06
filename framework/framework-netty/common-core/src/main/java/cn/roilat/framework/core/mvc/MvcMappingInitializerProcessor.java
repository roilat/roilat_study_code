package cn.roilat.framework.core.mvc;

import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

@Component
public class MvcMappingInitializerProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println(bean + beanName);
		if (AnnotationUtils.findAnnotation(bean.getClass(), Component.class) != null) {
			UrlMapping classMapping = AnnotationUtils.findAnnotation(bean.getClass(), UrlMapping.class);
			String classUrl = "";
			if (classMapping != null) {
				classUrl = classMapping.value();
				if (!classUrl.startsWith("/")) {
					classUrl = "/" + classUrl;
				}
			}
			Method[] methods = bean.getClass().getMethods();
			for (Method method : methods) {
				UrlMapping methodMapping = AnnotationUtils.findAnnotation(method, UrlMapping.class);
				if (methodMapping != null) {
					if (methodMapping.value().startsWith("/")) {
						URLHandlerFactory.urlToClassmapping.put((classUrl + methodMapping.value()).trim(), bean);
						URLHandlerFactory.urlMappingToMethod.put((classUrl + methodMapping.value()).trim(), method);
					} else {
						URLHandlerFactory.urlToClassmapping.put((classUrl + "/" + methodMapping.value()).trim(), bean);
						URLHandlerFactory.urlMappingToMethod.put((classUrl + "/" + methodMapping.value()).trim(),
								method);
					}
				}
			}
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

}
