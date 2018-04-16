package cn.roilat.study.java.basic.datatype.primary;

public class TestIntOrAnd {
	public static void main(String[] args) {
		testOr();
	}
	public static void testOr() {
		System.out.println(Integer.toBinaryString(-1));//11111111111111111111111111111111
		System.out.println(Integer.toBinaryString(-256));//11111111111111111111111100000000
		System.out.println(Integer.toBinaryString(100));//11111111111111111111111100000000
		System.out.println(-1|-256);//-1
		System.out.println(-1|256);//-1
		System.out.println(100|256);//356
		assert 1>2;
	}
}
