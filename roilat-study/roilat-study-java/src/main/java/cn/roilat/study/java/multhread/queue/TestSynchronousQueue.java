package cn.roilat.study.java.multhread.queue;

import java.util.concurrent.SynchronousQueue;

public class TestSynchronousQueue {
    public static void main(String[] args) throws InterruptedException {
        final SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();

        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " put thread start");
                try {
                    queue.put(1);//数据被取走之前，不会向下执行,当前线程处理驻留状态，换句话说，应该不是阻塞状态
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName() + " put thread end");
            }
        });

        Thread takeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " take thread start");
                try {
                	Thread.sleep(5000);
                    System.out.println(
                        Thread.currentThread().getName() + " take from putThread: " + queue.take());
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                System.out.println(Thread.currentThread().getName() + " take thread end");
            }
        });

        putThread.start();
        takeThread.start();
        
    }

    /**
     * put thread tart
     * take thread start
     *	 等待5秒
     * put thread end
     * take from putThread: 1
     *	 等待5秒
     * take thread end
     * 
     */
}
