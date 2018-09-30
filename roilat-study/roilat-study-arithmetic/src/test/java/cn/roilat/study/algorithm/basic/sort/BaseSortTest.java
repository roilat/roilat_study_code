package cn.roilat.study.algorithm.basic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import cn.roilat.study.algorithm.basic.sort.exchange.BubbleSort;
import cn.roilat.study.algorithm.basic.sort.exchange.QuicklySort;
import cn.roilat.study.algorithm.basic.sort.exchange.SimpleBubbleSort;
import cn.roilat.study.algorithm.basic.sort.insert.BinaryInsertSort;
import cn.roilat.study.algorithm.basic.sort.insert.InsertSort;
import cn.roilat.study.algorithm.basic.sort.insert.ShellSort;
import cn.roilat.study.algorithm.basic.sort.merge.MergeSort;
import cn.roilat.study.algorithm.basic.sort.merge.MergeSort2;
import cn.roilat.study.algorithm.basic.sort.other.RadixSort;
import junit.framework.TestCase;

public class BaseSortTest extends TestCase {

    public void testRangeRevert() {
        System.out.println("------testRangeRevert------");
        Integer[] array = { 10, 2, 49, 20, 11, 84, 44, 23, 41, 84, 12, 22 };
        printArray(array);
        new BaseSort().rangeRevert(array, 0, array.length - 1);
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
    
    /**
     * 处理正序有效的数组，优化过的算法会更快些,如下测试也说明：数据比较也会浪费很多时间，
     * 而数据交换也会浪费更多的时候
     * @throws Exception
     */
    public void testBubbleSort() throws Exception {
        int len = 100000;
        Integer[] originArr = genArray(len);
        printArray(originArr);
        BaseSort quickSort = new QuicklySort();
        quickSort.sort(originArr, 0, len, false);//先让数据有序且正序
        printSortInfo(quickSort);

        SimpleBubbleSort simpleBubbleSort = new SimpleBubbleSort();
        simpleBubbleSort.sort(originArr, 0, len, false);
        printSortInfo(simpleBubbleSort);
        
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(originArr, 0, len, false);
        printSortInfo(bubbleSort);
        
        /**
            start to do QuicklySort...
            end to do QuicklySort...
            exchange.QuicklySort waste time is :23,cycleTimes:5193728,exchangeTimes:544563
            start to do SimpleBubbleSort...
            end to do SimpleBubbleSort...
            exchange.SimpleBubbleSort waste time is :3561,cycleTimes:704982704,exchangeTimes:0
            start to do BubbleSort...
            end to do BubbleSort...
            exchange.BubbleSort waste time is :4,cycleTimes:99999,exchangeTimes:0
         */

    }

    /**
     * 如果数据基本有序时,效率和冒泡应该差不多
     * @throws Exception 
     */
    public void testQuickSort() throws Exception {
        int len = 100000;
        Integer[] originArr = genArray(len);
        printArray(originArr);
        BaseSort quickSort = new QuicklySort();
        System.out.println("快速排序处理无序数据：");
        quickSort.sort(originArr, 0, len, false);
        printArray(originArr);
        printSortInfo(quickSort);
        System.out.println("快速排序处理有序且正序数据：");
        quickSort.sort(originArr, 0, len, false);
        printSortInfo(quickSort);
        System.out.println("快速排序处理有序且反序数据：");
        printArray(originArr);
        quickSort.rangeRevert(originArr, 0, len-1);
        quickSort.sort(originArr, 0, len, false);
        printArray(originArr);
        printSortInfo(quickSort);
        
        System.out.println("冒泡排序的效果是这样：");
        originArr = genArray(len);
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(originArr, 0, len, false);
        printSortInfo(bubbleSort);

        /**
        快速排序处理无序数据：
        start to do QuicklySort...
        end to do QuicklySort...
        exchange.QuicklySort waste time is :36,cycleTimes:5193728,exchangeTimes:544563
        快速排序处理有序且正序数据：
        start to do QuicklySort...
        end to do QuicklySort...
        exchange.QuicklySort waste time is :6703,cycleTimes:710176432,exchangeTimes:644562
        快速排序处理有序且反序数据：
        start to do QuicklySort...
        end to do QuicklySort...
        exchange.QuicklySort waste time is :5353,cycleTimes:1415209178,exchangeTimes:794519
        冒泡排序的效果是这样：
        start to do BubbleSort...
        end to do BubbleSort...
        exchange.BubbleSort waste time is :71880,cycleTimes:704381000,exchangeTimes:-1791581051
        */
    }

    public void testSortAll() throws Exception {
        List<BaseSort> sortList = new ArrayList<BaseSort>();
        sortList.add(new BubbleSort());
        sortList.add(new SimpleBubbleSort());
        sortList.add(new QuicklySort());
        sortList.add(new BinaryInsertSort());
        sortList.add(new InsertSort());
        sortList.add(new ShellSort());
        sortList.add(new MergeSort());
        sortList.add(new MergeSort2());
        sortList.add(new RadixSort());
        doTestSort(1000, sortList);
        /**
        cn.roilat.study.algorithm.basic.sort.exchange.BubbleSort waste time is :14
        cn.roilat.study.algorithm.basic.sort.exchange.SimpleBubbleSort waste time is :11
        cn.roilat.study.algorithm.basic.sort.exchange.QuicklySort waste time is :1
        cn.roilat.study.algorithm.basic.sort.insert.BinaryInsertSort waste time is :1
        cn.roilat.study.algorithm.basic.sort.insert.InsertSort waste time is :4
        cn.roilat.study.algorithm.basic.sort.insert.ShellSort waste time is :1
        cn.roilat.study.algorithm.basic.sort.merge.MergeSort waste time is :1
        cn.roilat.study.algorithm.basic.sort.merge.MergeSort2 waste time is :1
        cn.roilat.study.algorithm.basic.sort.other.RadixSort waste time is :3
         */
        doTestSort(10000, sortList);
        /**
        cn.roilat.study.algorithm.basic.sort.exchange.BubbleSort waste time is :571
        cn.roilat.study.algorithm.basic.sort.exchange.SimpleBubbleSort waste time is :506
        cn.roilat.study.algorithm.basic.sort.exchange.QuicklySort waste time is :2
        cn.roilat.study.algorithm.basic.sort.insert.BinaryInsertSort waste time is :10
        cn.roilat.study.algorithm.basic.sort.insert.InsertSort waste time is :92
        cn.roilat.study.algorithm.basic.sort.insert.ShellSort waste time is :6
        cn.roilat.study.algorithm.basic.sort.merge.MergeSort waste time is :3
        cn.roilat.study.algorithm.basic.sort.merge.MergeSort2 waste time is :2
        cn.roilat.study.algorithm.basic.sort.other.RadixSort waste time is :6
         */
        doTestSort(100000, sortList);
        /**
        cn.roilat.study.algorithm.basic.sort.exchange.BubbleSort waste time is :68029
        cn.roilat.study.algorithm.basic.sort.exchange.SimpleBubbleSort waste time is :69720
        cn.roilat.study.algorithm.basic.sort.exchange.QuicklySort waste time is :14
        cn.roilat.study.algorithm.basic.sort.insert.BinaryInsertSort waste time is :528
        cn.roilat.study.algorithm.basic.sort.insert.InsertSort waste time is :6780
        cn.roilat.study.algorithm.basic.sort.insert.ShellSort waste time is :27
        cn.roilat.study.algorithm.basic.sort.merge.MergeSort waste time is :19
        cn.roilat.study.algorithm.basic.sort.merge.MergeSort2 waste time is :15
        cn.roilat.study.algorithm.basic.sort.other.RadixSort waste time is :28
         */
    }

    private void doTestSort(int len, List<BaseSort> sortList) throws Exception {
        Integer[] originArr = genArray(len);
        printArray(originArr);
        for (BaseSort baseSort : sortList) {
            Integer[] arr = new Integer[len];
            System.arraycopy(originArr, 0, arr, 0, len);
            baseSort.sort(arr, 0, arr.length, false);
            //printArray(arr);

        }

        for (BaseSort baseSort : sortList) {
            printSortInfo(baseSort);
        }

    }

    private Integer[] genArray(int len) {
        if (len <= 0)
            return new Integer[0];
        Integer[] ret = new Integer[len];
        Random random = new Random(1000L);
        for (int i = 0; i < len; i++) {
            ret[i] = random.nextInt(1000);
        }
        return ret;
    }

    private void printSortInfo(BaseSort baseSort) {
        System.out.println(
            baseSort.getClass().getName().replace("cn.roilat.study.algorithm.basic.sort.", "")
                           + " waste time is :" + baseSort.timeCost + ",cycleTimes:"
                           + baseSort.cycleTimes + ",exchangeTimes:" + baseSort.exchangeTimes);
    }

}
