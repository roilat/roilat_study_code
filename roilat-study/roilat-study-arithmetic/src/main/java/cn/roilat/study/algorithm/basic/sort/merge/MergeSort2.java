package cn.roilat.study.algorithm.basic.sort.merge;

import cn.roilat.study.algorithm.basic.sort.BaseSort;

/**
 * 归并排序
 * 
 * @author roilat-J
 * @version $Id: MergeSort.java, v 0.1 2018年7月2日 下午3:53:36 roilat-J Exp $
 */
public class MergeSort2 extends BaseSort {

    /**
     * 升序
     * @see cn.roilat.study.algorithm.basic.sort.BaseSort#doSort(java.lang.Integer[], int, int, int)
     */
    @Override
    protected void doSort(Integer[] a, int pos, int len, int start) {
        System.out.println("start to do MergeSort...");
        int end = pos + len;
        assert start <= end && pos <= start;
        if (end - start < 2) {
            return;
        }
        Integer[] temp = new Integer[end - start];
        merge_sort(a, start, end - 1,temp);
        System.out.println("end to do MergeSort...");
    }

    /**
     * 每次处理归并时，对整个数组按照2*length分成n/(2*length)部分，然后merge_two将2*length分成2段length长的数组进行归并
     * 
     * @param a
     * @param temp 
     * @param length
     * @param n
     */
    private void merge_sort(Integer a[], int start, int end, Integer[] temp) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge_sort(a, start, mid, temp); //左边有序
            merge_sort(a, mid + 1, end, temp); //右边有序
            mergeArray(a, start, mid, end, temp); //再将二个有序数列合并
        }
    }

    /**
     * 归并length长两相邻子表
     * 
     * @param a
     * @param low
     * @param mid
     * @param high
     * @param temp 
     */
    private void mergeArray(Integer a[], int low, int mid, int high, Integer[] temp) {

        int len = high - low + 1;
        int i = low, j = mid + 1;//两个有序区a[low]-a[mid] a[mid+1]-a[high]开始位置
        int k = 0;
        while (i <= mid && j <= high) {
            //i取的是前段，j取的是后段，为了稳定性(a[i]=a[j]时，先存放a[i]前段)，测试有效
            if (a[i] > a[j]) {
                temp[k] = a[j];
                j++;
                k++;
            } else {
                temp[k] = a[i];
                i++;
                k++;

            }
        }
        while (i <= mid) {
            temp[k] = a[i];
            i++;
            k++;
        }
        while (j <= high) {
            temp[k] = a[j];
            j++;
            k++;
        }
        for (k = 0, i = low; k < len; i++, k++)
            a[i] = temp[k];//将排序好的还原到a数组
    }

}
