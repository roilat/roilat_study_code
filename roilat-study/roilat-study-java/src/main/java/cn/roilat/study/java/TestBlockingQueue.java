package cn.roilat.study.java;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestBlockingQueue {
    public static void main(String[] args) {

    }

    public static void testPut() {
        BlockingQueue<Integer> bq = new LinkedBlockingQueue<>(100);

        new Thread() {
            @Override
            public void run() {
            }
        }.start();
        ;
    }
}
