package cn.roilat.study.java.multhread.testjoinandcountdownlatch;


/**
 * 这种韬晦下，test1和test2即join和countdownlatch可以实现相同的功能，当时test3说明countdownlatch可以实现join无法实现的功能
 * @author roilat-J
 *
 */
public class Test1 {
	public static void main(String[] args) throws InterruptedException {
		// TODO 自动生成的方法存根

		Worker1 worker0 = new Worker1("worker0", (long) (Math.random() * 2000 + 3000));
		Worker1 worker1 = new Worker1("worker1", (long) (Math.random() * 2000 + 3000));
		Worker1 worker2 = new Worker1("worker2", (long) (Math.random() * 2000 + 3000));

		worker0.start();
		worker1.start();

		worker0.join();
		worker1.join();
		System.out.println("准备工作就绪");

		worker2.start();
	}
}

/** 
 * 工作者类 
 */ 
class Worker1 extends Thread {

	// 工作者名
	private String name;
	// 工作时间
	private long time;

	public Worker1(String name, long time) {
		this.name = name;
		this.time = time;
	}

	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {
			System.out.println(name + "开始工作");
			Thread.sleep(time);
			System.out.println(name + "工作完成，耗费时间=" + time);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}