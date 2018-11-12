/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package cn.roilat.study.utils.fromali.serialize;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则匹配工具
 *
 * @author dongwang
 * @version $Id: RegularMatchUtil.java, v 0.1 2015年2月15日 下午3:07:57 dongwang Exp $
 */
public class RegularMatchUtils {

    /**
     * 是否匹配
     *
     * @param fromStr 要匹配的字符串
     * @param expr 规则
     * @return 返回是否匹配
     */
    public static boolean isMatched(String fromStr, String expr) {
        Pattern pattern = Pattern.compile(expr);
        Matcher matcher = pattern.matcher(fromStr);
        return matcher.matches();
    }

}
