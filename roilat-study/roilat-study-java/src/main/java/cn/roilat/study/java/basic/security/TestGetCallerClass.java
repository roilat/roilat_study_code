package cn.roilat.study.java.basic.security;

public class TestGetCallerClass {

    @SuppressWarnings({ "restriction", "deprecation" })
    public static void main(String[] args) {
        System.out.println(sun.reflect.Reflection.getCallerClass(1));//class cn.roilat.study.java.basic.security.TestGetCallerClass
        System.out.println(sun.reflect.Reflection.getCallerClass());
    }

}
