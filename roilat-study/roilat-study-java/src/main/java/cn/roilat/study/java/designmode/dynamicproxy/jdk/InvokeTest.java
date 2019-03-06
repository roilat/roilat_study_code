package cn.roilat.study.java.designmode.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import cn.roilat.study.java.designmode.dynamicproxy.UserService;
import cn.roilat.study.java.designmode.dynamicproxy.UserServiceImpl;
import sun.misc.ProxyGenerator;

/**
 * 动态代理中，Proxy.newProxyInstance方法会调用 Class<?> cl = getProxyClass0(loader, intfs);该方法是从
 * WeakCache<ClassLoader, Class<?>[], Class<?>>
        proxyClassCache = new WeakCache<>(new KeyFactory(), new ProxyClassFactory());中获取一个Class<?>,这个结果由ProxyClassFactory的apply产生.
 * 其中的核心代码是根据传入的接口调用ProxyGenerator.generateProxyClass()方法生成一个继承了java.lang.reflect.Proxy类,且实现了上述接口的代理类的byte[]
 * 然后通过private static native Class<?> defineClass0(ClassLoader loader, String name,byte[] b, int off, int len);方法返回一个class即保存在内存的一个Class.
 * 类似于classLoader加载了个java文件,得到字节流后,通过protected final Class<?> defineClass(String name, byte[] b, int off, int len)生成Class<?>信息返回
 * 
 * @author roilat-J
 * @version $Id: InvokeTest.java, v 0.1 2019年2月12日 下午5:47:23 roilat-J Exp $
 */
public class InvokeTest {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        // 创建一个InvocationHandler，描述我们希望代理者执行哪些操作
        InvocationHandler invocationHandler = new MyInvocationHandler(userService);
        System.out.println(userService);
        
        System.out.println(Proxy.getProxyClass(userService.getClass().getClassLoader(), userService.getClass().getInterfaces()));//class com.sun.proxy.$Proxy0
        System.out.println(Proxy.getProxyClass(userService.getClass().getClassLoader(), userService.getClass().getInterfaces()));//class com.sun.proxy.$Proxy0
        System.out.println(Proxy.getProxyClass(userService.getClass().getClassLoader(), userService.getClass().getInterfaces()));//class com.sun.proxy.$Proxy0
        // 通过刚才创建的InvocationHandler，创建真正的代理者。第一个参数是类加载器，第二个参数是这个代理者实现哪些接口(与被代理者实现的是相同的接口)
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(
            userService.getClass().getClassLoader(), userService.getClass().getInterfaces(),
            invocationHandler);
        System.out.println(userServiceProxy);//cn.roilat.study.java.designmode.dynamicproxy.UserServiceImpl@28d93b30
        userServiceProxy = (UserService) Proxy.newProxyInstance(
            userService.getClass().getClassLoader(), userService.getClass().getInterfaces(),
            invocationHandler);
        System.out.println(userServiceProxy);//cn.roilat.study.java.designmode.dynamicproxy.UserServiceImpl@28d93b30
        System.out.println("***************normal invoke***************");
        System.out.println("result is:" + userService.getName(1));
        System.out.println("result is:" + userService.getAge(1));
        System.out.println("***************normal invoke***************");
        System.out.println("***************dynamic invoke***************");
        System.out.println("result is:" + userServiceProxy.getName(1));
        System.out.println("result is:" + userServiceProxy.getAge(1));
        System.out.println("***************dynamic invoke***************");
    }

}
