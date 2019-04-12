package cn.roilat.study.java.basic.datatype.primary;

public class TestMathAbs {
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);//2147483647
		System.out.println(Integer.MIN_VALUE);//-2147483648
		System.out.println(Math.abs(Integer.MAX_VALUE));//2147483647
		System.out.println(Math.abs(Integer.MIN_VALUE));//-2147483648
		//最后一个就厉害了，绝对值是他本身，因为Integer不最大不支持2147483648
		System.out.println(Math.abs(new Long(Integer.MIN_VALUE)));//2147483648
		//但是Long是支持2147483648的
	}
}
