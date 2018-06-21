package cn.roilat.study.java.basic;

import java.util.Formatter;

public class StringAlignTest {
    private static Formatter f = new Formatter();
    public static void main(String[] args) {
        System.out.printf("%1$10s", "hello中文");
        System.out.println();
        
        //StringAlignTest.printTitle();
        StringAlignTest.print("xigua", 5, 10);
        StringAlignTest.print("bi", 2, 1.50);
        StringAlignTest.print("kuangquanshui", 6, 1);
        StringAlignTest.printTotal();
    }

    private static void print(String string, int i, double j) {
        System.out.print(f.format("%-15s %5d %8.2f\n", string, i, j));

    }

    public static void printTotal() {
        double total = 20;
        System.out.print(f.format("%-15s %5s %8.2f\n", "Tax", "", total  * 0.06));//百分比
        System.out.print(f.format("%-15s %5s %8s\n", "", " ", "-----"));
        System.out.print(f.format("%-15s %5s %8.2f\n", "Total", "", total * 1.06));
    }
}
