package cn.roilat.study.algorithm.basic.sort;

/**
 * 二分排序（属于插入排序，可以使用start参数）
 * 二分法插入排序是在插入第i个元素时，对前面的0～i-1元素进行折半，先跟他们中间的那个元素比，如果小，则对前半再进行折半，否则对后半进行折半，直到left>right，然后再把第i个元素前1位与目标位置之间的所有元素后移，再把第i个元素放在目标位置上。
 * 这里默认使用升序
 * 部分思想来源于{@link}java.util.ComparableTimSort
 * 
 * @author roilat-J
 * @version $Id: BinarySort.java, v 0.1 2018年6月29日 下午4:23:54 roilat-J Exp $
 */
public class BinarySort extends BaseSort {

    @Override
    public void doSort(Integer[] a, int pos, int len, int start) {
        System.out.println("start to do BinarySort...");

        int end = pos + len;
        assert pos <= start && start <= end;
        if (start == pos) {
            start++;
        }
        while (start < end) {
            int left = pos;
            int right = start;
            Integer pivot = a[start];
            while (left < right) {
                int mid = (left + right) / 2;
                if (pivot.compareTo(a[mid]) > 0) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            assert left == right;
            int n = start - left; // The number of elements to move
            // Switch is just an optimization for arraycopy in default case
            switch (n) {
                case 2:
                    a[left + 2] = a[left + 1];
                case 1:
                    a[left + 1] = a[left];
                    break;
                default:
                    System.arraycopy(a, left, a, left + 1, n);
            }
            a[left] = pivot;
            start++;
        }
        System.out.println("end to do BinarySort...");

    }

}
