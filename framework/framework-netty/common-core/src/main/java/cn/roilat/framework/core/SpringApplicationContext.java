package cn.roilat.framework.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationContext implements ApplicationContextAware {
	public static ApplicationContext context = null;
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		SpringApplicationContext.context = context;
	}
	public static <T> T getBean(Class<T> clazz){
		return context.getBean(clazz);
	}
	
	public static Object getBean(String name){
		return context.getBean(name);
	}
	
	public static <T> T getBean(String name,Class<T> clazz){
		return context.getBean(name, clazz);
	}
}
