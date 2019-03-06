package cn.roilat.study.java.designmode.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import cn.roilat.study.java.designmode.dynamicproxy.MonitorUtil;
import cn.roilat.study.java.designmode.dynamicproxy.UserService;
import cn.roilat.study.java.designmode.dynamicproxy.UserServiceImpl;

/**
 * 所以不一定要为每一个类写一个InvocationHandler实现，可以多个类共用一个
 * 
 * @author roilat-J
 * @version $Id: DynamicProxyTest2.java, v 0.1 2019年2月12日 下午6:54:29 roilat-J Exp $
 */
public class DynamicProxyTest2 {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException,
                                           IllegalAccessException, IllegalArgumentException,
                                           InvocationTargetException {
        UserService userService = new UserServiceImpl();
        UserService proxyClass = getProxyClass(userService);
        System.out.println(proxyClass.getAge(123));
        System.out.println(proxyClass.getName(123));
    }

    /**
     * 
     * @param obj           原对象
     * @param method    原对象的方法
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
                    return result;
                }
            });
        return (T) proxyObj;
    }
}
