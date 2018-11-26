package cn.roilat.study.java.string;

public class StringEquals {

    public static void main(String[] args) {
        String s = "abc";
        String obj1 = new String("abc");
        String obj2 = new String("abc");
        System.out.println(s == obj1);
        System.out.println(s == obj1.intern());
        System.out.println(s.intern().intern() == obj1.intern());
        System.out.println(new String("abc").equals(s));
        System.out.println("----------------------------obj1 vs obj2----------------------------");
        System.out.println("obj1 == obj2:" + (obj1 == obj2));
        System.out.println("obj1.intern() == obj2.intern():" + (obj1.intern() == obj2.intern()));
        System.out.println("obj1 == obj2.intern():" + (obj1 == obj2.intern()));
        System.out.println("obj1.intern() == obj2:" + (obj1.intern() == obj2));

    }

}
