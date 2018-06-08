package cn.roilat.study.java.basic.charset.trans;

import java.io.UnsupportedEncodingException;

public class Utf82Gbk {
	public static void main(String[] args) throws Exception {
		testSuccess();
		testFail();
	}

	public static void testSuccess() throws UnsupportedEncodingException {
		// 这是一个unicode字符串，与字符集无关
		String str1 = "用户";

		System.out.println("unicode字符串：" + str1);

		// 将str转为UTF-8字节流
		byte[] byteArray1 = str1.getBytes("UTF-8");// 这个很安全，UTF-8不会造成数据丢失

		System.out.println(byteArray1.length);// 打印6，没毛病

		// 下面交给另外一个人，他不知道这是UTF-8字节流，因此他当做ISO-8859-1处理

		// 将byteArray1当做一个普通的字节流，按照GBK解码为一个unicode字符串
		String str2 = new String(byteArray1, "GBK");

		System.out.println("转成GBK会乱码：" + str2);

		// 将GBK编码的unicode字符串转回为byte[]
		byte[] byteArray2 = str2.getBytes("GBK");// 数据会不会丢失呢？

		// 将字节流重新交回给用户A

		// 重新用UTF-8解码
		String str3 = new String(byteArray2, "UTF-8");

		System.out.println("数据没有丢失：" + str3);
	}

	public static void testFail() throws UnsupportedEncodingException {
		// 这是一个unicode字符串，与字符集无关
		String str1 = "用户名";

		System.out.println("unicode字符串：" + str1);

		// 将str转为UTF-8字节流
		byte[] byteArray1 = str1.getBytes("UTF-8");// 这个很安全，UTF-8不会造成数据丢失

		System.out.println(byteArray1.length);// 打印6，没毛病

		// 下面交给另外一个人，他不知道这是UTF-8字节流，因此他当做ISO-8859-1处理

		// 将byteArray1当做一个普通的字节流，按照GBK解码为一个unicode字符串
		String str2 = new String(byteArray1, "GBK");

		System.out.println("转成GBK会乱码：" + str2);

		// 将GBK编码的unicode字符串转回为byte[]
		byte[] byteArray2 = str2.getBytes("GBK");// 数据会不会丢失呢？

		// 将字节流重新交回给用户A

		// 重新用UTF-8解码
		String str3 = new String(byteArray2, "UTF-8");

		System.out.println("数据没有丢失：" + str3);
	}
}
