package cn.roilat.study.java.libs.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestLinkedList {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("aaa");
        list.add("aaa");
        list.add(1, "bbb");
        System.out.println(list);
        list = new ArrayList<>();
        list.add("aaa");
        list.add("aaa");
        list.add(0, "bbb");
        System.out.println(list);
    }

}
