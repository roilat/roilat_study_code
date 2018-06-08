
package cn.roilat.study.java;

import java.util.HashMap;
import java.util.Map;

public class TestIntAndInteger {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("aaa", new Integer(111));
		map.put("bbb", 222);
		System.out.println(map.get("aaa"));
		System.out.println(map.get("aaa").getClass());
		System.out.println(map.get("bbb").getClass());
		System.out.println(map.get("aaa"));
		System.out.println(map.get("bbb"));
		map.put("aaa",map.get("aaa")+2);
		System.out.println(map.get("aaa").getClass());
		System.out.println(map.get("aaa"));
	}
}

