package cn.start.roilat.language.string;

import java.text.DecimalFormat;


public class IntToStringAdd0 {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("0000");
		System.out.println(df.format(1+20));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Double.MAX_VALUE);
		System.out.println(String.format("%010d", 12));
		int i = 2147483647;
		System.out.println(i+1);
		System.out.println(Integer.toUnsignedString(Integer.MAX_VALUE+20));
//		System.out.println(String.format("%012s", Integer.toUnsignedString(Integer.MAX_VALUE+20)));
		
	}

}

