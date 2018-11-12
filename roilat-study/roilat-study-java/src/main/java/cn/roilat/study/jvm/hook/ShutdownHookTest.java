package cn.roilat.study.jvm.hook;

public class ShutdownHookTest {
	public static void main(String[] args) throws InterruptedException {
		int i = 10;
		while(i-- > 0) {
			Thread.sleep(100);
			System.out.println(Thread.currentThread().getName() + " main thread running...");
		}
		System.out.println(new ShutdownHookTest());
		 Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
             @Override
             public void run() {
				int i = 10;
				while (i-- > 0) {
					System.out.println(Thread.currentThread().getName() + " thread shutdown ...");
				}
             }
         }));
		 System.out.println(Thread.currentThread().getName() + " end...");
	}

    @Override
    protected void finalize() throws Throwable {
        System.out.println("ShutdownHookTest.finalize()");
        super.finalize();
    }
	
}
