package cn.roilat.study.algorithm.basic.datastructure;

import java.util.Arrays;

public class HeapDemo {
    public static void main(String[] args) {
        Integer[] array = { 10, 2, 49, 20, 11, 84, 44, 23, 41, 84, 12, 22 };
        System.out.println(Arrays.toString(array));
        Heap heap = new Heap(array);
        System.out.println(Arrays.toString(heap.toArray()));
    }
}

/**
 * 此堆为升序处理
 * 
 * @author roilat-J
 * @version $Id: HeapDemo.java, v 0.1 2018年7月9日 下午6:16:02 roilat-J Exp $
 */
class Heap {

    Integer[] array;

    public Heap(Integer[] array) {
        super();
        this.array = array;
        sort();
    }

    public Integer[] toArray() {
        return array;
    }

    public void pop() {

    }

    /**
     * @param pos
     */
    public void shiftDown(int pos) {
        int i = pos * 2 + 1;
        int n = array.length;
        while (i < n) {
            if (i + 1 < n && array[i + 1] < array[i]) {
                i++;
            }
            if (array[pos] > array[i]) {
                exchange(pos, i);
                i = i * 2 + 1;
            } else {
                break;
            }
        }
    }

    /**
     * 
     * @param pos
     */
    public void shiftUp(int pos) {
        int i = (pos - 1) >> 2;
        while (pos > 0 && i >= 0) {
            if (array[pos] < array[i]) {
                exchange(pos, i);
            }
            i = (i - 1) >> 2;
        }
    }

    protected void sort() {
        assert array != null && array.length > 0;
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {//(end-1)/2也是一样的
            sift(i, n - 1);
        }

        //交换并进行整理
        for (int i = n - 1; i >= 1; i--) {
            this.exchange(0, i);
            sift(0, i - 1);
        }
    }

    /**
     * 
     * 
     * @param a
     * @param x
     * @param y
     */
    protected void exchange(int x, int y) {
        array[x] = array[x] ^ array[y];//$x^$xy
        array[y] = array[x] ^ array[y];//$x^$y^$y=$x
        array[x] = array[x] ^ array[y];//$x^$y^$x=$y;y此时已经等于x的值；
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
    protected void sift(int low, int high) {
        int i = low, j = 2 * i + 1;
        int tmp = array[i];
        while (j <= high) {
            if (j < high && (j + 1) <= high && array[j] < array[j + 1])
                j++;//第二个子节点值较大
            if (tmp < array[j]) {//节点叶子大于预设值（父节点或者父节点的父节点），当前节点a[j]上移，由于预设值小于a[j],无法判断预设值是否大于a[j]的子节点，因此需要进一步处理
                array[i] = array[j];
                i = j;//i指向新的父节点是否有子节点，通过(i*2+1<=high可以判断)
                j = 2 * i + 1;//
            } else
                break;//如果当前当前节点（a[j]）小于预设值，跳出的原因是：a[j]要么是叶子节点，要么a[j]已经经过sift处理，作为父节点，自己的叶子节点值必然小于自己，也会小于预设值
        } //否则
        array[i] = tmp;
    }
}