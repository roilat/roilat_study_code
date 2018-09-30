package cn.roilat.study.algorithm.basic.sort.select;

import cn.roilat.study.algorithm.basic.sort.BaseSort;

/**
 * 堆排序
 * 堆排序中使用了两个巧妙的处理方法：
 * 1、从最后一个非叶子节点a[i = n/2-1]开始,两个子节点(2i+1,2i+2)[当不是叶子节点时]必然已被处理过(子节点小于父节点或者说子堆顶总是最大值)
 * 2、i--的节点总是非叶子节点.
 * (1)(2)成功保存子节点总是小于跟节点,且根节点是最大值;
 * 3.将根节点和数组最后一个数进行交换。然后通过sift保证a[0...n-2]内仍然符合a[r]>[a[2*r+1],a[2*r+2]]
 * 
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
     * 计算节点a[root]及所有子节点中最大的值
     * 计算过程中，依次将较大的值上移，将最a[root]放入合适的位置
     * PS:由于root是从最后一个非叶子节点开始，所以，a[root]下的所有其它非叶子节点下的数据必然是已经处理过的数据（子节点值小于父节点值）
     * 因为sift调用结束后，总能保证a[r]>[a[2*r+1],a[2*r+2]];
     * 
     * a[r]的子节点是a[2*r+1]和a[2*r+2]
     * @param a
     * @param root
     * @param end
     */
    public void sift(Integer[] a, int root, int end) {
        int r = root, biggerChild = 2 * r + 1;
        int rValue = a[r];
        while (biggerChild <= end) {
            cycleTimes++;
            if (biggerChild < end && (biggerChild + 1) <= end && a[biggerChild] < a[biggerChild + 1])
                biggerChild++;//第二个子节点值较大
            if (rValue < a[biggerChild]) {//节点叶子大于预设值(rValue)（父节点或者父节点的父节点），当前节点a[biggerChild]上移，由于预设值(rValue)小于a[biggerChild],无法判断预设值(rValue)是否大于a[biggerChild]的子节点，因此需要进一步处理
                exchangeTimes ++;
                a[r] = a[biggerChild];
                r = biggerChild;//i指向新的父节点是否有子节点，通过(i*2+1<=high可以判断)
                biggerChild = 2 * r + 1;
                //准备拿rValue和a[biggerChild]的子节点进行计算处理
            } else
                break;//如果当前当前节点（a[j]）小于预设值(rValue)，跳出的原因是：a[biggerChild]要么是叶子节点，要么a[biggerChild]已经经过sift处理，作为父节点，自己的叶子节点值必然小于自己，也会小于预设值(rValue)
        } //否则
        a[r] = rValue;//
    }

}
