package cn.roilat.study.jvm.mem;

public class TestStackOverflow {
    private static long count = 0;

    public static void main(String[] args) {
        System.out.println("no exception");
        infinitelyRecursiveMethod(1);
    }

    public static void infinitelyRecursiveMethod(long a) {
        System.out.println(count++);
        infinitelyRecursiveMethod(a);
    }

}
