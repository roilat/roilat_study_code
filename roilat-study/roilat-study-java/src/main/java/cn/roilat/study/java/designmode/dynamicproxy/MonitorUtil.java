package cn.roilat.study.java.designmode.dynamicproxy;

public class MonitorUtil {

    private static ThreadLocal<Long> time = new ThreadLocal<Long>();

    public static void start() {
        time.set(System.currentTimeMillis());
    }

    public static void end() {
        System.out.println(
            "总计耗时：" + (time.get() == null ? 0 : (System.currentTimeMillis() - time.get()) / 1000));
    }
}
