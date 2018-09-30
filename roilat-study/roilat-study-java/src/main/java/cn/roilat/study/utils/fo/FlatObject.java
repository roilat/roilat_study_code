/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package cn.roilat.study.utils.fo;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * @author liuzhengzheng.lz
 * @version $Id: FlatObject, v 0.1 2018-09-03 ����9:31 liuzhengzheng.lz Exp $
 */
public class FlatObject {

    /**
     * ��ʼ��map����
     */
    private final Map<String, Object> map = new HashedMap();

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    public Object get(Object key) {
        return map.get(key);
    }

    /**
     * ����
     *
     * @param key
     * @param value
     *
     * @return
     */
    public Object     put(String key, Object value) {
        return map.put(key, value);
    }

    /**
     * @return
     */
    public Map<String, Object> getValueMap() {
        return map;
    }

    @Override
    public String toString() {
        return "FlatObject{" +
                "map=" + map +
                '}';
    }
}
