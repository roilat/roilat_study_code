package cn.roilat.study.java.multhread.testvolatile;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * b=3;a=3  19520
 * b=2;a=1  20393
 * b=2;a=3  10  说明volatile还是不行
 * volatile禁用代码重排后，不太可能出现b=3,a=1,但是b=2,a=3还是会出现的。
 *  * 循环1000000次大约需要用时大约2.6分钟多
 * @author roilat-J
 * @version $Id: TestVolatile.java, v 0.1 2019年3月26日 下午3:35:53 roilat-J Exp $
 */
public class TestVolatile2 {
    volatile int a = 1;
    volatile int b = 2;

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

    public static void main(String[] args) {
        int n = 1000000;
        long start = System.currentTimeMillis();
        while (n-- > 0) {
            final TestVolatile2 test = new TestVolatile2();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.change();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.print();
                }
            }).start();
        }
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println(TestVolatile2.map);
            }
        });
        System.out.println(System.currentTimeMillis() - start);
    }
}
