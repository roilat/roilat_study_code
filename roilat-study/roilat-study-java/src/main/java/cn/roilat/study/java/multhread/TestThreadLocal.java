package cn.roilat.study.java.multhread;

public class TestThreadLocal {
    private static ThreadLocal<String> data = new ThreadLocal<String>();

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                TestThreadLocal.testSetData();
                TestThreadLocal.testGetData();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                TestThreadLocal.testGetData();//预期：返回为空
            }
        }.start();

    }

    public static void testSetData() {
        System.out.println(Thread.currentThread().getName() + " set data... ");
        data.set(Thread.currentThread().getName());
    }

    public static void testGetData() {
        System.out.println(Thread.currentThread().getName() + " get data :" + data.get());
    }
}
