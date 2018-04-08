package cn.roilat.study.language;


public class CharSetTest {
	public static void main(String[] args) throws Exception {
		byte[] bs1 = "hello,你是谁？".getBytes();//default UTF-8
		byte[] bs2 = "hello,你是谁？".getBytes("GBK");//
		System.out.println(new String(bs1,"UTF-8"));
		System.out.println(new String(bs1,"GBK"));
		System.out.println(new String(bs2,"UTF-8"));
		System.out.println(new String(bs2,"GBK"));
	}
}
