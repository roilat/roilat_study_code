package cn.roilat.study.java.basic.clazz;

public class TestClassMethod {
    public static void main(String[] args) {
        String[][][] strs = new String[][][] { { {} } };//{},{{}}都可以
        Class<?> clazz = strs.getClass();
        while (clazz.isArray()) {
            System.out.println(clazz);
            clazz = clazz.getComponentType();
        }
        System.out.println(clazz);
    }
}
