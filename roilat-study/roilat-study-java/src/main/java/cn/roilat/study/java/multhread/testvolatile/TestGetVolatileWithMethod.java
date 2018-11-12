package cn.roilat.study.java.multhread.testvolatile;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 通过方法获取被volatile修辞的变量没有明显变化
 * 
 * @author roilat-J
 * @version $Id: TestGetVolatileWithMethod.java, v 0.1 2018年6月12日 下午6:00:24 roilat-J Exp $
 */
public class TestGetVolatileWithMethod {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        testNotVolatile(latch);
        latch = new CountDownLatch(1);
        testWithVolatile(latch);
        latch = new CountDownLatch(1);
        testWithAtomicInteger(latch);

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
        ParentData data = new SubA();
        new Thread(new DoUpdateTask1(data, latch, true)).start();
        new Thread(new DoReadTask1(data, latch, true)).start();
        try {
            Thread.sleep(1000);
            latch.countDown();
            System.out.println("start test (field no volatile)");
            System.out.println(data.getPrintInfo());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testWithVolatile(CountDownLatch latch) throws InterruptedException {
        ParentData data = new SubB();
        new Thread(new DoUpdateTask1(data, latch, false)).start();
        new Thread(new DoReadTask1(data, latch, false)).start();
        try {
            Thread.sleep(1000);
            latch.countDown();
            System.out.println("start test (field with volatile)");
            System.out.println(data.getPrintInfo());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testWithAtomicInteger(CountDownLatch latch) throws InterruptedException {
        ParentData data = new SubC();
        new Thread(new DoUpdateTask1(data, latch, false)).start();
        new Thread(new DoReadTask1(data, latch, false)).start();
        try {
            Thread.sleep(1000);
            latch.countDown();
            System.out.println("start test (field with AtomicInteger)");
            System.out.println(data.getPrintInfo());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

interface ParentData {

    public int getData();

    public void setData(int count);

    public int addData(int i);

    public void append(String s);

    public String getPrintInfo();

}

class SubA implements ParentData {
    public int            data = 10;
    private StringBuilder sb   = new StringBuilder();

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

    public synchronized void append(String s) {
        sb.append(s);
    }

    public String getPrintInfo() {
        return sb.toString();
    }
}

class SubB implements ParentData {
    public volatile int   data = 10;
    private StringBuilder sb   = new StringBuilder();

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

    public synchronized void append(String s) {
        sb.append(s);
    }

    public String getPrintInfo() {
        return sb.toString();
    }

}

class SubC implements ParentData {
    public AtomicInteger  data = new AtomicInteger(10);
    private StringBuilder sb   = new StringBuilder();

    @Override
    public int getData() {
        return data.get();
    }

    @Override
    public void setData(int count) {
        data.set(count);
    }

    @Override
    public int addData(int i) {
        return data.addAndGet(i);
    }

    public synchronized void append(String s) {
        sb.append(s);
    }

    public String getPrintInfo() {
        return sb.toString();
    }
}

class DoReadTask1 implements Runnable {
    private ParentData       data;
    protected CountDownLatch latch;
    protected boolean        ifDoFirst;

    public DoReadTask1(ParentData data, CountDownLatch latch, boolean ifDoFirst) {
        super();
        this.data = data;
        this.latch = latch;
        this.ifDoFirst = ifDoFirst;
    }

    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doWork();
    }

    private void doWork() {
        int n = 5;
        while (n-- > 0) {
            synchronized (this) {
                data.append(
                    Thread.currentThread().getName() + " the data is " + data.getData() + "\n");
            }
        }
    }
}

class DoUpdateTask1 implements Runnable {
    private ParentData       data;
    protected CountDownLatch latch;
    protected boolean        ifDoFirst;

    public DoUpdateTask1(ParentData data, CountDownLatch latch, boolean ifDoFirst) {
        super();
        this.data = data;
        this.latch = latch;
        this.ifDoFirst = ifDoFirst;
    }

    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doWork();
    }

    private void doWork() {
        int n = 5;
        while (n-- > 0) {
            synchronized (this) {
                data.append(Thread.currentThread().getName() + " updated to " + data.addData(10) + "\n");
            }
        }
    }
}