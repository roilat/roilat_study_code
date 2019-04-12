package cn.roilat.study.java.basic.operator;

public class TestNegation {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(0x0000FFFF));//000000000 000000000 11111111 11111111
        System.out.println(Integer.toBinaryString(~0x0000FFFF));//11111111 11111111 000000000 000000000
    }
}
