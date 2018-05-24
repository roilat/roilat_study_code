package cn.roilat.study.java.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import cn.roilat.study.java.proxy.UserService;
import cn.roilat.study.java.proxy.UserServiceImpl;

public class InvokeTest {

	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		// 创建一个InvocationHandler，描述我们希望代理者执行哪些操作
		InvocationHandler invocationHandler = new MyInvocationHandler(userService);
		// 通过刚才创建的InvocationHandler，创建真正的代理者。第一个参数是类加载器，第二个参数是这个代理者实现哪些接口(与被代理者实现的是相同的接口)
		UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
				userService.getClass().getInterfaces(), invocationHandler);
		System.out.println("***************normal invoke***************");
		System.out.println(userService.getName(1));
		System.out.println(userService.getAge(1));
		System.out.println("***************normal invoke***************");
		System.out.println("***************dynamic invoke***************");
		System.out.println(userServiceProxy.getName(1));
		System.out.println(userServiceProxy.getAge(1));
		System.out.println("***************dynamic invoke***************");
	}

}
