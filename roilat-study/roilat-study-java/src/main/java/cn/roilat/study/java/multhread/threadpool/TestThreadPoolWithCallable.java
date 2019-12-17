package cn.roilat.study.java.multhread.threadpool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * 由于构造线程数据太多，系统开销太大，所以准备使用线程池，希望可以提高效率，时间从150秒提升到1.5秒
 * 
 * @author roilat-J
 * @version $Id: TestVolatile.java, v 0.1 2019年3月26日 下午3:35:53 roilat-J Exp $
 */
public class TestThreadPoolWithCallable {
	int a = 1;
	int b = 2;

	public void change() {
		a = 3;
		b = a;
	}

	static Map<String, AtomicInteger> map = new HashMap<String, AtomicInteger>();
	static {
		map.put("b=3;a=3", new AtomicInteger(0));
		map.put("b=2;a=1", new AtomicInteger(0));
		map.put("b=2;a=3", new AtomicInteger(0));
		map.put("b=3;a=1", new AtomicInteger(0));
	}

	public void print() {
		map.get("b=" + b + ";a=" + a).incrementAndGet();
	}

	/**
	 * 当线程池设置成10, 15, 0时，报错：Exception in thread "main"
	 * java.util.concurrent.RejectedExecutionException: Task
	 * java.util.concurrent.FutureTask@27c170f0 rejected from
	 * java.util.concurrent.ThreadPoolExecutor@5451c3a8[Running, pool size = 13,
	 * active threads = 0, queued tasks = 0, completed tasks = 442]
	 * blockQueue如果设置初始容量且较小时，会因为任务无法放入到队列中，又无法分配到work中
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 1000000;
		long start = System.currentTimeMillis();
		BlockingQueue<Runnable> blockQueue = new LinkedBlockingQueue<Runnable>(10000);
		int noTaskWaitTime = 10;// 非核心线程没有任务指定时间后会退出,此项测试需要手动指定阻塞队列长度,并配合延时才能在工具中看到非核心线程的创新的销毁
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 15, noTaskWaitTime, TimeUnit.SECONDS, blockQueue,new DiscardOldestPolicy());
		executor.allowCoreThreadTimeOut(true);// 此项允许核心线程超时退出，可以不用延时代码也可以测试到
		while (n-- > 0) {
			final TestThreadPoolWithCallable test = new TestThreadPoolWithCallable();
			executor.submit(Executors.callable(new Runnable() {
				@Override
				public void run() {
					test.change();
				}
			}));

			executor.submit(Executors.callable(new Runnable() {
				@Override
				public void run() {
					test.print();
					/*
					 * try { Thread.sleep(1); } catch (InterruptedException e) {
					 * e.printStackTrace(); }
					 */

				}
			}));
		}
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				System.out.println(TestThreadPoolWithCallable.map);
				System.out.println("total cost:" + (System.currentTimeMillis() - start));
			}
		});
		// executor.shutdown();// 线程池的线程不会自己退出，除非设置了无任务最大等待时间且核心线程允许超时退出
		System.out.println("complete shutdown,waiting for shutdown hook");
		System.out.println(System.currentTimeMillis() - start);
		while (Thread.activeCount() > 1)
			;// 这里不计算deamon线程，会有11个线程，所以主线程也不会退出
		/**
		 * complete shutdown,waiting for shutdown hook 1344 {b=3;a=3=996521, b=2;a=3=7,
		 * b=2;a=1=3471, b=3;a=1=1}
		 */
	}
}
