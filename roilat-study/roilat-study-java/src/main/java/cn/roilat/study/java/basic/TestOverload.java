package cn.roilat.study.java.basic;

public class TestOverload {

    public static void main(String[] args) {
        test1("str1","str2");
    }

    public static void test1(String s1, String s2) {
        System.out.println("test1----" + s1 + s2);
    }

    public static void test1(String... s) {
        StringBuffer sb = new StringBuffer();
        for (String string : s) {
            sb.append(s).append(",");
        }
        System.out.println("test2----" + sb.toString());
    }
}
