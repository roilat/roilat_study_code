
package cn.start.roilat.language.multhread;

/**
 * 题目：子线程循环10次，主线程循环5次，如此以次循环50次
 * synchronized方法
 * wait和notify的使用
 * javadoc for cn.start.roilat.multhread.TraditionalThreadCommunication
 * @Copyright: 2016成都环赛信息技术有限公司 
 * @author: roilat-D
 * @since: 2016年11月28日
 */
public class TraditionalThreadCommunication {
	
	public static void main(String[] args) throws InterruptedException {

		final Business business = new Business();
		//子线程循环50次，每次调用sub方法
		new Thread(new Runnable() {
			public void run() {
				for (int i = 1; i <= 50; i++) {
					try {
						business.sub(i);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		//主线程循环50次，调用main方法
		for (int i = 1; i <= 50; i++) {
			business.main(i);
		}

	}

}
/**
 * synchronized用于控制两个方法的同步，
 * 不同线程分别同时调用本类的实例时，其中的方法只执行其中一个；
 * 把业务方法设计在业务类中，而不是写在线程中，是为了代码的复用和可移植性，别的线程也可以调用。
 * javadoc for cn.start.roilat.multhread.Business
 * @Copyright: 2016成都环赛信息技术有限公司 
 * @author: roilat-D
 * @since: 2016年11月28日
 */
class Business {
	//用于控制子方法和主方法的执行条件
	private boolean bShouldSub = false;

	public synchronized void sub(int i) throws InterruptedException {
		while (!bShouldSub) {//while的作用是当该方法被唤醒后（可能被伪唤醒），再次判断是否满足本方法的运行条件
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int j = 1; j <= 10;j++ ) {//
			Thread.sleep(1000);
			System.out.println("sub thread sequence of " + j + ",loop of " + i);
		}
		bShouldSub = false;
		this.notify();
	}

	public synchronized void main(int i) throws InterruptedException {
		while (bShouldSub) {
			try {
				this.wait();//执行该方法的线程进入wait状态
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int j = 1; j <= 10; j++) {//
			Thread.sleep(1000);
			System.out.println("main thread sequence of " + j + ",loop of " + i);
		}
		bShouldSub = true;//修改执行条件
		this.notify();//通知基本wait中线程
	}
}
