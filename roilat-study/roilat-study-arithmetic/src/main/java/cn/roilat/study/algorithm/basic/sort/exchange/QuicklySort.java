package cn.roilat.study.algorithm.basic.sort.exchange;

import cn.roilat.study.algorithm.basic.sort.BaseSort;

/**
 * 
 * 1．先从数列中取出一个数作为基准数。
 * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
 * 3．再对左右区间重复第二步，直到各区间只有一个数。
 * 
 * @author roilat-J
 * @version $Id: QuicklySort.java, v 0.1 2018年6月29日 下午4:09:31 roilat-J Exp $
 */
public class QuicklySort extends BaseSort {

    /**
     * 升序
     * @see cn.roilat.study.algorithm.basic.sort.BaseSort#doSort(java.lang.Integer[], int, int, int)
     */
    @Override
    protected void doSort(Integer[] a, int pos, int len, int start) {
        System.out.println("start to do QuicklySort...");
        int end = pos + len;
        assert start <= end && pos <= start;
        int left = start, right = end - 1;
        doQuicklySort(a, left, right);
        System.out.println("end to do QuicklySort...");
    }

    private void doQuicklySort(Integer[] a, int start, int end) {
        if (start < end) {
            int pos = mpartition(a, start, end);
            doQuicklySort(a, start, pos);
            doQuicklySort(a, pos + 1, end);
        }
    }

    private int mpartition(Integer[] a, int left, int right) {
        int pivot = a[left];
        while (left < right) {
            while (left < right && a[right] >= pivot) {
                cycleTimes ++;//循环次数
                right--;
            }
            if (left < right) {//
                a[left++] = a[right];
                exchangeTimes++;
            }
            while (left < right && a[left] <= pivot) {
                cycleTimes ++;//循环次数
                left++;
            }
            if (left < right) {
                a[right--] = a[left];
                exchangeTimes++;
            }
        }
        a[left] = pivot;
        exchangeTimes++;
        return left;
    }
}
