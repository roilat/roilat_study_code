package cn.roilat;

import java.net.InetSocketAddress;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import tk.mybatis.mapper.autoconfigure.MapperCacheDisabler;
import tk.mybatis.spring.annotation.MapperScan;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * @SpringBootApplication注解会扫描当前包及其子包
 * 
 * @author roilat-J
 * @version $Id: Application.java, v 0.1 2019年2月20日 下午3:10:47 roilat-J Exp $
 */
@SpringBootApplication(scanBasePackages = { "cn.roilat.framework", "cn.roilat.modules" })
@MapperScan(basePackages = "cn.roilat.modules.**.mapper")
// @ServletComponentScan("cn.roilat.framework.core.filter")
public class Application {

	@Bean
	public Runnable createRunnable() {
		return () -> {
			System.out.println("spring boot is running");
		};
	}


	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		new Thread((Runnable) applicationContext.getBean("createRunnable")).start();
		startNetty(applicationContext);
	}

	/**
	 *
	 * @throws InterruptedException
	 */
	public static void startNetty(ConfigurableApplicationContext applicationContext) throws InterruptedException {
		ServerBootstrap bootstrap = applicationContext.getBean(ServerBootstrap.class);
		InetSocketAddress address = applicationContext.getBean(InetSocketAddress.class);
		ChannelFuture f = bootstrap.bind(address).sync();
		f.channel().closeFuture().sync();

	}

	@Bean
	public Object testBean(PlatformTransactionManager platformTransactionManager) {
		System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
		return new Object();
	}


}
