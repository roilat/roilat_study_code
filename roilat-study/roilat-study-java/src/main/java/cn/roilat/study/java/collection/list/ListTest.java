package cn.roilat.study.java.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {

        }
        long start = System.currentTimeMillis();

        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(0, i);
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(0, i);
        }

        System.out.println(System.currentTimeMillis() - end);
        
        /**
         * 7
         * 1137
         */
    }
}
