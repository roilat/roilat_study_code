package cn.roilat.study.jvm.mem;

public class TestStackOverflow {
    private static long count = 0;

    public static void main(String[] args) {
        System.out.println("no exception");
        try {
            infinitelyRecursiveMethod(1);
        } catch (Error e) {
            System.out.println("Error" + count);
        } catch (Exception e) {
            System.out.println("Exception" + count);
        }
    }

    public static void infinitelyRecursiveMethod(long a) {
        count++;
        infinitelyRecursiveMethod(a);
    }

}
