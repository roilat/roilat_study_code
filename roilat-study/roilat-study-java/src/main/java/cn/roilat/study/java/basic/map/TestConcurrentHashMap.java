package cn.roilat.study.java.basic.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {

    public static void main(String[] args) {
        Map<String,String> map= new ConcurrentHashMap<>();
        map.put("key1", "value1");
    }

}
