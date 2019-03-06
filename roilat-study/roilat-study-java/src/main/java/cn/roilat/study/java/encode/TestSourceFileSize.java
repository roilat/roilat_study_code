package cn.roilat.study.java.encode;

public class TestSourceFileSize {
    public static void main(String[] args) {
        /**
         * 当变量a的内容都是如下中文时：
         * 源文件编码方式GBK:文件长度是197byte;(a的长度是21*2=42byte)
         * 源文件编码方式UTF8:文件长度是218byte;(a的长度是21*3=63byte)
         * 刚好差21个byte
         */
        String a = "我是中文内容，我是中文内容，我是中文内容！";
        System.out.println(a.getBytes().length);
    }
}
