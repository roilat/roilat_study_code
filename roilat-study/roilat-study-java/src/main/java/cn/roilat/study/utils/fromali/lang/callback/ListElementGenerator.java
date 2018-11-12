/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package cn.roilat.study.utils.fromali.lang.callback;

/**
 * List元素生成功具
 * @author zhengbin.zuo
 * @version $Id: ListUtil.java, v 0.1 2016年9月29日 下午2:33:34 york Exp $
 */
public interface ListElementGenerator<T> {
    /**
     * 使用构造元素转换为List中元素
     * @param ob  需要转换的值
     * @return    List中元素
     */
    public T genElement(Object ob);
}