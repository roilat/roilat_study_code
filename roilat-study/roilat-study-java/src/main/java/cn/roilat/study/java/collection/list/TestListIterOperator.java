package cn.roilat.study.java.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestListIterOperator {

    public static void main(String[] args) {
        test2();
        test1();
    }

    public static void test1() {
        List<String> list = new ArrayList<String>();
        list.add("str1");
        list.add("str2");
        list.add("str3");
        list.add("str4");
        Iterator<String> iter1 = list.iterator();
        //        Iterator<String> iter2 = list.iterator();//如果这行代码在这里，iter2中的expectedModCount被设置成0
        while (iter1.hasNext()) {
            if (iter1.next().equals("str3")) {
                iter1.remove();
            }
        }
        Iterator<String> iter2 = list.iterator();//iter2中的expectedModCount被设置成1
        while (iter2.hasNext()) {
            //会去检查modCount和expectedModCount是否一致，expectedModCount在得Iterator时就得到。
            //remove时会修改expectedModCount = modCount++;
            System.out.println(iter2.next());
        }
        char c = '（';
        char c1 = '(';
    }

    public static void test2() {
        List<String> list = new ArrayList<String>();
        list.add("str1");
        list.add("str2");
        list.add("str3");
        list.add("str4");
        Iterator<String> iter1 = list.iterator();
        while (iter1.hasNext()) {
            if (iter1.next().equals("str3")) {
                iter1.remove();
            }
        }
        for (String string : list) {
            System.out.println(string);
        }
    }
}
