
package cn.roilat.study.language.multhread;

/**
 * javadoc for cn.start.roilat.language.multhread.TestSynTwoMethod
 * @Copyright: 2017成都环赛信息技术有限公司 
 * @author: roilat-D
 * @since: 2017年9月7日
 */
public class TestSynTwoMethod {

	public static void main(String[] args) {
		test1();
//		test2();
	}
	/**
	 * @description: 测试说明：当一个类有两个同步的方法时，A线程调用方法A时，B线程无法调用方法B。
	 * @creator: roilat-D
	 * @createDate: 2017年9月7日 
	 */
	public static void test1(){
		final A a = new A();
		final A b = new A();
		new Thread(){
			@Override
			public void run() {
				a.methodA();
			}
		}.start();
		new Thread(){
			@Override
			public void run() {
				a.methodB();
				//b.methodB();
			}
		}.start();
	}
	/**
	 * @description: 测试说明：当一个类有两个方法都同步了一段代码，A线程调用方法A时，B线程无法调用方法B。
	 * 注意：同步的对象锁不能为空。
	 * 1、当同步对象是同一个时：
	 * 
	 * @creator: roilat-D
	 * @createDate: 2017年9月7日 
	 */
	public static void test2(){
		/*1、当同步对象是同一个时：
		methodA  start
		methodA synchronized start
		methodB  start
		methodA synchronized end
		methodA  end
		methodB synchronized start
		methodB synchronized end
		methodB  end
		当锁不是同一个对象时，两个线程无法做到互斥（正常并发）
		*/
		final A a = new A();
		final Object o1 = new Object();
		final Object o2 = new Object();
		new Thread(){
			@Override
			public void run() {
				a.methodA1(o1);
			}
		}.start();
		new Thread(){
			@Override
			public void run() {
				a.methodB1(o1);
			}
		}.start();
	}
}
class A{
	public synchronized void methodA(){
		System.out.println("methodA  start");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("methodA  end");
	}
	public synchronized void methodB(){
		System.out.println("methodB  start");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("methodB  end");
	}
	public void methodA1(Object o){
		System.out.println("methodA  start");
		synchronized (o) {
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
	public void methodB1(Object o){
		System.out.println("methodB  start");
		synchronized (o) {
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
