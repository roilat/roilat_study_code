package cn.roilat.study.java.basic.override;

public class TestConstructorParamOverride {
    public static void main(String[] args) {
        new Demo();
        new Demo("hello");
        new Demo("hello",2);
        new Demo("hello",2,0xff);
    }
}

class Demo {
    public Demo(Object... objs) {
        System.out.println("start " + this.toString());
        for (Object object : objs) {
            System.out.println(object);
        }
        System.out.println("end  " + this.toString());
    }
}