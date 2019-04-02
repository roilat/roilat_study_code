package cn.roilat.study.java.designmode.dynamicproxy.cglib;

import cn.roilat.study.java.designmode.dynamicproxy.UserService;
import cn.roilat.study.java.designmode.dynamicproxy.UserServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class InvokeTest {
	public static void main(String[] args) {
	    System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\mine\\code");
		CglibProxy cglibProxy = new CglibProxy();

		Enhancer enhancer = new Enhancer(); // 主要的增强类
		enhancer.setSuperclass(UserServiceImpl.class); // 设置父类，被增强的类
		enhancer.setCallback(cglibProxy); // 回调对象

		UserService o = (UserService) enhancer.create();// 用cglibProxy来增强UserServiceImpl
		System.out.println(o.getName(1));
		System.out.println(o.getAge(1));
		System.out.println(true ^ true);
	}
}
