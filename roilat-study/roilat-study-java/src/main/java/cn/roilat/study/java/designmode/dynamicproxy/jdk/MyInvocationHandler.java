package cn.roilat.study.java.designmode.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import cn.roilat.study.java.designmode.dynamicproxy.MonitorUtil;

public class MyInvocationHandler implements InvocationHandler {

	private Object target;

	MyInvocationHandler() {
		super();
	}

	MyInvocationHandler(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//System.out.println(this.equals(proxy));
		if ("getName".equals(method.getName())) {
			System.out.println("++++++before " + method.getName() + "++++++");
			MonitorUtil.start();
			Object result = method.invoke(target, args);
			MonitorUtil.end();
			System.out.println("++++++after " + method.getName() + "++++++");
			return result;
		} else {
	          MonitorUtil.start();
			Object result = method.invoke(target, args);
	         MonitorUtil.end();

			return result;
		}
		
	}

}
