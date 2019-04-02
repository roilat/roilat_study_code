package cn.roilat.study.java.multhread.threadpool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * 由于构造线程数据太多，系统开销太大，所以准备使用线程池，希望可以提高效率，时间从150秒提升到1.5秒
 * @author roilat-J
 * @version $Id: TestVolatile.java, v 0.1 2019年3月26日 下午3:35:53 roilat-J Exp $
 */
public class TestThreadPoolWithRunable {
    int a = 1;
    int b = 2;

    public void change() {
        a = 3;
        b = a;
    }

    static Map<String, AtomicInteger> map = new HashMap<String, AtomicInteger>();
    static {
        map.put("b=3;a=3", new AtomicInteger(0));
        map.put("b=2;a=1", new AtomicInteger(0));
        map.put("b=2;a=3", new AtomicInteger(0));
        map.put("b=3;a=1", new AtomicInteger(0));
    }

    public void print() {
        map.get("b=" + b + ";a=" + a).incrementAndGet();
    }

    /**
     * 当线程池设置成10, 15, 0时，报错：Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@27c170f0 rejected from java.util.concurrent.ThreadPoolExecutor@5451c3a8[Running, pool size = 13, active threads = 0, queued tasks = 0, completed tasks = 442]
     * blockQueue如果设置初始容量且较小时，会因为任务无法放入到队列中，又无法分配到work中
     * 
     * @param args
     */
    public static void main(String[] args) {
        int n = 1000000;
        long start = System.currentTimeMillis();
        BlockingQueue<Runnable> blockQueue = new LinkedBlockingQueue<Runnable>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 15, 0, TimeUnit.SECONDS,
            blockQueue);
        while (n-- > 0) {
            final TestThreadPoolWithRunable test = new TestThreadPoolWithRunable();
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    test.change();
                }
            });

            executor.submit(new Runnable() {
                @Override
                public void run() {
                    test.print();
                }
            });
        }
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println(TestThreadPoolWithRunable.map);
            }
        });
        executor.shutdown();
        System.out.println("complete shutdown,waiting for shutdown hook");
        System.out.println(System.currentTimeMillis() - start);
        while(Thread.activeCount() > 1);
        /**
         * complete shutdown,waiting for shutdown hook
         * 1344
         * {b=3;a=3=996521, b=2;a=3=7, b=2;a=1=3471, b=3;a=1=1}
         */
    }
}
