package cn.roilat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import cn.roilat.biz.home.controller.BasicErrorController;

/**
 * @SpringBootApplication注解会扫描当前包及其子包
 * 
 * @author roilat-J
 * @version $Id: Application.java, v 0.1 2019年2月20日 下午3:10:47 roilat-J Exp $
 */
@SpringBootApplication
@ServletComponentScan("cn.roilat.framework.config.filter")
public class Application {

	@Autowired(required = false)
	private List<ErrorViewResolver> errorViewResolvers;
	private final ServerProperties serverProperties;

	public Application(ServerProperties serverProperties) {
		this.serverProperties = serverProperties;
	}

	@Bean
	public BasicErrorController basicErrorController(ErrorAttributes errorAttributes) {
		return new BasicErrorController(errorAttributes, this.serverProperties.getError(), this.errorViewResolvers);
	}

	@Bean
	public Runnable createRunnable() {
		return () -> {
			System.out.println("spring boot is running");
		};
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		applicationContext.getBean(Runnable.class).run();
	}
}
