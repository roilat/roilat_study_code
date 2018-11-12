package cn.roilat.study.spring.beans;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.core.StandardContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class Main {
    public static void main(String[] args) {
        XmlWebApplicationContext xmlWebApplicationContext = new XmlWebApplicationContext();
        xmlWebApplicationContext.setConfigLocation("classpath:applicationContext.xml");
        //xmlWebApplicationContext.refresh();
        System.out.println(xmlWebApplicationContext.getBeanDefinitionCount());
        System.out.println(xmlWebApplicationContext.getBean(""));
        xmlWebApplicationContext.close();
        /*      ContextLoaderListener contextLoaderListener = new ContextLoaderListener();
       ServletContext source = new ApplicationContext(new StandardContext());
        ServletContextEvent event = new ServletContextEvent(source );
        contextLoaderListener.contextInitialized(event);
        System.out.println(ContextLoaderListener.getCurrentWebApplicationContext());*/
    }
}
