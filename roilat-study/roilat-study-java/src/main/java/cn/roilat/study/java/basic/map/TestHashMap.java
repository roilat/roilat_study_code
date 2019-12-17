package cn.roilat.study.java.basic.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TestHashMap {

	public static void main(String[] args) {
		System.out.println(testTableSizeFor(19));
		System.out.println(testTableSizeFor(512));
		System.out.println(testTableSizeFor(65536));
		testHashMapContent();
		testTreefy();

	}

	/**
	 * HashMap转树,必须在桶长度超过64，且链表长度超过8时才有效
	 */
	public static void testTreefy() {
		System.out.println("testTreefy");
		int size = 1 << 6;
		Map<Integer, String> map = new HashMap<Integer, String>(size);
		int temp = 0;
		for (int i = 0; i < 10; i++) {
			map.put(temp = i * size, temp + "");
		}
		Iterator<?> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());// 先遍历链表，链表next==null时，再遍历数组桶
		}
	}

	public static int testTableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return n;
	}

	/**
	 * HashMap存放内容是无序的
	 */
	public static void testHashMapContent() {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("语文", 1);
		map.put("数学", 2);
		map.put("英语", 3);
		map.put("历史", 4);
		map.put("政治", 5);
		map.put("地理", 6);
		map.put("生物", 7);
		map.put("化学", 8);
		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

}
