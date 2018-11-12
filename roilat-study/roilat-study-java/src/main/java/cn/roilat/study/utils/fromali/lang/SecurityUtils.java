/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package cn.roilat.study.utils.fromali.lang;

import com.alibaba.common.lang.StringUtil;

/**
 * 字符安全过滤工具类
 *
 * @author xfy90168
 * @version $Id: SecurityUtils.java, v 0.1 2018年6月11日 下午1:49:46 xfy90168 Exp $
 */
public class SecurityUtils {

    /**
     * 系统字符安全过滤
     *
     * @param prefix        前缀
     * @param suffix        后缀
     * @param str           原始字符串
     * @return              过滤字符串
     */
    public static String filterBankNo(String prefix, String suffix, Object obj) {
        if (obj == null) {
            return null;
        }
        return filterBankNo(prefix, suffix, obj.toString());
    }

    /**
     * 系统字符安全过滤
     *
     * @param prefix        前缀
     * @param suffix        后缀
     * @param str           原始字符串
     * @return              过滤字符串
     */
    public static String filterBankNo(String prefix, String suffix, String str) {
        if (StringUtil.isBlank(str)) {
            return str;
        }
        return str.replaceAll(prefix + "\\d+" + suffix, prefix + "***" + suffix);
    }

    /**
     * 系统字符安全过滤
     *
     * @param obj           原始字符串
     * @return              过滤字符串
     */
    public static String filterBankNo(Object obj) {
        return filterBankNo("BankNo=", ",",
            filterBankNo("bankNo=", ",",
                filterBankNo("bank_account_no=", ",", filterBankNo("bankAccountNo\":\"", "\"",
                    filterBankNo("银行账号：", ";", filterBankNo("bankAccountNo=", ",", obj))))));
    }

}