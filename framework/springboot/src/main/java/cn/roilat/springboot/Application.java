package cn.roilat.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @SpringBootApplication注解会扫描当前包及其子包
 * 
 * @author roilat-J
 * @version $Id: Application.java, v 0.1 2019年2月20日 下午3:10:47 roilat-J Exp $
 */
@SpringBootApplication
//@ServletComponentScan("cn.roilat.framework.config.filter")这个需要spring-boot-starter-web组件
public class Application {

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

