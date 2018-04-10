package cn.roilat.study.java.basic.charset;

import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class CharsetEncoderTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		Charset charset = Charset.forName("UTF-8");
		CharsetEncoder cEncode = charset.newEncoder();
//		CharBuffer in = new CharBuffer();
//		cEncode.encode(in );
		String s;
		System.out.println(s = new String("中软国际-咪咕项目-web前端-李代麟.jpg".getBytes("UTF-8"),"GBK"));
		System.out.println(new String(s.getBytes("GBK"),"UTF-8"));
		System.out.println();
	}

}
