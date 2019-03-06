package cn.roilat.study.testng;

import org.testng.annotations.Test;

public class DemoClassTest {
    @Test
    public void sayHello() {
        new DemoClass().sayHello();
    }
}
