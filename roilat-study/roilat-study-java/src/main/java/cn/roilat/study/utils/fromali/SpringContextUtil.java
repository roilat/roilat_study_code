package cn.roilat.study.utils.fromali;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * spring上下文工具
 * 
 * @author qianyu
 * @version $Id: SpringContextUtil.java, v 0.1 Oct 21, 2018 2:16:26 PM qianyu Exp $
 */
public class SpringContextUtil implements ApplicationContextAware {

    /** spring上下文 */
    private static ApplicationContext applicationContext;

    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     *
     * @param applicationContext
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;

    }

    /**
    * @return ApplicationContext
    */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
    * 获取对象
    *
    * @param name
    * @return Object 一个以所给名字注册的bean的实例
    * @throws BeansException
    */
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }

    /**
     * 注册bean
     * 
     * @param beanName
     * @param clazz
     */
    public static void registerBean(String beanName, Class<?> clazz,
                                    List<Object> constructorValueList,
                                    List<String> constructorRefList,
                                    Map<String, Object> propertyValueMap,
                                    Map<String, String> propertyRefMap) {
//        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext
//            .getParentBeanFactory();

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
            .genericBeanDefinition(clazz);
        if (propertyValueMap != null) {
            for (String key : propertyValueMap.keySet()) {
                beanDefinitionBuilder.addPropertyValue(key, propertyValueMap.get(key));
            }
        }

        if (propertyRefMap != null) {
            for (String key : propertyRefMap.keySet()) {
                beanDefinitionBuilder.addPropertyReference(key, propertyRefMap.get(key));
            }
        }

        if (constructorValueList != null) {
            for (Object constructorValue : constructorValueList) {
                beanDefinitionBuilder.addConstructorArgValue(constructorValue);
            }
        }

        if (constructorRefList != null) {
            for (String constructorRef : constructorRefList) {
                beanDefinitionBuilder.addConstructorArgReference(constructorRef);
            }
        }
        beanDefinitionBuilder.setScope(BeanDefinition.SCOPE_SINGLETON);
        beanDefinitionBuilder.setLazyInit(false);
        beanDefinitionBuilder.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_NAME);

        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        ( (BeanDefinitionRegistry) applicationContext
                .getParentBeanFactory()).registerBeanDefinition(beanName, beanDefinition);
    }

}
