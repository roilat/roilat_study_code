
package cn.roilat.study.java.multhread;

/**
 * javadoc for cn.start.roilat.language.multhread.TestSynForEnum
 * @Copyright: 2017成都环赛信息技术有限公司 
 * @author: roilat-D
 * @since: 2017年9月27日
 */
public class TestSynForEnum {
	public static void main(String[] args) {
		/*
		 * 可见,ENUM类似一个数组,对象是固定的那几个,当对其中一项进行同步时,
		 * 锁只有一把,不像new出来的对象,
		 * 各任务自己创建的都不是同一把,所有会并发,而不会互斥
		 */
		//test1();
		test2();
//		test3();
	}
	
	static void test1(){//两个线程使用同一个任务,则EnumTest是同一个---会同步
		Task t1 = new Task(EnumTest.ITEM1);
		new Thread(t1).start();
		new Thread(t1).start();
	}
	static void test2(){//任务不是同一个,但任务共用一个EnumTest是同一个---会同步
		Task t1 = new Task(EnumTest.ITEM1);
		Task t2 = new Task(EnumTest.ITEM1);
		new Thread(t1).start();
		new Thread(t2).start();
	}
	static void test3(){//任务不同,两个任务不共用一个EnumTest---不会同步,会并发
		Task t1 = new Task(EnumTest.ITEM1);
		Task t2 = new Task(EnumTest.ITEM2);
		new Thread(t1).start();
		new Thread(t2).start();
	}
}
class Task implements Runnable{
	private EnumTest et;
	
	public Task(EnumTest et) {
		super();
		this.et = et;
	}

	public void run() {
		synchronized (et) {
			try {
				System.out.println("start" + Thread.currentThread());
				Thread.sleep(10000);
				System.out.println("end" + Thread.currentThread());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
