package cn.roilat.study.java.multhread.createthread;

import java.util.concurrent.Callable;

public class CreateThread {
    public static void main(String[] args) {
        way1().start();
        way2().start();
        way3().start();
    }

    /**
     * 继承Thread类
     * 
     * @return
     */
    public static Thread way1() {
        return new Thread() {
            @Override
            public void run() {
                System.out.println("way2 Thread method");
            }
        };
    }

    /**
     * 实现Runable方法
     * @return
     */
    public static Thread way2() {
        return new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("way2 Runnable method");
            }
        }) {
            @Override
            public void run() {
                super.run();
                System.out.println("way2 Thread method");
            }
        };
    }

    /**
     * 实现Callable方法
     * @return
     * @throws Exception 
     */
    public static Thread way3() {
        Callable<String> task = new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println("Callable method");
                return "Callable method";
            }
        };
        return new Thread() {

            @Override
            public void run() {
                try {
                    System.out.println("Thread " + task.call());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
