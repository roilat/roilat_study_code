package cn.roilat.study.jvm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestOutOfMemoryError {

	public static void method() throws InterruptedException {
		try {
			List<Double> numbers = new ArrayList<Double>();
			Thread.sleep(20000);
			for (int  i = 1; i <= Integer.MAX_VALUE; i++)
				numbers.add(new Double(i));
			System.out.println(numbers.size());
			Collections.shuffle(numbers);
			Thread.sleep(100000);
			System.out.println("shuffled");
			List<Double> winningcombination = numbers.subList(0, 10);
			System.out.println("to sort");
			Collections.sort(winningcombination);
		} catch (OutOfMemoryError e) {
			System.out.println("heelo");
//			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		method();
		long end = System.currentTimeMillis();
		System.out.println("time elapsed : " + (end - start));
	}

}