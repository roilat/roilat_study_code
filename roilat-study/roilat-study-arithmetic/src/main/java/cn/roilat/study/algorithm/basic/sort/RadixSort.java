package cn.roilat.study.algorithm.basic.sort;

/**
 * 基数排序
 * 
 * @author roilat-J
 * @version $Id: RadixSort.java, v 0.1 2018年7月2日 下午3:53:36 roilat-J Exp $
 */
public class RadixSort extends BaseSort {

    /**
     * 升序
     * @see cn.roilat.study.algorithm.basic.sort.BaseSort#doSort(java.lang.Integer[], int, int, int)
     */
    @Override
    protected void doSort(Integer[] a, int pos, int len, int start) {
        System.out.println("start to do RadixSort...");
        int end = pos + len;
        assert start <= end && pos <= start;
        int n = end - start;
        if (n < 2) {
            return;
        }
        radix(a, n, 10);
        System.out.println("end to do RadixSort...");
    }

    /**
     * 
     * 
     * @param a 数组
     * @param n 数组长度
     * @param d 进制
     */
    private void radix(Integer a[], int n, int d) {

        Ele[] tp = new Ele[10];
        Ele[] tail = new Ele[10];
        Ele p;
        int i, j, k;
        //从低位到高位做d趟排序
        for (i = d - 1; i >= 0; i--) {
            for (j = 0; j < 10; j++) {
                tp[j] = tail[j] = null;
            }
            for (k = 0; k < n; k++) {
                int res = getRes(a[k], d, i + 1);// 获得该未数字 
                Ele s = new Ele();
                s.key = a[k];
                s.next = null;
                if (tp[res] == null) {
                    tp[res] = s;
                    tail[res] = s;
                } else {
                    tail[res].next = s;
                    tail[res] = s;
                }

            }
            //完成一趟排序后,收集
            k = 0;
            for (j = 0; j < 10; j++)
                if (tp[j] != null) {
                    p = tp[j];
                    while (p != null) {
                        a[k++] = p.key;
                        p = p.next;
                    }
                }
        }
    }

    private int getRes(int a, int d, int i) {
        if (i < 1 || i > d)
            return -1;
        int j = i;
        int res;
        do {
            res = a % 10;
            a = a / 10;
            j++;
        } while (j <= d);
        return res;
    }// 得到指定位数字

    class Ele {
        int key;
        Ele next;

    }
}
