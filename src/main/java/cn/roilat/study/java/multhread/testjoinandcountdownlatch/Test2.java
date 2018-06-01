package cn.roilat.study.java.multhread.testjoinandcountdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 这种韬晦下，test1和test2即join和countdownlatch可以实现相同的功能，当时test3说明countdownlatch可以实现join无法实现的功能
 * @author roilat-J
 *
 */
public class Test2 {
	public static void main(String[] args) throws InterruptedException {
		// TODO 自动生成的方法存根

		CountDownLatch countDownLatch = new CountDownLatch(2);
		Worker2 worker0 = new Worker2("worker0", (long) (Math.random() * 2000 + 3000), countDownLatch);
		Worker2 worker1 = new Worker2("worker1", (long) (Math.random() * 2000 + 3000), countDownLatch);
		Worker2 worker2 = new Worker2("worker2", (long) (Math.random() * 2000 + 3000), countDownLatch);

		worker0.start();
		worker1.start();

		countDownLatch.await();
		System.out.println("准备工作就绪");
		worker2.start();
	}
}

/**
 * 工作者类
 */
class Worker2 extends Thread {

	// 工作者名
	private String name;
	// 工作时间
	private long time;

	private CountDownLatch countDownLatch;

	public Worker2(String name, long time, CountDownLatch countDownLatch) {
		this.name = name;
		this.time = time;
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {
			System.out.println(name + "开始工作");
			Thread.sleep(time);
			System.out.println(name + "工作完成，耗费时间=" + time);
			countDownLatch.countDown();
			System.out.println("countDownLatch.getCount()=" + countDownLatch.getCount());
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}