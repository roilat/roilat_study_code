package cn.roilat.study.algorithm.basic.sort;

public class BubbleSortTest extends BaseSortTest {

    public void testSort() {

        System.out.println("------testSort------");
        Integer[] array = { 10, 2, 49, 20, 11, 84, 44, 23, 41, 84, 12, 22 };
        printArray(array);
        new BubbleSort().sort(array, 0, array.length);
        printArray(array);
        System.out.println("------testSort------");
    }

}
