package cn.roilat.study.algorithm.basic.sort.select;

import cn.roilat.study.algorithm.basic.sort.BaseSort;

/**
 * 选择排序：每一次从待排序的数据元素中选出最小（或最大）的一个元素，
 * 存放在序列的起始位置，直到全部待排序的数据元素排完。
 * 
 * @author roilat-J
 * @version $Id: SelectSort.java, v 0.1 2018年7月2日 下午3:53:36 roilat-J Exp $
 */
public class SelectSort extends BaseSort {

    /**
     * 升序
     * @see cn.roilat.study.algorithm.basic.sort.BaseSort#doSort(java.lang.Integer[], int, int, int)
     */
    @Override
    protected void doSort(Integer[] a, int pos, int len, int start) {
        System.out.println("start to do SelectSort...");
        int end = pos + len;
        assert start <= end && pos <= start;
        for (int i = start; i < end - 1; i++) {
            int k = i;
            for (int j = i + 1; j < end; j++) {
                cycleTimes++;
                if (a[k] > a[j]) {
                    k = j;
                }
            }
            if(k != i) {
                exchange(a, k, i);
            }
        }
        System.out.println("end to do SelectSort...");
    }
}
