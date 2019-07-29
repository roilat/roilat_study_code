/**
 * 
 */
package cn.roilat.study.algorithm.numberseries;

/**
 * 斐波那契
 * 
 * @author roilat-D Fibonacci.java
 */
public class Fibonacci {
	public static void main(String[] args) {
		fibonacci1(15);
		fibonacci2(15);
	}

	/**
	 * 0 1 2 4 7 12 20... Ax=A(x-1)*2-A(x-3) 1-0=1 2-1=1 4-2=2 （1+1=2） 7-4=3 （1+2=3）
	 * 12-7=5 （2+3=5） 20-12=8 （3+5=8） 33-20=13 （5+8=13） 54-33=21 （8+13=21）
	 */
	public static void fibonacci1(int count) {
		int[] result = new int[count];
		result[0] = 0;
		result[1] = 1;
		result[2] = 2;
		int index = 2;
		while (++index < count) {
			result[index] = result[index - 1] * 2 - result[index - 3];
		}
		System.out.println("fibonacci1:");
		print(result);
		System.out.println();
	}

	/**
	 * 0 1 1 2 3 5 8 13 21 34...
	 */
	public static void fibonacci2(int count) {
		int[] result = new int[count];
		result[0] = 0;
		result[1] = 1;
		int index = 1;
		while (++index < count) {
			result[index] = result[index - 1] + result[index - 2];
		}
		System.out.println("fibonacci2:");
		print(result);
		System.out.println();

	}

	public static void print(int[] arr) {
		for (int i : arr) {
			System.out.print(i + "	");
		}
	}
}
