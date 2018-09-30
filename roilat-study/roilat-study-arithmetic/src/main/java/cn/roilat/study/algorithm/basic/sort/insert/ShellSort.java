package cn.roilat.study.algorithm.basic.sort.insert;

import cn.roilat.study.algorithm.basic.sort.BaseSort;

/**
 * 希尔排序
 * 其实质是缩小增量版的升级插入排序，核心是选择一个增量d（一般是以原始数组数目一般半为起始），剩下的类似直接插入排序，只不过每次从未排序中选择元素的增量d>1，完成一次排序后缩小增量d，直至d=1。
 * 这种平均耗时O（N log N），不稳定
 * @author roilat-J
 * @version $Id: ShellSort.java, v 0.1 2018年6月29日 下午4:23:54 roilat-J Exp $
 */
public class ShellSort extends BaseSort {

    @Override
    public void doSort(Integer[] a, int pos, int len, int start) {
        System.out.println("start to do ShellSort...");

        int end = pos + len;
        assert pos <= start && start <= end;
        int d = (end - start) / 2;
        while (d > 0) {
            for (int i = d; i < end; i++) {
                int temp = a[i];
                int j = i - d;
                while (j >= start && a[j] > temp) {
                    a[j + d] = a[j];
                    j -= d;
                }
                a[j + d] = temp;
            }
            d = d / 2;
        }
        System.out.println("start to do ShellSort...");

    }

}
