package cn.roilat.study.java.multhread;

public class TestWaitAndSync {
	private static boolean flag = false;
	public static void main(String[] args) throws InterruptedException {
		new Thread() {

			@Override
			public void run() {
				try {
					TestWaitAndSync.test1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}.start();
		new Thread() {
			
			@Override
			public void run() {
				try {
					TestWaitAndSync.test1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}.start();
		new Thread() {
			
			@Override
			public void run() {
				try {
					TestWaitAndSync.test2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}.start();
		new Thread() {
			
			@Override
			public void run() {
				try {
					TestWaitAndSync.test2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}.start();
	}

	public static void test1() throws InterruptedException {
		synchronized (TestWaitAndSync.class) {
			while (flag) {
				System.out.println(Thread.currentThread().getName() + " invoke test1 waiting...");
				TestWaitAndSync.class.wait();
			}
			Thread.sleep(1000);
			flag = true;
			TestWaitAndSync.class.notifyAll();
			System.out.println(Thread.currentThread().getName() + " invoke test1 notifyAll...");
		}
	}
	public static void test2() throws InterruptedException {
		synchronized (TestWaitAndSync.class) {
			while (!flag) {
				System.out.println(Thread.currentThread().getName() + " invoke test2 waiting...");
				TestWaitAndSync.class.wait();
			}
			Thread.sleep(1000);
			flag = false;
			TestWaitAndSync.class.notifyAll();
			System.out.println(Thread.currentThread().getName() + " invoke test2 notifyAll...");
		}
	}
}
