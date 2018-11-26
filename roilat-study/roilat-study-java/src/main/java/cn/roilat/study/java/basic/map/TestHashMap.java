package cn.roilat.study.java.basic.map;

public class TestHashMap {

    public static void main(String[] args) {
        testTableSizeFor(19);
    }
    public static void testTableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
    }
}
