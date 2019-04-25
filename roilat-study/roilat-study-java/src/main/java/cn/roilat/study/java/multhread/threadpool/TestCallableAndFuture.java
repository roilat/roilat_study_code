package cn.roilat.study.java.multhread.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class TestCallableAndFuture {

    public static void main(String[] args) {
        //创建线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        //创建Callable对象任务
        CallableDemo calTask = new CallableDemo();
        //提交任务并获取执行结果
        //Future<String> future = es.submit(calTask);
        FutureTask<String> futureTask=new FutureTask<>(calTask);
        es.submit(futureTask);
        //关闭线程池
        es.shutdown();
        try {
            while(es.isTerminated()) {
                Thread.sleep(1);
                System.out.println("sleep for 1 millionSecond");
            }
            System.out.println("主线程在执行其他任务");

            if (futureTask.get() != null) {
                //输出获取到的结果
                System.out.println("future.get()-->" + futureTask.get());
            } else {
                //输出获取到的结果
                System.out.println("future.get()未获取到结果");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("主线程在执行完成");
    }

}

class CallableDemo implements Callable<String> {

    private int sum;

    @Override
    public String call() throws Exception {
        System.out.println("Callable子线程开始计算啦！");
        Thread.sleep(2000);

        for (int i = 0; i < 5000; i++) {
            sum = sum + i;
        }
        System.out.println("Callable子线程计算结束！");
        return sum+"";
    }
}