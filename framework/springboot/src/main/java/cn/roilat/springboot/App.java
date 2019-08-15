package cn.roilat.springboot;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		boolean[] bs = new boolean[20];
		System.out.println(bs[2]);
		System.out.println((new int[10])[1]);
		print();
	}

	static void print() {
		int arr[] = { 7, 8, 9, 10, 19, 26, 27, 28 };
		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length - 1 && arr[i + 1] - arr[i] == 1) {
				System.out.print(arr[i]);
			} else {
				System.out.println(arr[i] + "-");
			}
		}
	}
}

interface B {
	abstract void hello();
}

abstract class A {
	static int a;
	private int b;

	static void hello() {

	}

}