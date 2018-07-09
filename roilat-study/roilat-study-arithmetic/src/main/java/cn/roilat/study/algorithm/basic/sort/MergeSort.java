package cn.roilat.study.algorithm.basic.sort;

/**
 * 归并排序
 * 
 * @author roilat-J
 * @version $Id: MergeSort.java, v 0.1 2018年7月2日 下午3:53:36 roilat-J Exp $
 */
public class MergeSort extends BaseSort {

    /**
     * 升序
     * @see cn.roilat.study.algorithm.basic.sort.BaseSort#doSort(java.lang.Integer[], int, int, int)
     */
    @Override
    protected void doSort(Integer[] a, int pos, int len, int start) {
        System.out.println("start to do MergeSort...");
        int end = pos + len;
        assert start <= end && pos <= start;
        int n = end - start;
        if (n < 2) {
            return;
        }
        /**
         * 长度每次*2，从1开始,l为归并两个数组时的长度,l必定小于数组长度，
         * 例如数组长度为9时，当l=8时，merge_1已经完成对数组的归并排序，所以当l=16不满足条件时，数组完成排序，不需要再处理
         */
        for (int l = 1; l < n; l *= 2)
            merge_1(a, l, n);

        System.out.println("end to do MergeSort...");
    }

    /**
     * 每次处理归并时，对整个数组按照2*length分成n/(2*length)部分，然后merge_two将2*length分成2段length长的数组进行归并
     * 
     * @param a
     * @param length
     * @param n
     */
    private void merge_1(Integer a[], int length, int n) {
        int i = 0;
        /**
         * 第一区间：i~(i+length-1)
         * 第二区间：(i+length)~(i+length*2-1)
         * 每次移动2*length，由于length始终小于n,由于i + 2 * length - 1 < n，所以两个区间总是满的
         * 当i + length - 1 < n说明第一区间满的，第二不区间不满甚至可以为空。
         * 
         */
        for (; i + 2 * length - 1 < n; i += 2 * length)
            merge_two(a, i, i + length - 1, i + 2 * length - 1);
        /**
         * 例如n=9,length=4时，会出现i=8时跳出for循环，此时i+length-1=13<9不成立，则不会进行，剩余部分将会在length=8时进行处理
         * 处理剩余数据的长度介于length和2*length之间的数据
         */
        if (i + length - 1 < n)
            merge_two(a, i, i + length - 1, n - 1);//处理最后两个子表
    }

    /**
     * 归并length长两相邻子表
     * 
     * @param a
     * @param low
     * @param mid
     * @param high
     */
    private void merge_two(Integer a[], int low, int mid, int high) {

        int len = high - low + 1;
        Integer[] pt = new Integer[len];
        int i = low, j = mid + 1;//两个有序区a[low]-a[mid] a[mid+1]-a[high]开始位置
        int k = 0;
        while (i <= mid && j <= high) {
            //i取的是前段，j取的是后段，为了稳定性(a[i]=a[j]时，先存放a[i]前段)，测试有效
            if (a[i] > a[j]) {
                pt[k] = a[j];
                j++;
                k++;
            } else {
                pt[k] = a[i];
                i++;
                k++;

            }
        }
        while (i <= mid) {
            pt[k] = a[i];
            i++;
            k++;
        }
        while (j <= high) {
            pt[k] = a[j];
            j++;
            k++;
        }
        for (k = 0, i = low; k < len; i++, k++)
            a[i] = pt[k];//将排序好的还原到a数组
    }

}
