package cn.roilat.study.java.multhread;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomicInteger {

    static AtomicInteger ai = new AtomicInteger();

    public static void main(String[] args) {
        //test1();
        //test2();
        test4();
    }

    public static void test1() {
        /**
         * 1、由于阻塞队列没有限制大小，导致在执行在主线程执行shutdown之前，所有任务都放到了队列中。然后执行了2s多时间，
         * 2、将队列长度设置10000，则理论上，在主线程完成线程池关闭时，队列中10+ms只执行了10(线程)*10+ms个任务，加上队列10000，总计10000+100+
         * 错误信息：阻塞队列放不下了：Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@330bedb4 rejected from java.util.concurrent.ThreadPoolExecutor@2503dbd3[Running, pool size = 20, active threads = 20, queued tasks = 10000, completed tasks = 55]
         * 3、当任务放入了10000条时，主线程休息会儿再放入任务，会发现主线程使用时间是：main thread cost:1022
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 0, TimeUnit.MINUTES,
            new LinkedBlockingDeque<>(10000));
        int len = 20000;//10个线程一起合计休眠时候约20000*1/1000/10=2s左右
        int i = 0;
        long start = System.currentTimeMillis();
        for (; i < len; i++) {
            if (i > 0 && i % 10000 == 0) {
                try {
                    Thread.sleep(1000);//1w个任务执行时间大概需要1s(10个线程)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            threadPoolExecutor.submit(new Callable<String>() {

                @Override
                public String call() throws Exception {
                    Thread.sleep(1);
                    ai.incrementAndGet();
                    return null;
                }
            });
        }
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("result=" + ai.get());
                System.out.println("total cost:" + (System.currentTimeMillis() - start));//主进程只使用了2020ms
                threadPoolExecutor.shutdown();
            }

        }));
        System.out.println("i = " + i);
        System.out.println("main thread cost:" + (System.currentTimeMillis() - start));//主进程只使用了11ms
        threadPoolExecutor.shutdown();

    }

    public static void test2() {
        /**
         * 1、由于阻塞队列没有限制大小，导致在执行在主线程执行shutdown之前，所有任务都放到了队列中。然后执行了2s多时间，
         * 2、将队列长度设置10000，当任务放入了10000条时，主线程关闭线程池，则理论上，在主线程完成线程池关闭时，队列中10+ms只执行了10(线程)*10+ms个任务，加上队列10000，总计10000+100+
         * 且此时主线程应该是无法再提交任务了
         * Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task java.util.concurrent.FutureTask@1b6d3586 rejected from java.util.concurrent.ThreadPoolExecutor@4554617c[Shutting down, pool size = 10, active threads = 10, queued tasks = 9932, completed tasks = 58]
         * 9932+58=9990，再加上各个线程中真正执行的10个任务。即总计10001个任务无法加入了。因为线程池已经关闭了，此时不能再加任务，但是我们可以写了RejectedExecutionHandler
         * 之后，后续的添加操作又任务执行了10000次（i=20000），每次并未真正添加成功(输出10000次的sorry ,the thread pool will stop the work )，因为result=10000，只执行了此次添加到队列中的任务。
         * 
         * i = 20000
         * main thread cost:147
         * result=10000
         * total cost:1027
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 0, TimeUnit.MINUTES,
            new LinkedBlockingDeque<>(10000), new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    System.out.println("sorry ,the thread pool will stop the work ");
                }
            });
        int len = 20000;
        int i = 0;
        long start = System.currentTimeMillis();
        for (; i < len; i++) {
            if (i > 0 && i % 10000 == 0) {
                threadPoolExecutor.shutdown();
            }
            threadPoolExecutor.submit(new Callable<String>() {

                @Override
                public String call() throws Exception {
                    Thread.sleep(1);
                    ai.incrementAndGet();
                    return null;
                }
            });
        }
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("result=" + ai.get());
                System.out.println("total cost:" + (System.currentTimeMillis() - start));//主进程只使用了2020ms
            }
        }));
        System.out.println("i = " + i);
        System.out.println("main thread cost:" + (System.currentTimeMillis() - start));//主进程只使用了11ms
        threadPoolExecutor.shutdown();

    }

    public static void test3() {
        /**
         * sorry ,the thread pool will stop the work 
         * sorry ,the thread pool will stop the work 
         * sorry ,the thread pool will stop the work 
         * sorry ,the thread pool will stop the work 
         * sorry ,the thread pool will stop the work 
         * sorry ,the thread pool will stop the work
         * i = 20000
         * main thread cost:611
         * result=20000
         * total cost:1013
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 0, TimeUnit.MINUTES,
            new LinkedBlockingDeque<>(10000), new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    try {
                        System.out.println("sorry ,the thread pool will stop the work ");
                        Thread.sleep(100);//添加任务失败后，等待100毫秒，大约可以完成1000条任务，10000个任务要抛出9-10次异常，实际只出现6次异常
                        executor.submit(r);//再次提交
                    } catch (InterruptedException e2) {
                    }
                }
            });
        int len = 20000;
        int i = 0;
        long start = System.currentTimeMillis();
        for (; i < len; i++) {
            threadPoolExecutor.submit(new Callable<String>() {

                @Override
                public String call() throws Exception {
                    Thread.sleep(1);
                    ai.incrementAndGet();
                    return null;
                }
            });
        }
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("result=" + ai.get());
                System.out.println("total cost:" + (System.currentTimeMillis() - start));//主进程只使用了2020ms
            }
        }));
        //这样做的目的是：等所以线程执行完毕后，关闭线程池
        System.out.println("i = " + i);
        System.out.println("main thread cost:" + (System.currentTimeMillis() - start));//主进程只使用了11ms
        threadPoolExecutor.shutdown();

    }

    public static void test4() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 0, TimeUnit.MINUTES,
            new LinkedBlockingDeque<>());
        int len = 20000;
        int i = 0;
        long start = System.currentTimeMillis();
        /**
         * i = 20000
         * main thread cost:19
         * result=19995
         * failTimes=5
         * total cost:33
         */
        AtomicInteger failTimes = new AtomicInteger(-1);//默认-1
        for (; i < len; i++) {
            threadPoolExecutor.submit(new Callable<String>() {

                @Override
                public String call() throws Exception {
                    //ai.set(ai.get()+1); //get出来之后就无法保证原子性了，计算结果小于20000，即和volatile效果一样，只能保证可见性，原子性保证不了
                    int old;
                    int n = -1;
                    do {
                        old = ai.get();
                        n++;
                    } while (!ai.compareAndSet(old, old + 1));//如此来保证数据安全
                    failTimes.addAndGet(n);
                    if (n > 0) {
                        System.out.println("the outdated data is:" + old + ",the retry times is:" + n);
                    }

                    return null;
                }
            });
        }
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("result=" + ai.get());
                System.out.println("failTimes=" + failTimes.get());
                System.out.println("total cost:" + (System.currentTimeMillis() - start));//主进程只使用了2020ms
            }
        }));
        //这样做的目的是：等所以线程执行完毕后，关闭线程池
        System.out.println("i = " + i);
        System.out.println("main thread cost:" + (System.currentTimeMillis() - start));//主进程只使用了11ms
        threadPoolExecutor.shutdown();

    }
}
