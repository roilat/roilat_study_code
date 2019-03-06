package cn.roilat.study.java.designmode.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.roilat.study.java.designmode.dynamicproxy.MonitorUtil;

/**
 * 基于动态代理的链式编程
 * 
 * @author roilat-J
 * @version $Id: DynamicProxyTest2.java, v 0.1 2019年2月12日 下午6:54:29 roilat-J Exp $
 */
public class DynamicProxyTest3 {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException,
                                           IllegalAccessException, IllegalArgumentException,
                                           InvocationTargetException {
        InterfaceA interfaceA = new ClassA();
        InterfaceA proxyClass = getProxyClass(interfaceA);
        proxyClass.setName("roilat").setID("id").setAge("age");
        System.out.println(proxyClass);
        System.out.println(interfaceA);
    }

    /**
     * 
     * @param obj           原(被代理)对象
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     */
    @SuppressWarnings("unchecked")
    public static <T> T getProxyClass(T obj) throws IllegalAccessException,
                                             IllegalArgumentException, InvocationTargetException {
        //获取代理对象
        Object proxyObj = Proxy.newProxyInstance(obj.getClass().getClassLoader(),
            obj.getClass().getInterfaces(), new InvocationHandler() {
                //TODO 为什么这个参数proxy不能用？，可以做为返回
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    MonitorUtil.start();
                    //do pre operate

                    Object result = method.invoke(obj, args);//使用obj而不是proxy
                    //do post opreate
                    MonitorUtil.end(method.getName());
                    
                    return checkReturnThis(obj,method.getReturnType()) ? proxy : result;//这里不返回result,而要返回proxy,否则后续方法不会走代理对象的方法
                }
                private boolean checkReturnThis(Object obj,Class<?> returnClass) {
                    Class<?> temp = obj.getClass();
                    List<Class<?>> list = new ArrayList<>(Arrays.asList(temp.getInterfaces()));
                    if(returnClass.equals(temp)) {
                        return true;
                    }
                    while ((temp = temp.getSuperclass()) != null && !temp.equals(Object.class)) {
                        list.addAll(Arrays.asList(temp.getInterfaces()));
                        if (temp.equals(obj.getClass())) {
                            return true;
                        }
                    }
                    for (Class<?> class1 : list) {
                        if (returnClass.equals(class1)) {
                            return true;
                        }
                    }
                    return false;
                }
            });
        return (T) proxyObj;
    }
}

interface InterfaceA {
    InterfaceA setName(String name);

    InterfaceA setID(String id);

    InterfaceA setAge(String age);
}

class ClassA implements InterfaceA {
    private String name;
    private String Id;
    private String age;

    @Override
    public InterfaceA setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public InterfaceA setID(String id) {
        this.Id = id;
        return this;
    }

    @Override
    public InterfaceA setAge(String age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "ClassA [name=" + name + ", Id=" + Id + ", age=" + age + "]";
    }

}
