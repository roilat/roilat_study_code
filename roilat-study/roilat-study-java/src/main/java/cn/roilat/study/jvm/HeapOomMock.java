package cn.roilat.study.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author roilat-J
 * @version $Id: HeapOomMock.java, v 0.1 2019年2月12日 下午3:05:14 roilat-J Exp $
 */
public class HeapOomMock {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<byte[]>();
        int i = 0;
        boolean flag = true;
        while (flag) {
            try {
                i++;
                list.add(new byte[1024 * 1024]);//每次增加一个1M大小的数组对象
            } catch (Throwable e) {
                e.printStackTrace();
                flag = false;
                System.out.println("count=" + i);//记录运行的次数
            }
        }
        /**
         * 默认：count=1745
         * -Xmx16m：count=14
         */
        /**
         * 如果设置：-XX:MaxPermSize=16m -XX:PermSize=16m，则抛出：
         * java.lang.OutOfMemoryError: Java heap space
         *     at cn.roilat.study.jvm.HeapOomMock.main(HeapOomMock.java:19)
         *     Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=16m; support was removed in 8.0
         *     Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=16m; support was removed in 8.0
         */
    }
}
