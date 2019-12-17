package cn.roilat.study.algorithm.basic;

import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

/**
 * 从两个有序数组的笛卡尔积中找出第N大数
 * TODO 未实现
 * @author roilat-J
 * @version $Id: TestNthValueInCartesianProduct.java, v 0.1 2019年4月24日 下午5:18:37 roilat-J Exp $
 */
public class TestNthValueInCartesianProduct {

    public static void main(String[] args) {
        int[] a1 = { 1, 3, 5, 7, 8, 9 };
        int[] a2 = { 2, 4, 6, 7, 8, 9 };
        System.out.println(query(a1, a2, 7));
        System.out.println(getAllValues(a1, a2));
    }

    /**
     * 考虑两个数组是升序的
     * 
     * @param arrayA
     * @param arrayB
     * @param n
     * @return
     */
    public static int query(int[] arrayA, int[] arrayB, int n) {
        assertNotNull(arrayA);
        assertNotNull(arrayB);
        int lenA, lenB;
        assertTrue(n <= (lenA = arrayA.length) * (lenB = arrayB.length));
        int result = arrayA[0] * arrayB[0];
        for (int i = 0, j = 0; --n > 0 && i < lenA - 1 && j < lenB - 1;) {
            int tmpA = arrayA[i] * arrayB[j + 1];
            int tmpB = arrayA[i + 1] * arrayB[j];
            if (tmpA > tmpB) {
                result = tmpB;
                j++;
            } else {
                result = tmpA;
                i++;
            }
        }
        return result;
    }

    public static String getAllValues(int[] arrayA, int[] arrayB) {
        assertNotNull(arrayA);
        assertNotNull(arrayB);
        int lenA = arrayA.length, lenB = arrayB.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lenA; i++) {
        }
        return sb.toString();
    }
}
