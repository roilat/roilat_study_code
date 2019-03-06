package cn.roilat.study.java.basic.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class TestHashMap {

    public static void main(String[] args) {
        System.out.println(testTableSizeFor(19));
        System.out.println(testTableSizeFor(512));
        System.out.println(testTableSizeFor(65536));
        testHashMapContent();
        try {
            testFastFail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        testFailSafe();
        testFastFail2();
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
            if (key == 3000) {
                testHashMap.remove(key);
            }
        }
        System.out.println(testHashMap.size());
        for (Map.Entry<Integer, String> entry : testHashMap.entrySet()) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
    }

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
        while (iterator.hasNext())
        {
            int key = (int)((Map.Entry<Integer, String>)iterator.next()).getKey();
            System.out.println("key=" + key);
            if (key == 2000 || key == 4000)
            {
                iterator.remove();
            }
        }
        System.out.println(testHashMap.size());
        for (Map.Entry<Integer, String> entry : testHashMap.entrySet())
        {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }
    }

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
