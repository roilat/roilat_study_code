package cn.start.roilat.language;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InterruptedException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		System.out.println(new String("111").toString());
		Thread.sleep(10000);
		Class<?> cl = ClassLoader.getSystemClassLoader().loadClass("aaa");
		Method m = cl.getMethod("sayHello", String.class);
		Object o = m.invoke(cl.newInstance(), "roilat_ddd");
		System.out.println(o);
		
	}

}
