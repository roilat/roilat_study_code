package cn.roilat.study.java.basic.charset;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class ByteUtil {

	private static char[] chars = "0123456789ABCDEF".toCharArray();

	public static void printBytes(String str, String charset) throws UnsupportedEncodingException {
		byte[] bytes = str.getBytes(charset);
		System.out.println("total size is:" + bytes.length);
		for (byte b : bytes) {
			System.out.print(b + " ");
		}
		System.out.println();
	}

	public static String str2Hex(String str, String charset) throws UnsupportedEncodingException {
		return str2Hex(str.getBytes(charset));
	}

	public static String str2Hex(byte[] bs) {
		StringBuffer ret = new StringBuffer();
		int bit;
		for (byte b : bs) {
			bit = (b & 0x00f0) >> 4;
			ret.append(chars[bit]);
			bit = b & 0x000f;
			ret.append(chars[bit]);
		}
		return ret.toString();
	}

	public static String hexStr2Str(String hexStr, String charset) throws UnsupportedEncodingException {

		String str = "0123456789ABCDEF";
		char[] hexs = hexStr.toCharArray();
		byte[] bytes = new byte[hexStr.length() / 2];
		int n;
		for (int i = 0; i < bytes.length; i++) {
			n = str.indexOf(hexs[2 * i]) * 16;
			n += str.indexOf(hexs[2 * i + 1]);
			bytes[i] = (byte) (n & 0xff);
		}
		return new String(bytes, charset);
	}
}
