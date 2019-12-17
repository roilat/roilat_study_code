package cn.roilat.study.algorithm.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 
 * @author roilat-J
 * @version $Id: HashTest.java, v 0.1 2019年4月23日 下午6:47:27 roilat-J Exp $
 */
public class HashTest {
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out
            .println("QMGBC".hashCode() + "-" + "QLfBC".hashCode() + "-" + "QLfAb".hashCode());
        /*
         * System.out.println("roilat".hashCode());
         * System.out.println("roilat".hashCode()); System.out.println(new
         * HashTest().hashCode()); System.out.println(new User().hashCode());
         * System.out.println(new Integer(123).hashCode());
         */
        /*
         * Random r1 = new Random(1L); Random r2 = new Random(1L);
         * System.out.println(r1.nextInt());//-1155869325
         * System.out.println(r2.nextInt());//-1155869325
         * System.out.println(r1.nextInt());//431529176
         * System.out.println(r2.nextInt());//431529176
         */

        System.out.println(
            "AYbRQMeUJJEBeQSMDD".hashCode() + "==" + "HIdPjDYYYGSMDCEFFHcjaPCgUGJaCf".hashCode());
        findTheSameHashCode();

        testForHashCollision();


    }

    /**
     * HASH COLLISION DOS 问题
    * https://coolshell.cn/articles/6424.html
     */
    public static void testForHashCollision() {
        /**
         * "AaAaAaAa", "AaAaBBBB", "AaAaAaBB", "AaAaBBAa",
         *"BBBBAaAa", "BBBBBBBB", "BBBBAaBB", "BBBBBBAa",
         *"AaBBAaAa", "AaBBBBBB", "AaBBAaBB", "AaBBBBAa",
         *"BBAaAaAa", "BBAaBBBB", "BBAaAaBB", "BBAaBBAa",
         */
        //所说如上18个内容的hashCode一样
        String[] ss = new String[] { "AaAaAaAa", "AaAaBBBB", "AaAaAaBB", "AaAaBBAa", "BBBBAaAa",
                                     "BBBBBBBB", "BBBBAaBB", "BBBBBBAa", "AaBBAaAa", "AaBBBBBB",
                                     "AaBBAaBB", "AaBBBBAa", "BBAaAaAa", "BBAaBBBB", "BBAaAaBB",
                                     "BBAaBBAa" };
        for (String string : ss) {
            System.out.println(string.hashCode());
        }
        //确实一样
    }

    private static char[] CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
        .toCharArray();

    /**
     * 查找多个hashcode相同的string,一般几百万次就能找到相同的，但是一般内存就会占用到几个G，建议不要使用HashMap.toString方法，因为hashMap已经很大了
     * 
     * 如output.txt的内容
     */
    public static void findTheSameHashCode() {
        class Item {
            public int          count    = 0;
            public int          hashCode = 0;
            public StringBuffer values   = new StringBuffer();

            @Override
            public String toString() {
                return "Item [count=" + count + ", hashCode=" + hashCode + ", values=" + values
                       + "]";
            }

        }
        Map<Integer, Item> map = new HashMap<Integer, Item>();
        int totalTimes = 0;
        while (true) {
            totalTimes++;
            String s = genRandomStr(5);//最小长度是5
            int hashCode = s.hashCode();
            if (map.size() > 0 && map.size() % 100000 == 0) {
                System.out.println(map.size());
            }
            Item item;
            if ((item = map.get(hashCode)) == null) {
                map.put(hashCode, item = new Item());
            }
            item.count++;
            item.hashCode = hashCode;
            item.values.append(s).append(",");
            if (item.count > 2) {//重试次数
                System.out.println(item);
                //System.out.println(map);
                System.out.println("totalTimes=" + totalTimes);
                Iterator<Integer> iter = map.keySet().iterator();
                while (iter.hasNext()) {
                    Integer i = iter.next();
                    if (map.get(i).count > 1) {
                        //System.out.println(map.get(i));
                    }
                }
                break;
            }
        }
    }

    public static String genRandomStr(int minLength) {
        int length = random.nextInt(32) + (minLength > 0 ? minLength : 0);
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < length; i++) {
            temp.append(CHARS[random.nextInt(36)]);
        }
        return temp.toString();
    }
}

class User {
    private String name;
    private String id;
    private String age;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (age == null) {
            if (other.age != null)
                return false;
        } else if (!age.equals(other.age))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

}