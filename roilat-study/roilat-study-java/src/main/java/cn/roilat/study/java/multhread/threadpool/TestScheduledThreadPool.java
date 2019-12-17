package cn.roilat.study.java.multhread.threadpool;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 定时任务ScheduledThreadPoolExecutor的使用详解
 * https://cn.roilat.blog.csdn.net/wenzhi20102321/article/details/78681379
 * @author roilat-J
 * @version $Id: TestScheduledThreadPool.java, v 0.1 2019年4月17日 下午5:20:37 roilat-J Exp $
 */
public class TestScheduledThreadPool {
    public static void main(String[] args) throws InterruptedException {
        long executeTime = 30000;
        TestScheduledThreadPool pool = new TestScheduledThreadPool();
        pool.timer1();
        Thread.sleep(executeTime);
        pool.stopTimer1();
        pool.timer2();
        Thread.sleep(executeTime);
        pool.stopTimer2();
    }

    /**
     * 普通定时器
     */
    Timer        timer;
    volatile int time;
    volatile int total;           //定时执行总次数
    volatile int count;           //时间刚好合适的次数
    int          interval = 40;   //定时时间间隔
    int          delay    = 10000;//延时执行

    public void timer1() {
        timer = new Timer();

        timer.schedule(new TimerTask() {
            long last = System.currentTimeMillis();

            @Override
            public void run() {
                long cur = System.currentTimeMillis();
                long val = cur - last;
                if (val == interval) {
                    count++;
                }
                total++;
                //System.out.println(cur + "-" + val + " timer1:" + time++);//add
                last = cur;
            }
        }, delay, interval);//这里是另一个线程
        //System.out.println("total:"+total+",count:"+count);//这里是主线程，所以这样会返回一开始的值0，0,而且还会定时任务线程并发

    }

    /**
     * 停止定时器
     */
    public void stopTimer1() {
        System.out.println("stopTimer1 total:" + total + ",count:" + count);
        if (timer != null) {
            timer.cancel();
            timer = null;
            time = 0;
            total = 0;
            count = 0;
        }
    }

    /**
     * 稳定的定时器
     */
    ScheduledThreadPoolExecutor scheduled;

    public void timer2() {
        scheduled = new ScheduledThreadPoolExecutor(2);
        scheduled.scheduleAtFixedRate(new Runnable() {
            long last = System.currentTimeMillis();

            @Override
            public void run() {
                long cur = System.currentTimeMillis();
                long val = cur - last;
                if (val == interval) {
                    count++;
                }
                total++;
                //System.out.println(cur + "-" + val + " timer2:" + time++);//add
                last = cur;
            }
        }, delay, interval, TimeUnit.MILLISECONDS);
        //System.out.println("total:"+total+",count:"+count);//这里是主线程，所以这样会返回一开始的值,而且还会定时任务线程并发
    }

    /**
     * 停止定时器
     */
    public void stopTimer2() {
        System.out.println("stopTimer2 total:" + total + ",count:" + count);

        if (scheduled != null) {
            scheduled.shutdownNow();
            scheduled = null;
            time = 0;
            total = 0;
            count = 0;
        }
    }

}
