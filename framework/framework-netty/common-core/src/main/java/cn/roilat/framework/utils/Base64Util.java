package cn.roilat.framework.utils;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

/**
 * java8 自带的base64编码,只能在java8及以上使用
 * 
 * @author roilat-D
 *
 */
public class Base64Util {

	private static Encoder encoder = Base64.getEncoder();

	private static Decoder decoder = Base64.getDecoder();

	// 用于处理url的编码（比如/）
	private static Encoder urlEncoder = Base64.getUrlEncoder();
	// 用于处理url的编码（比如/）
	private static Decoder urlDecoder = Base64.getUrlDecoder();

	public static byte[] encodingURL(byte[] bytes) {
		return urlEncoder.encode(bytes);
	}

	public static String encodingURL(String src) {
		return urlEncoder.encodeToString(src.getBytes());
	}

	public static byte[] decodingURL(byte[] bytes) {
		return urlDecoder.decode(bytes);
	}

	public static String decodingURL(String src) {
		return new String(urlDecoder.decode(src.getBytes()));
	}

	public static byte[] encoding(byte[] bytes) {
		return encoder.encode(bytes);
	}

	public static String encoding(String src) {
		return encoder.encodeToString(src.getBytes());
	}

	public static byte[] decoding(byte[] bytes) {
		return decoder.decode(bytes);
	}

	public static String decoding(String src) {
		return new String(decoder.decode(src.getBytes()));
	}

	public static void main(String[] args) {
		String str = "刘杰hello";

		System.out.println(new String(decoding(encoding(str.getBytes()))));
		System.out.println(decoding(new String(encoding(str.getBytes()))));
		System.out.println(new String(decoding(encoding(str).getBytes())));
		System.out.println(decoding(encoding(str)));

	}
}
