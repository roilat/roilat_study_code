package cn.roilat.study.java.basic.operator;

/**
 * int 类型交换似乎很快，Integer才感觉有点儿慢，但是不知道是不是有jvm优化的原因
 * 
 * @author roilat-J
 * @version $Id: TestExchangeSpeed.java, v 0.1 2018年9月30日 下午6:58:04 roilat-J Exp $
 */
public class TestExchangeSpeed {

    public static void main(String[] args) {
        Integer a = 100;
        Integer b = 200;
        //        exchange1(a,b);
        //        exchange2(a,b);
        //        exchange3(a,b);

        Integer times = 100000000;

        long startTime = 0;
        long endTime = 0;

        startTime = System.currentTimeMillis();
        for (Integer i = 0; i < times; i++) {
            exchange1(a, b);
        }
        endTime = System.currentTimeMillis();
        System.out.println("exchange1 cost:" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (Integer i = 0; i < times; i++) {
            exchange2(a, b);
        }
        endTime = System.currentTimeMillis();
        System.out.println("exchange2 cost:" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (Integer i = 0; i < times; i++) {
            exchange3(a, b);
        }
        endTime = System.currentTimeMillis();
        System.out.println("exchange3 cost:" + (endTime - startTime));
        
        /**
         * exchange1 cost:695
            exchange2 cost:236
            exchange3 cost:547
         */
    }

    public static void exchange1(Integer a, Integer b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        //System.out.println(a + "-" + b);
    }

    public static void exchange2(Integer a, Integer b) {
        Integer temp = a;
        a = b;
        b = temp;
        //System.out.println(a + "-" + b);
    }

    public static void exchange3(Integer a, Integer b) {
        a = a + b;
        b = a - b;
        a = a - b;
        //System.out.println(a + "-" + b);
    }
}
