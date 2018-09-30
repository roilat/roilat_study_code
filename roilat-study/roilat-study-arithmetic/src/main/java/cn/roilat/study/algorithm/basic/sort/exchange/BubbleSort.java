package cn.roilat.study.algorithm.basic.sort.exchange;

import cn.roilat.study.algorithm.basic.sort.BaseSort;

/**
 * 冒泡排序
 * 1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * 3、针对所有的元素重复以上的步骤，除了最后一个。
 * 4、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * 
 * 优化：某一轮结束位置为j，但是这一轮的最后一次交换发生在lastSwap的位置，则lastSwap到j之间是排好序的，下一轮的结束点就不必是j--了，而直接到lastSwap即可
 * 
 * @author roilat-J
 * @version $Id: BubbleSort.java, v 0.1 2018年6月29日 下午4:09:31 roilat-J Exp $
 */
public class BubbleSort extends BaseSort {

    /**
     * 升序
     * @see cn.roilat.study.algorithm.basic.sort.BaseSort#doSort(java.lang.Integer[], int, int, int)
     */
    @Override
    protected void doSort(Integer[] a, int pos, int len, int start) {
        System.out.println("start to do BubbleSort...");
        int end = pos + len;
        assert start <= end && pos <= start;
        //作为优化，数组长度为12，如果第n(n<12)次在第6个数之后未发生交换，且知第六个数为前5个数中最大的数，可知后边的数据必然已经排好序，所以不必再j--而是直接跳到lastSwap所在的位置。
        for (int lastSwap, i = end - 1; i > start; i = lastSwap) {
          //每一轮要初始化为0，防止某一轮未发生交换，lastSwap保留上一轮的值进入死循环,如果i=lastSwap=10时，未进行交换(如下下次未交换，说明已排好序，不再执行i=n(n<10的情况)，未优化的冒泡排序还要分别执行i=(9,8,7,6...1的循环))，则i=lastSwap仍然=10，则下次还会如此
            lastSwap = 0;
            for (int j = start; j < i; j++) {
                cycleTimes ++;//循环次数
                if (a[j] > a[j + 1]) {
                    exchange(a, j, j + 1);
                    lastSwap = j;//最后一次交换位置的坐标
                }
            }
        }
        System.out.println("end to do BubbleSort...");
    }
}
