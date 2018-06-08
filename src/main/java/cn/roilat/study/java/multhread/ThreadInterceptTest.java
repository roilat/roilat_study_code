
package cn.roilat.study.java.multhread;

public class ThreadInterceptTest {

	/**
	 * @description: 测试说明：线程1不断的进行30m轮询休眠；线程2不断的进行10s轮询休眠，完成后，intercept线程1
	 * 测试结果：可以有效的结束线程现有的状态，并使其抛出中断异常。
	 * @creator: roilat-D
	 * @createDate: 2017年9月7日 
	 */
	public static void main(String[] args) {
		TestThread1 t1 = new TestThread1();
		t1.start();
		new TestThread2(t1).start();
	}
}

class TestThread1 extends Thread{
	public void run() {
		while(true){
			try {
				System.out.println("start--" + this.getName());
				Thread.sleep(30000);
				System.out.println("end--" + this.getName());
			} catch (InterruptedException e) {
				System.out.println("InterruptedException--" + this.getName());
			}

		}
	}
}
class TestThread2 extends Thread{
	private TestThread1 thread;
	
	public TestThread2(TestThread1 thread) {
		super();
		this.thread = thread;
	}

	public void run() {
		while(true){
			try {
				System.out.println("start--" + this.getName());
				Thread.sleep(10000);
				System.out.println("end--" + this.getName());
				thread.interrupt();
				//thread.join();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException--" + this.getName());
			}
		}
	}
}