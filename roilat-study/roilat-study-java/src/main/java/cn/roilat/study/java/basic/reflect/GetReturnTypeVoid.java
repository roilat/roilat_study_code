package cn.roilat.study.java.basic.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class GetReturnTypeVoid {

    public static void main(String[] args) throws NoSuchMethodException, SecurityException,
                                           InstantiationException, IllegalAccessException,
                                           IllegalArgumentException, InvocationTargetException {
        System.out.println(GetReturnTypeVoid.class.getMethod("hello", new Class<?>[] {})
            .getReturnType().isPrimitive());
        System.out.println(Void.class.getConstructors().length);//0
        Constructor<?> constructor = Void.class.getConstructor(new Class<?>[] {});
        if (!constructor.isAccessible()) {
            constructor.setAccessible(true);
        }
        Void void1 = (Void) constructor.newInstance(new Object[] {});
        System.out.println(void1.toString());
    }

    public void hello() {

    }
}
