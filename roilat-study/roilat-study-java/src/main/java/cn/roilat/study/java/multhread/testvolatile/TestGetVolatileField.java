package cn.roilat.study.java.multhread.testvolatile;

import java.util.concurrent.CountDownLatch;

/**
 * 直接获取变量试试
 * TODO 测试未果
 * @author roilat-J
 * @version $Id: TestGetVolatileField.java, v 0.1 2018年6月12日 下午5:59:57 roilat-J Exp $
 */
public class TestGetVolatileField {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        testNotVolatile(latch);
        testWithVolatile(latch);
    }

    public static void testNotVolatile(CountDownLatch latch) {
        System.out.println("start test (field no volatile)");
        Data data = new Data();
        new Thread(new DoReadTask(data, latch, true)).start();
        new Thread(new DoUpdateTask(data, latch, true)).start();
    }

    public static void testWithVolatile(CountDownLatch latch) throws InterruptedException {
        latch.await();
        System.out.println("start test (field with volatile)");
        Data data = new Data();
        new Thread(new DoReadTask(data, latch, false)).start();
        new Thread(new DoUpdateTask(data, latch, false)).start();
    }
}

class Data {
    public int data = 10;
}

class DoReadTask implements Runnable {
    private Data           data;
    private CountDownLatch latch;
    private boolean        ifDoFirst;

    public DoReadTask(Data data, CountDownLatch latch, boolean ifDoFirst) {
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
                System.out.println(Thread.currentThread().getName() + " the data is " + data.data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DoUpdateTask implements Runnable {
    private Data           data;
    private CountDownLatch latch;
    private boolean        ifDoFirst;

    public DoUpdateTask(Data data, CountDownLatch latch, boolean ifDoFirst) {
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
                    .println(Thread.currentThread().getName() + " updated to " + (data.data += 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}