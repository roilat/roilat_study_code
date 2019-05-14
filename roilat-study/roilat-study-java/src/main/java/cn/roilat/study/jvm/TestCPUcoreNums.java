package cn.roilat.study.jvm;

import java.util.Objects;

public class TestCPUcoreNums {

	public static void main(String[] args) {
		System.out.println("start Test!");
		// 使用双核心4线程的I53230M CPU，测试，线程为1时，CPU使用25%，3时，CPU使用为75%
		test("aaa", "bbb", 3);
	}

	public static void test(String s1, String s2, int threadCount) {
		System.out.println(Objects.equals("aaa", "aaa"));
		for (int i = 0; i < threadCount; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					while (true) {

					}
				}
			}).start();
		}
	}
}
