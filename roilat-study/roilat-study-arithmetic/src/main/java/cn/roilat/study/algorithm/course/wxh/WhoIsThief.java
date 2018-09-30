package cn.roilat.study.algorithm.course.wxh;

import java.util.ArrayList;
import java.util.List;

/**
 * A说：“我不是小偷。”    x !=0
 * B说：“C 是小偷。”     x = 2
 * C说：“小偷肯定是 D。”  x = 3 
 * D说：“C 是在冤枉人。”  x != 3
 * 现在已经知道四个人中三个人说的是真话，一个人说了假话，请判断一下到底谁是小偷？
 * @author roilat-J
 * @version $Id: WhoIsThief.java, v 0.1 2018年9月7日 下午3:12:00 roilat-J Exp $
 */
public class WhoIsThief {

    public static void main(String[] args) {
        List<Suspectable> suspectors = new ArrayList<Suspectable>(4);
        suspectors.add((int x) -> {
            return x != 0 ? 1 : 0;
        });//A
        suspectors.add((int x) -> {
            return x == 2 ? 1 : 0;
        });//B
        suspectors.add((int x) -> {
            return x == 3 ? 1 : 0;
        });//C
        suspectors.add((int x) -> {
            return x != 3 ? 1 : 0;
        });//D

        boolean ifFoundThrief = false;
        for (int i = 0; i < 4; i++) {
            int n = 0;
            for (Suspectable suspectable : suspectors) {
                n += suspectable.defendOneSelf(i);
            }
            if (n == 3) {//三个人说真话
                System.out.println("小偷是：" + (char) ('A' + i));
                ifFoundThrief = true;
            }
        }
        if (!ifFoundThrief) {
            System.out.println("未发现小偷~~~");
        }
    }

}

interface Suspectable {
    /**
     * 假设真话，则返回1，否则返回0
     * 
     * @param x
     * @return
     */
    int defendOneSelf(int x);
}
