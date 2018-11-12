/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package cn.roilat.study.utils.fromali.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.util.CollectionUtils;

import cn.roilat.study.utils.fromali.lang.callback.ListElementGenerator;

/**
 * List工具，把Map,Set快速转换为List
 * @author xfy90168
 * @version $Id: ListUtil.java, v 0.1 2018年6月29日 下午2:19:29 xfy90168 Exp $
 */
public class ListUtil {

    /**
     * 把Map转换为List 返加ArrayList
     * @param map
     * @param generator   用来构造List中的元素
     * @return
     */
    public static <T> List<T> mapToList(Map<? extends Object, ? extends Object> map,
                                        ListElementGenerator<T> generator) {

        if (CollectionUtils.isEmpty(map)) {
            return new ArrayList<T>(0);
        }

        List<T> list = new ArrayList<T>();

        for (Map.Entry<? extends Object, ? extends Object> each : map.entrySet()) {
            T element = generator.genElement(each);
            list.add(element);
        }

        return list;
    }

    /**
     * 把Set转换为List 返加ArrayList
     * @param set
     * @param generator   用来构造List中的元素
     * @return
     */
    public static <T> List<T> setToList(Set<? extends Object> set,
                                        ListElementGenerator<T> generator) {

        if (CollectionUtils.isEmpty(set)) {
            return new ArrayList<T>(0);
        }

        List<T> list = new ArrayList<T>();

        for (Object each : set) {
            T element = generator.genElement(each);
            list.add(element);
        }

        return list;
    }

    /**
     * List拆分
     *
     * @param list
     * @param len
     * @return
     */
    public static <T> List<List<T>> splitList(List<T> list, int len) {

        if (len <= 0) {
            throw new IllegalArgumentException("List拆分长度无效！");
        }

        if (list == null || list.size() == 0 || len < 1) {
            return null;
        }

        List<List<T>> result = new ArrayList<List<T>>();

        int size = list.size();
        int count = (size + len - 1) / len;

        for (int i = 0; i < count; i++) {
            List<T> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
            result.add(subList);
        }

        return result;
    }

}