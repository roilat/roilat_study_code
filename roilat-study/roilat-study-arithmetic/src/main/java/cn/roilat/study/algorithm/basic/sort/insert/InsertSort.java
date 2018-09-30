package cn.roilat.study.algorithm.basic.sort.insert;

import cn.roilat.study.algorithm.basic.sort.BaseSort;

/**
 * 原始插入排序
 * 可分析知道，当原始数组就是从小到大排列时执行效率最高O（N）反之当数据基本反序时执行效率最差O（N^2），平均耗时O（N×N）,稳定
 * 
 * @author roilat-J
 * @version $Id: InsertSort.java, v 0.1 2018年6月29日 下午4:23:54 roilat-J Exp $
 */
public class InsertSort extends BaseSort {

    @Override
    public void doSort(Integer[] a, int pos, int len, int start) {
        System.out.println("start to do InsertSort...");

        int end = pos + len;
        assert pos <= start && start <= end;
        for (int i = start + 1; i < end; i++) {
            int temp = a[i];
            int j = i - 1;
            while (j >= start && a[j] > temp) {
                cycleTimes ++;
                exchangeTimes ++;
                a[j + 1] = a[j];
                j--;
            }
            exchangeTimes ++;
            a[j + 1] = temp;
        }
        System.out.println("start to do InsertSort...");

    }

}
