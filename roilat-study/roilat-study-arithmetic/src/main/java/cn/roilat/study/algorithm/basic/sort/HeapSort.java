package cn.roilat.study.algorithm.basic.sort;

/**
 * 堆排序
 * 堆排序中使用了两个英雄巧妙的处理方法：
 * 1、从最后一个非叶子节点a[i = n/2-1]开始,两个子节点(2i+1,2i+2)[当不是叶子节点时]必然已被处理过(子节点小于父节点或者说子堆顶总是最大值)
 * 2、i--的节点总是非叶子节点，
 * 
 * 
 * @author roilat-J
 * @version $Id: HeapSort.java, v 0.1 2018年6月29日 下午4:23:54 roilat-J Exp $
 */
public class HeapSort extends BaseSort {

    @Override
    public void doSort(Integer[] a, int pos, int len, int start) {
        System.out.println("start to do HeapSort...");

        int end = pos + len - 1;
        assert pos <= start && start <= end;

        /**
         * 初始构造
         * 先建立堆,从最后非叶子开始,结果中，堆顶/子堆顶总是大于子节点
         */
        for (int i = (end - 1) / 2; i >= 0; i--) {//end = n - 1;(end-1)/2=n/2-1;
            sift(a, i, end);
        }
        //交换并进行整理
        for (int i = end; i >= 1; i--) {
            this.exchange(a, 0, i);
            sift(a, 0, i - 1);
        }

        System.out.println("start to do HeapSort...");

    }

    /**
     * 计算节点a[low]及所有子节点中最大的值
     * 计算过程中，依次将较大的值上移，将最a[low]放入合适的位置
     * PS:由于low是从最后一个非叶子节点开始，所以，a[low]下的所有其它非叶子节点下的数据必然是已经处理过的数据（子节点值小于父节点值）
     * 
     * @param a
     * @param low
     * @param high
     */
    public void sift(Integer[] a, int low, int high) {
        int i = low, j = 2 * i + 1;
        int tmp = a[i];
        while (j <= high) {
            if (j < high && (j + 1) <= high && a[j] < a[j + 1])
                j++;//第二个子节点值较大
            if (tmp < a[j]) {//节点叶子大于预设值（父节点或者父节点的父节点），当前节点a[j]上移，由于预设值小于a[j],无法判断预设值是否大于a[j]的子节点，因此需要进一步处理
                a[i] = a[j];
                i = j;//i指向新的父节点是否有子节点，通过(i*2+1<=high可以判断)
                j = 2 * i + 1;//
            } else
                break;//如果当前当前节点（a[j]）小于预设值，跳出的原因是：a[j]要么是叶子节点，要么a[j]已经经过sift处理，作为父节点，自己的叶子节点值必然小于自己，也会小于预设值
        } //否则
        a[i] = tmp;
    }

}
