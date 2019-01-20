package cn.roilat.study.java.basic.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class TestHashMap {

    public static void main(String[] args) {
    	
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("111","222");
    	map.put("222","222");
    	map.put("333","222");
    	map.put("444","222");
    	map.put("555","222");
    	Iterator<Entry<String, String>> iter1 = map.entrySet().iterator();
    	Iterator<Entry<String, String>> iter2 = map.entrySet().iterator();
    	while(iter1.hasNext()){
    		System.out.println(iter1.next());
    		if(iter2.hasNext()){
    			iter2.remove();
    		}
    	}
        testTableSizeFor(19);
    }
    public static void testTableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
    }
}
