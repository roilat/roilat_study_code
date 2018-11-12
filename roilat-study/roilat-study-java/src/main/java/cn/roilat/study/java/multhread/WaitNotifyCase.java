package cn.roilat.study.java.multhread;

import java.util.concurrent.TimeUnit;

public class WaitNotifyCase {

    public static void main(String[] args) {
        final Object lock = new Object();
        final StringBuilder sb = new StringBuilder();

        new Thread(new Runnable() {
            @Override
            public void run() {
                getPrintInfo(sb, "thread A is waiting to get lock;");
                synchronized (lock) {
                    try {
                        getPrintInfo(sb, "thread A get lock;");
                        TimeUnit.SECONDS.sleep(1);
                        getPrintInfo(sb, "thread A do wait method;");
                        lock.wait();
                        getPrintInfo(sb, "wait end;");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                getPrintInfo(sb, "thread B is waiting to get lock;");
                synchronized (lock) {
                    getPrintInfo(sb, "thread B get lock;");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                    getPrintInfo(sb, "thread B do notify method;");
                }
            }
        }).start();
        //thread A is waiting to get lock;thread A get lock;thread B is waiting to get lock;thread A do wait method;thread B get lock;thread B do notify method;wait end;

    }

    public static synchronized void getPrintInfo(StringBuilder sb, String str) {
        sb.append(str);
        System.out.println(sb.toString());
    }

}
