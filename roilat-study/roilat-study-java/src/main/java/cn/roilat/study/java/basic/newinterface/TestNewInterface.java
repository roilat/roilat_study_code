package cn.roilat.study.java.basic.newinterface;

public class TestNewInterface {
    public static void main(String[] args) {
        System.out.println(new MyInterface<TestNewInterface>() {
            @Override
            public TestNewInterface run() {
                return new TestNewInterface();
            }
        });
    }
}

interface MyInterface<T>{
    T run();
}
