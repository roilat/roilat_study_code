/**
 * 
 */
package cn.roilat.study.java.basic.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author roilat-D TestHashMapFastFail.java
 */
public class TestHashMapFastFail {
	public static void main(String[] args) {
		try {
			testFastFail();
		} catch (Exception e) {
			e.printStackTrace();
		}
		testFailSafe();
		testFastFail2();
	}

	public static void testFastFail() {
		System.out.println("test HashMap fast-fail");
		Map<Integer, String> testHashMap = new HashMap<Integer, String>();
		testHashMap.put(1000, "1000");
		testHashMap.put(2000, "2000");
		testHashMap.put(3000, "3000");
		testHashMap.put(4000, "4000");
		testHashMap.put(5000, "5000");
		System.out.println(testHashMap.size());
		for (Map.Entry<Integer, String> entry : testHashMap.entrySet()) {
			int key = entry.getKey();
			System.out.println("key=" + key);
			/**
			 * 刚好3000是最后一个,所以其它4个已显示 1000%16=8 2000%16=0 3000%16=8 4000%16-0 5000%16=8
			 * node[0]=2000->4000 node[8]=1000->3000->5000 应该顺序输出2000，4000，1000，3000然后异常
			 */
			if (key == 3000) {
				testHashMap.remove(key);
			}
		}
		System.out.println(testHashMap.size());
		for (Map.Entry<Integer, String> entry : testHashMap.entrySet()) {
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
	}

	/**
	 * iterator不会抛出异常
	 */
	public static void testFastFail2() {
		System.out.println("test solve HashMap fast-fail");
		Map<Integer, String> testHashMap = new HashMap<Integer, String>();
		testHashMap.put(1000, "1000");
		testHashMap.put(2000, "2000");
		testHashMap.put(3000, "3000");
		testHashMap.put(4000, "4000");
		testHashMap.put(5000, "5000");
		System.out.println(testHashMap.size());
		Iterator<Map.Entry<Integer, String>> iterator = testHashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			int key = (int) ((Map.Entry<Integer, String>) iterator.next()).getKey();
			System.out.println("key=" + key);
			if (key == 2000 || key == 4000) {
				iterator.remove();
			}
		}
		System.out.println(testHashMap.size());
		for (Map.Entry<Integer, String> entry : testHashMap.entrySet()) {
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
	}

	/**
	 * 使用ConcurrentHashMap不会异常
	 */
	public static void testFailSafe() {
		System.out.println("test ConcurrentHashMap fast-fail");
		Map<Integer, String> testConcurrentHashMap = new ConcurrentHashMap<Integer, String>();
		testConcurrentHashMap.put(100, "100");
		testConcurrentHashMap.put(200, "200");
		testConcurrentHashMap.put(300, "300");
		testConcurrentHashMap.put(400, "400");
		testConcurrentHashMap.put(500, "500");
		System.out.println(testConcurrentHashMap.size());
		for (Map.Entry<Integer, String> entry : testConcurrentHashMap.entrySet()) {
			int key = entry.getKey();
			System.out.println("key=" + key);
			if (key == 300) {
				testConcurrentHashMap.remove(key);
			}
		}
		System.out.println(testConcurrentHashMap.size());
		for (Map.Entry<Integer, String> entry : testConcurrentHashMap.entrySet()) {
			System.out.println(entry.getKey() + "-->" + entry.getValue());
		}
	}
}
