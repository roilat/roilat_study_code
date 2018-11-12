/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package cn.roilat.study.utils.fromali.lang;

import org.openjdk.jmh.runner.RunnerException;

import cn.roilat.study.utils.StringUtil;

/**
 * 断言校验参数
 *
 * @author roilat-J
 * @version $Id: AssertUtil.java, v 0.1 2018-2-27 下午1:35:19 roilat-J Exp $
 */
public class AssertUtil {

    /**
     * 断言字符串不能为空
     *
     * @param str            字符串
     */
    public static void assertNotBlank(String... str) {
        for (String s : str) {
            if (StringUtil.isEmpty(s)) {
                throw new RuntimeException("参数不能为空");
            }
        }
    }

    /**
     * 断言字符串不能为空
     *
     * @param param            参数字段
     * @param param            参数名称描述
     */
    public static void assertNotBlank(String param, String fieldName) {
        if (StringUtil.isEmpty(param)) {
            throw new RuntimeException(String.format("%s不能为空", fieldName));
        }
    }

    /**
     * 断言对象不能为空
     *
     * @param obj           对象
     */
    public static void assertNotNull(Object... obj) {
        for (Object o : obj) {
            if (o == null) {
                throw new RuntimeException("参数不能为空");
            }
        }
    }

    public static void assertTrue(boolean b, String s) {
        if (!b) {
            throw new RuntimeException(s);

        }
    }
}
