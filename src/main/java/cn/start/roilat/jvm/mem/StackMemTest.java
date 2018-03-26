package cn.start.roilat.jvm.mem;

import java.util.Stack;

public class StackMemTest {

	public static void main(String[] args) throws InterruptedException {
		main(1);
	}

	/**
	 * 测试一些数据在栈中的大小
	 * @param arg
	 * @throws InterruptedException
	 */
	public static void main(int arg) throws InterruptedException {//4B
		String s = "songxu"; //4B
		Long long1 = 1l;//4B
		long long2 = 2l;//8B
		Object object = new Object();//4B
		int i = 0;//4B
		while(i == 0){
			System.out.println(Thread.activeCount());
			Thread.sleep(5000);
			Stack<Integer> ss = new Stack<Integer>(); 
            for (Integer x : ss) { 
                    System.out.println(); 
            }
		}
	}

}
