package cn.roilat.study.java.buffer;

import java.io.FileWriter;

public class TestFileBuffer {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("test1.txt");
            for (int i = 0; i < 10000; i++) //写入超过8192个字节，即超过8k
            {
                fw.write('a');
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test2() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("test2.txt");
            for (int i = 0; i < 8193; i++) //写入超过8192个字节，即超过8k
            {
                fw.write('a');
            }
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
