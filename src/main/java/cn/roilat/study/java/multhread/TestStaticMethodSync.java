package cn.roilat.study.java.multhread;

public class TestStaticMethodSync {

	public static void main(String[] args) {
		test1();
	}
	
	public static void test1(){
		new Thread(){
			@Override
			public void run() {
				TestStaticMethodSync.methodA();
			}
		}.start();
		new Thread(){
			@Override
			public void run() {
				TestStaticMethodSync.methodB();
			}
		}.start();
	}

	
	public static void methodA() {
		System.out.println("methodA  start");
		synchronized (TestStaticMethodSync.class) {
			System.out.println("methodA synchronized start");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("methodA synchronized end");
		}
		System.out.println("methodA  end");
	}

	public static void methodB() {
		System.out.println("methodB  start");
		synchronized (TestStaticMethodSync.class) {
			System.out.println("methodB synchronized start");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("methodB synchronized end");
		}
		System.out.println("methodB  end");

	}
}
