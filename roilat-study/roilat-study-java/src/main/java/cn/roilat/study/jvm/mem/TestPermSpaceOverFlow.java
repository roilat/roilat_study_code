package cn.roilat.study.jvm.mem;

import java.util.ArrayList;
import java.util.List;

/**
 * 启动VM参数：
 * -XX:MaxPermSize=16m(这个参数jvm1.8没什么用)
 * -Xmx512m
 * @author roilat-J
 * @version $Id: TestPermSpaceOverFlow.java, v 0.1 2018年10月9日 下午3:02:58 roilat-J Exp $
 */
public class TestPermSpaceOverFlow {
    public static void main(String[] args) {
        int count = 0;
        List<String> list = new ArrayList<String>();
        long start = System.currentTimeMillis();
        try {
            while (true) {
                list.add("list" + count++);
            }
        } catch (Error e) {
            System.out.println("error" + count);
            e.printStackTrace();
        }
        System.out.println("total cost :" + (System.currentTimeMillis() - start));
    }
    /**
     * 当不设置-Xmx512m时(此时可见java进程达到2G+/8G)：
     * java.lang.OutOfMemoryError: GC overhead limit exceeded
     *          at cn.roilat.study.jvm.mem.TestPermSpaceOverFlow.main(TestPermSpaceOverFlow.java:20)
     * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=16m; support was removed in 8.0
     * 
     * 设置-Xmx512m时：
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     *              at cn.roilat.study.jvm.mem.TestPermSpaceOverFlow.main(TestPermSpaceOverFlow.java:23)
     * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=16m; support was removed in 8.0
     */
}
