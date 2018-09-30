package cn.roilat.study.java.multhread.testjoinandcountdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 这种韬晦下，test1和test2即join和countdownlatch可以实现相同的功能，当时test3说明countdownlatch可以实现join无法实现的功能
 * 
 * @author roilat-J
 */
public class Test3 {

    public static Long start = System.currentTimeMillis();

    public static void main(String[] args) throws InterruptedException {
        // TODO 自动生成的方法存根

        CountDownLatch countDownLatch = new CountDownLatch(2);
        Worker3 worker0 = new Worker3("worker0", (long) (Math.random() * 2000 + 3000),
            countDownLatch);
        Worker3 worker1 = new Worker3("worker1", (long) (Math.random() * 2000 + 3000),
            countDownLatch);
        Worker3 worker2 = new Worker3("worker2", (long) (Math.random() * 2000 + 3000),
            countDownLatch);

        worker0.start();
        worker1.start();
        countDownLatch.await();

        print("准备工作就绪");
        worker2.start();

    }

    public static void print(String s) {
        Long end = System.currentTimeMillis();
        System.out.println(s + "(" + (end - start) + ")");
    }
}

/**
 * 工作者类
 */
class Worker3 extends Thread {

    // 工作者名
    private String         name;
    // 第一阶段工作时间
    private long           time;

    private CountDownLatch countDownLatch;

    public Worker3(String name, long time, CountDownLatch countDownLatch) {
        this.name = name;
        this.time = time;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        // TODO 自动生成的方法存根
        try {
            Test3.print(name + "开始工作");
            Thread.sleep(time);
            Test3.print(name + "第一阶段工作完成" + time);

            countDownLatch.countDown();

            Thread.sleep(5000); // 这里就姑且假设第二阶段工作都是要2秒完成
            Test3.print(name + "第二阶段工作完成");
            Test3.print(name + "工作完成，耗费时间=" + (time + 5000));

        } catch (InterruptedException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

}