package cn.roilat.study.algorithm.basic.sort;

public class BinarySortTest extends BaseSortTest {

    public void testSort() {

        System.out.println("------testSort------");
        Integer[] array = { 15, 2, 49, 20, 11, 84, 44, 23, 41, 84, 12, 22 };
        printArray(array);
        new BinarySort().sort(array, 0, array.length,true);
        printArray(array);
        System.out.println("------testSort------");
    }

}
