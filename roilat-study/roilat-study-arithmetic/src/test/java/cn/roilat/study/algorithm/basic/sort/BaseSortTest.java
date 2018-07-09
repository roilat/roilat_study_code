package cn.roilat.study.algorithm.basic.sort;

import java.util.Arrays;

import junit.framework.TestCase;

public class BaseSortTest extends TestCase {

    public void testRangeRevert() {
        System.out.println("------testRangeRevert------");
        Integer[] array = { 10, 2, 49, 20, 11, 84, 44, 23, 41, 84, 12, 22 };
        printArray(array);
        new BinarySort().rangeRevert(array, 0, array.length - 1);
        printArray(array);
        System.out.println("------testRangeRevert------");
    }

    public void printArray(Object[] o) {
        /*for (Object object : o) {
            System.out.print(object + " ");
        }
        System.out.println();*/
        System.out.println(Arrays.toString(o));
    }

    public void testExchange() {
        Integer[] a = { 12, 21 };
        System.out.printf("x=%d y=%d \n", a[0], a[1]);
        new BaseSort().exchange(a, 0, 1);
        System.out.printf("x=%d y=%d \n", a[0], a[1]);
    }

}
