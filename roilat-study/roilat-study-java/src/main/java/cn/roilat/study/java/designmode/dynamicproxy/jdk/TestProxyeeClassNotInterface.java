package cn.roilat.study.java.designmode.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理不能代理类,即生成的对象的静态类型一定要是接口（当然实际类型肯定不是一个类了）
 * 
 * @author roilat-J
 * @version $Id: TestProxyeeClassNotInterface.java, v 0.1 2019年4月12日 上午11:46:42 roilat-J Exp $
 */
public class TestProxyeeClassNotInterface {

    public static void main(String[] args) {
        BusiInterfaceDemo demo = new BusiInterfaceDemo() {
        };
        System.out.println(demo);
        testProxyClass();
        testProxyClassImplInterface();
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
                        //System.out.println("this is the proxy:" + proxy);
                        return method.invoke(busiClass, args);
                    }
                });
            proxyClass.sayHello();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void testProxyClassImplInterface() {
        try {
            BusiClassImplInterface busiClass = new BusiClassImplInterface();
            BusiClassImplInterface proxyClass = (BusiClassImplInterface) Proxy.newProxyInstance(
                busiClass.getClass().getClassLoader(), busiClass.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method,
                                         Object[] args) throws Throwable {
                        //System.out.println("this is the proxy:" + proxy);
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
                    //System.out.println("this is the proxy:" + proxy);
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

class BusiClassImplInterface implements BusiInterface {
    public void sayHello() {
        System.out.println("hello class");
    }
}
class BusiClass {
    public void sayHello() {
        System.out.println("hello class");
    }
}