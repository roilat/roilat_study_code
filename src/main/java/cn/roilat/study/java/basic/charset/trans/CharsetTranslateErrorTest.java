package cn.roilat.study.java.basic.charset.trans;

public class CharsetTranslateErrorTest {
	public static void demo(String str, String sourceCharset, String destCharset) throws Exception {
		System.out.println("原文：" + str);
		// 转换
		byte[] sourceByte = str.getBytes(sourceCharset);
		System.out.print(sourceCharset + " Byte：");
		printHex(sourceByte);
		String destStr = new String(sourceByte, destCharset);// 这里实际上把数据可能已经破坏了
		System.out.println("to " + destCharset + "：" + destStr);

		// 还原
		byte[] destByte = destStr.getBytes(destCharset);
		String originalStr = new String(destByte, sourceCharset);
		System.out.print(destCharset + " Byte：");
		printHex(destByte);
		System.out.println("revert back to " + sourceCharset + "：" + originalStr);
		System.out.println("=============================");
		// 如果gbk变成iso-8859-1就没问题
	}

	public static void printHex(byte[] byteArray) {
		StringBuffer sb = new StringBuffer();
		for (byte b : byteArray) {
			sb.append(Integer.toHexString((b >> 4) & 0xF));
			sb.append(Integer.toHexString(b & 0xF));
			sb.append(" ");
		}
		System.out.println(sb.toString());
	};

	public static void main(String[] args) throws Exception {
		String str1 = "姓名";
		String str2 = "用户名";
		demo(str1, "UTF-8", "ISO-8859-1");
		demo(str2, "UTF-8", "ISO-8859-1");

		demo(str1, "UTF-8", "GBK");
		demo(str2, "UTF-8", "GBK");
	}

	public static void demo(String str) throws Exception {
		System.out.println("原文：" + str);

		byte[] utfByte = str.getBytes("UTF-8");
		System.out.print("utf Byte：");
		printHex(utfByte);
		String gbk = new String(utfByte, "GBK");// 这里实际上把数据破坏了
		System.out.println("to GBK：" + gbk);

		byte[] gbkByte = gbk.getBytes("GBK");
		String utf = new String(gbkByte, "UTF-8");
		System.out.print("gbk Byte：");
		printHex(gbkByte);
		System.out.println("revert UTF8：" + utf);
		System.out.println("===");
		// 如果gbk变成iso-8859-1就没问题
	}
}
