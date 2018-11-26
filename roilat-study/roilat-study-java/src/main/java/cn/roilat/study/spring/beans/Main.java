package cn.roilat.study.spring.beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.AbstractRefreshableWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class Main {
    public static void main(String[] args) {
        springAnnotationLoad();
        springXmlLoad();
        
        AbstractRefreshableWebApplicationContext abstractRefreshableWebApplicationContext = new XmlWebApplicationContext();
        AbstractRefreshableApplicationContext abstractRefreshableApplicationContext;
        abstractRefreshableApplicationContext = new ClassPathXmlApplicationContext();
        abstractRefreshableApplicationContext = abstractRefreshableWebApplicationContext;
        
        /*      ContextLoaderListener contextLoaderListener = new ContextLoaderListener();
       ServletContext source = new ApplicationContext(new StandardContext());
        ServletContextEvent event = new ServletContextEvent(source );
        contextLoaderListener.contextInitialized(event);
        System.out.println(ContextLoaderListener.getCurrentWebApplicationContext());*/
    }
    
    public static void springAnnotationLoad() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("cn.roilat.study.spring.beans.annotationed");
//        annotationConfigApplicationContext.refresh();
        System.out.println(annotationConfigApplicationContext.getBeanDefinitionCount());
        System.out.println(annotationConfigApplicationContext.getBean("myService"));
        System.out.println(annotationConfigApplicationContext.getBean("myService"));
        annotationConfigApplicationContext.close();
    }
    
    public static void springXmlLoad() {
        XmlWebApplicationContext xmlWebApplicationContext = new XmlWebApplicationContext();
        xmlWebApplicationContext.setConfigLocation("classpath:applicationContext.xml");
        xmlWebApplicationContext.refresh();
        System.out.println("------------------start get from XmlWebApplicationContext------------------");
        System.out.println(xmlWebApplicationContext.getBeanDefinitionCount());
        System.out.println(xmlWebApplicationContext.getBean("ProtoTypeClass"));
        System.out.println(xmlWebApplicationContext.getBean("ProtoTypeClass"));
        System.out.println(xmlWebApplicationContext.getBean("SingletonClass"));
        System.out.println(xmlWebApplicationContext.getBean("SingletonClass"));
        System.out.println(xmlWebApplicationContext.getBean("singletonClass"));
        System.out.println(xmlWebApplicationContext.getBean("singletonClass"));
        xmlWebApplicationContext.close();
        System.out.println("------------------end get from XmlWebApplicationContext------------------");

        System.out.println("------------------start get from ClassPathXmlApplicationContext------------------");
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println(classPathXmlApplicationContext.getBeanDefinitionCount());
        System.out.println(classPathXmlApplicationContext.getBean("ProtoTypeClass"));
        System.out.println(classPathXmlApplicationContext.getBean("ProtoTypeClass"));
        System.out.println(classPathXmlApplicationContext.getBean("SingletonClass"));
        System.out.println(classPathXmlApplicationContext.getBean("SingletonClass"));
        System.out.println(classPathXmlApplicationContext.getBean("singletonClass"));
        System.out.println(classPathXmlApplicationContext.getBean("singletonClass"));
        classPathXmlApplicationContext.close();
        System.out.println("------------------end get from ClassPathXmlApplicationContext------------------");
    }
}
