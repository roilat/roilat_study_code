package cn.roilat.study.java.designmode.dynamicproxy.jdk.genproxy;

import java.io.FileOutputStream;

import cn.roilat.study.java.designmode.dynamicproxy.UserServiceImpl;

public class GenProxyClass {
    public static void main(String[] args) {
        doWork("D:/$Proxy0.class", "$Proxy0", UserServiceImpl.class.getInterfaces());
        //如下都能成功生成代理类,只是反编译工具生成的源码有问题是class{}
        doWork("D:/$Proxy1.class", "$Proxy1", new Class<?>[] { ClassA.class });//可以代理成功sayHello1
        doWork("D:/$Proxy2.class", "$Proxy2", new Class<?>[] { ClassB.class });//可以代理成功sayHello2
        doWork("D:/$Proxy3.class", "$Proxy3", new Class<?>[] { InterfaceA.class });//可以代理成功sayHelloA
        doWork("D:/$Proxy4.class", "$Proxy4", new Class<?>[] { InterfaceB.class });//可以代理成功sayHelloB
        doWork("D:/$Proxy5.class", "$Proxy5", ClassC.class.getInterfaces());//可以代理成功sayHelloA和sayHelloB
    }

    public static void doWork(String path, String className, Class<?>[] classes) {
        @SuppressWarnings("restriction")
        byte[] classFile = sun.misc.ProxyGenerator.generateProxyClass(className, classes);//
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (Exception e) {
            System.out.println("写文件错误");
        }
    }
}
