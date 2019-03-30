

/**
 * Volatile有两个作用： 1、将值由工作内存写入主内存，并通知其它线程更新此值，保证了值的一致性（没毛病，如果计算不依赖当前值 的话）
 * 2、禁止指令重排优化
 * 
 * @author roilat-D
 *
 */
public class TestVolatile {
	public static volatile int count = 0;

	public static void increase() {
		count++;
	}

	public static void main(String[] args) {
		Thread[] threads = new Thread[20];
		for (int i = 0; i < 20; i++) {
			threads[i] = new Thread() {
				@Override
				public void run() {
					for (int i = 0; i < 10000; i++) {
						increase();
					}
				}
			};
			threads[i].start();
		}
		while (Thread.activeCount() > 1) {
			Thread.yield();// 让出执行权，等待其它线程完成
		}
		System.out.println(count);
	}
}
