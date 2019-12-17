package cn.roilat.study.java.basic.map;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TestHashMapLock {

	public static void main(String[] args) throws InterruptedException {
		doTest(new HashMap<String, String>(2));
		doTest(new ConcurrentHashMap<String, String>(2));
	}

	public static void doTest(Map<String,String> map) throws InterruptedException{
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				long start = System.currentTimeMillis();
				for (int i = 0; i < 10000; i++) {
					new Thread(new Runnable() {
						@Override
						public void run() {
							map.put(UUID.randomUUID().toString(), "");
						}
					}, "ftf" + i).start();
				}
				System.out.println("total cost:"+(System.currentTimeMillis()-start));
			}

		}, "ftf");
		t.start();
		t.join();
	}
}
