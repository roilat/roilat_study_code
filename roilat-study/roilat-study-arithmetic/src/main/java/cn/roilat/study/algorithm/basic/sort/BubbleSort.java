package cn.roilat.study.algorithm.basic.sort;

/**
 * 
 * 1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * 3、针对所有的元素重复以上的步骤，除了最后一个。
 * 4、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
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
        for (int i = end - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    exchange(a, j, j + 1);
                }
            }
        }
        System.out.println("end to do BubbleSort...");
    }
}
