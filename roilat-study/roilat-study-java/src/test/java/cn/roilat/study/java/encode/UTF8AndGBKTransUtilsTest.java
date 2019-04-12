package cn.roilat.study.java.encode;

import java.io.UnsupportedEncodingException;
import java.nio.charset.CharacterCodingException;

import org.junit.Test;


/**
 * jvm的file.encoding=gbk
 * 
 * @author roilat-J
 * @version $Id: UTF8AndGBKTransUtilsTest.java, v 0.1 2019年1月16日 下午5:57:58 roilat-J Exp $
 */
public class UTF8AndGBKTransUtilsTest {

    @Test
    public void utf8ToGBK_jvm() throws UnsupportedEncodingException, CharacterCodingException {
        System.out.println("-----------utf8ToGBK_jvm------------");
        System.out.println("中国人");
        byte[] bs = UTF8AndGBKTransUtils.utf8ToGBK_jvm("中国人");
        System.out.println(bs.length + "-" + new String(bs, "GBK"));
    }

    @Test
    public void gbkToUTF8_jvm() throws UnsupportedEncodingException, CharacterCodingException {
        System.out.println("-----------gbkToUTF8_jvm------------");
        byte[] bs = UTF8AndGBKTransUtils.gbkToUTF8_jvm("中国人");
        System.out.println(bs.length + "-" + new String(bs, "UTF-8"));
    }

    @Test
    public void getBytesString() throws UnsupportedEncodingException, CharacterCodingException {
        System.out.println("-----------getBytesString------------");
        System.out.println(UTF8AndGBKTransUtils.getBytesString("中国人".getBytes()));
    }

    @Test
    public void utf8ToGBK() throws UnsupportedEncodingException, CharacterCodingException {
        System.out.println("-----------utf8ToGBK------------");
        byte[] bs = UTF8AndGBKTransUtils.utf8ToGBK("中国人".getBytes("UTF-8"));
        System.out.println(bs.length + "-" + new String(bs, "GBK"));

    }
    
    

    /**
     * https://blog.csdn.net/u014631304/article/details/77509380?utm_source=blogxgwz4
     * @throws UnsupportedEncodingException
     */
    @Test
    public void test() throws UnsupportedEncodingException {
        System.out.println("-----------test------------");
        String a;
        System.out.println( a = new String(new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x81 }));
        System.out.println(a.toCharArray().length); //2
        System.out.println(a = new String(new byte[] { (byte) 0xF0, (byte) 0x9F, (byte) 0x98, (byte) 0x81 }, "UTF-8"));
        System.out.println(a.toCharArray().length); //2

        String s = "组件表结构.jpg";
        byte[] bs;
        System.out.println((s = new String(bs = s.getBytes("UTF-8"), "GBK")) + "--utf8_byte_len=" + bs.length + ", gbk_char_len=" + s.length());
        System.out.println(UTF8AndGBKTransUtils.getBytesString(bs));
        System.out.println(UTF8AndGBKTransUtils.getBytesString(s.getBytes("GBK")));
        System.out.println(s = new String(s.getBytes("GBK"), "UTF-8"));
        System.out.println(UTF8AndGBKTransUtils.getBytesString(s.getBytes("UTF-8")));

    }
}
