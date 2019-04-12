package cn.roilat.study.java.basic;

public class TestObjectInitialOrder {
    public String a;// = "1";
    {
        System.out.println("block:" + a);//当a="1"时，此为1，为null时这里是null
        a = "2";
    }

    public TestObjectInitialOrder() {
        System.out.println("constructor:" + a);
    }

    public static void main(String[] args) {
        /**
         * block:1
         * constructor:2
         * 由此说明：先申明处赋值，然后是代码块，最后是构造方法
         */
        new TestObjectInitialOrder();
    }
}
