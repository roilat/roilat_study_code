package cn.roilat.study.java.basic.reflect;

import java.lang.reflect.InvocationTargetException;

public class TestConstructor {
public TestConstructor(TestConstructorParam testConstructorParam) {
    
}
    
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Class<?> c = TestConstructor.class;
        System.out.println(c.getConstructor(TestConstructorParam.class).newInstance(new Object[] {null}));
    }
}
class TestConstructorParam{
    public void doAnyThing() {
        System.out.println("doAnyThing");
    }
}