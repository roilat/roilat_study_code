package cn.roilat.study.java.designmode.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxyeeClassNotInterface {

    public static void main(String[] args) {
        BusiInterfaceDemo demo = new BusiInterfaceDemo() {
        };
        System.out.println(demo);
        testProxyClass();
        testProxyInterface();
    }

    public static void testProxyClass() {
        try {
            BusiClass busiClass = new BusiClass();
            BusiClass proxyClass = (BusiClass) Proxy.newProxyInstance(
                busiClass.getClass().getClassLoader(), busiClass.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method,
                                         Object[] args) throws Throwable {
                        System.out.println("this is the proxy:" + proxy);
                        return method.invoke(busiClass, args);
                    }
                });
            proxyClass.sayHello();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testProxyInterface() {

        BusiInterface busiInterface = new BusiInterface() {

            @Override
            public void sayHello() {
                System.out.println("hello interface");
            }

        };
        BusiInterface proxyClass = (BusiInterface) Proxy.newProxyInstance(
            busiInterface.getClass().getClassLoader(), busiInterface.getClass().getInterfaces(),
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("this is the proxy:" + proxy);
                    return method.invoke(busiInterface, args);
                }
            });
        proxyClass.sayHello();

    }

}

interface BusiInterfaceDemo {
}

interface BusiInterface {
    public void sayHello();
}

class BusiClass {
    public void sayHello() {
        System.out.println("hello class");
    }
}