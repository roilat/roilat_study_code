package cn.roilat.study.java.basic.runtime;

public class TestRuntimeMemory {
    public static void main(String[] args) {
        System.out.println("freeMemory：" + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "MB");
        System.out.println("totalMemory：" + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "MB");
        System.out.println("maxMemory：" + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "MB");
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        /**
         * JDK1.8;win7-64位;8G内存
         * 默认情况：
         * freeMemory：120MB
         * totalMemory：123MB
         * maxMemory：1794MB
         * 
         * 设置：-Xmx100M -Xms20M
         * freeMemory：18MB
         * totalMemory：19MB
         * maxMemory：89MB
         * 
         * -Xmx1024M -Xms512M
         * freeMemory：483MB
         * totalMemory：491MB
         * maxMemory：910MB
         * 
         * -Xmx4096M -Xms512M
         * freeMemory：483MB
         * totalMemory：491MB
         * maxMemory：3641MB
         */
    }
}
