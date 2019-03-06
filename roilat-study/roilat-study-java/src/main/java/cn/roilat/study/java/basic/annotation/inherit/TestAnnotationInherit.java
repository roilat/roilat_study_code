package cn.roilat.study.java.basic.annotation.inherit;

import java.lang.reflect.Method;

/**
 * @see cn.roilat.study.java.basic.annotation.inherit.Description 注解上申明了@Inherited后，
 * 当在父类中声明了注解后，子类可以继续该注解（只是类上可以继承，方法上的注解不可以继续）
 * 
 * 1、注解的继承是相对于类而言的，对于接口时无效的
 * 2、注解只继承父类的类注解，不继承方法注解 
 * @author roilat-J
 * @version $Id: TestAnnotationInherit.java, v 0.1 2019年1月30日 下午6:19:20 roilat-J Exp $
 */
public class TestAnnotationInherit {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        checkAnnotation(new Person());
        System.out.println("--------");
        checkAnnotation(new Child());
        /**
         * hello, Persion class
         * hello, Persion sayHello
         * --------
         * hello, Persion class
         */
    }

    public static void checkAnnotation(Person p) throws NoSuchMethodException, SecurityException {
        if (p.getClass().isAnnotationPresent(Description.class)) {
            Description d = p.getClass().getAnnotation(Description.class);
            System.out.println(d.value());
        }
        Method m;
        if ((m = p.getClass().getMethod("sayHello", new Class<?>[] {}))
            .isAnnotationPresent(Description.class)) {
            Description d = m.getAnnotation(Description.class);
            System.out.println(d.value());
        }
    }
}
