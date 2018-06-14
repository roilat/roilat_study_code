package cn.roilat.study.java.multhread.testvolatile;

import java.util.concurrent.CountDownLatch;

/**
 * 通过方法获取被volatile修辞的变量没有明显变化
 * 
 * @author roilat-J
 * @version $Id: TestGetVolatileWithMethod.java, v 0.1 2018年6月12日 下午6:00:24 roilat-J Exp $
 */
public class TestGetVolatileWithMethod {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        testNotVolatile(latch);
        testWithVolatile(latch);
        
        /*
        start test (field no volatile)
        Thread-0 the data is 10
        Thread-1 updated to 20
        Thread-0 the data is 20
        Thread-1 updated to 30
        Thread-0 the data is 30
        Thread-1 updated to 40
        Thread-0 the data is 40
        Thread-1 updated to 50
        Thread-0 the data is 50
        Thread-1 updated to 60
        start test (field with volatile)
        Thread-2 the data is 10
        Thread-3 updated to 20
        Thread-2 the data is 20
        Thread-3 updated to 30
        Thread-2 the data is 30
        Thread-3 updated to 40
        Thread-2 the data is 40
        Thread-3 updated to 50
        Thread-2 the data is 50
        Thread-3 updated to 60
*/
    }

    public static void testNotVolatile(CountDownLatch latch) {
        System.out.println("start test (field no volatile)");
        ParentData data = new subA();
        new Thread(new DoReadTask1(data, latch, true)).start();
        new Thread(new DoUpdateTask1(data, latch, true)).start();
    }

    public static void testWithVolatile(CountDownLatch latch) throws InterruptedException {
        latch.await();
        System.out.println("start test (field with volatile)");
        ParentData data = new subB();
        new Thread(new DoReadTask1(data, latch, false)).start();
        new Thread(new DoUpdateTask1(data, latch, false)).start();
    }
}

interface ParentData {

    public int getData();

    public void setData(int count);

    public int addData(int i);
}

class subA implements ParentData {
    public int data = 10;

    @Override
    public int getData() {
        return data;
    }

    @Override
    public void setData(int data) {
        this.data = data;
    }

    @Override
    public int addData(int i) {
        this.data += i;
        return this.data;
    }
}

class subB implements ParentData {
    public volatile int data = 10;

    @Override
    public int getData() {
        return data;
    }

    @Override
    public void setData(int data) {
        this.data = data;
    }

    @Override
    public int addData(int i) {
        this.data += i;
        return this.data;
    }
}

class DoReadTask1 implements Runnable {
    private ParentData     data;
    private CountDownLatch latch;
    private boolean        ifDoFirst;

    public DoReadTask1(ParentData data, CountDownLatch latch, boolean ifDoFirst) {
        super();
        this.data = data;
        this.latch = latch;
        this.ifDoFirst = ifDoFirst;
    }

    @Override
    public void run() {
        if (ifDoFirst) {
            doWork();
            latch.countDown();
        } else {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            doWork();
        }

    }

    private void doWork() {
        int n = 5;
        while (n-- > 0) {
            try {
                Thread.sleep(1000);
                System.out
                    .println(Thread.currentThread().getName() + " the data is " + data.getData());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DoUpdateTask1 implements Runnable {
    private ParentData     data;
    private CountDownLatch latch;
    private boolean        ifDoFirst;

    public DoUpdateTask1(ParentData data, CountDownLatch latch, boolean ifDoFirst) {
        super();
        this.data = data;
        this.latch = latch;
        this.ifDoFirst = ifDoFirst;
    }

    @Override
    public void run() {
        if (ifDoFirst) {
            doWork();
            latch.countDown();
        } else {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            doWork();
        }
    }

    private void doWork() {
        int n = 5;
        while (n-- > 0) {
            try {
                Thread.sleep(1000);
                System.out
                    .println(Thread.currentThread().getName() + " updated to " + data.addData(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}