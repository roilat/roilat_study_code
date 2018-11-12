package cn.roilat.study.utils.fromali.check;

import java.util.Collection;

import com.alipay.gsmartcenter.common.exception.GscSmartServiceException;
import com.alipay.gsmartcenter.common.exception.GscSmartServiceResultCodeEnum;

/**
 * SmartService断言工具
 * 
 * @author yu.qian
 * @version $Id: GscSmartServiceAssertUtils.java, v 0.1 2018年8月31日 下午5:43:53 yu.qian Exp $
 */
public class GscSmartServiceAssertUtils {

    /**
     * 断言不为Null
     * 
     * @param obj
     * @param errorMsg
     */
    public static void assertNotNull(Object obj, GscSmartServiceResultCodeEnum errorCode, String errorMsg) {
        if (obj == null) {
            throw new GscSmartServiceException(errorCode, errorMsg);
        }
    }

    /**
     * 断言不为空白
     * 
     * @param str
     * @param errorMsg
     */
    public static void assertNotBlank(String str, GscSmartServiceResultCodeEnum errorCode, String errorMsg) {
        if (str == null || str.isEmpty() || str.trim().isEmpty()) {
            throw new GscSmartServiceException(errorCode, errorMsg);
        }
    }

    /**
     * 断言数组不为空
     * 
     * @param objs
     * @param errorMsg
     */
    public static void assertNotEmpty(Object[] objs, GscSmartServiceResultCodeEnum errorCode, String errorMsg) {
        if (objs == null || objs.length == 0) {
            throw new GscSmartServiceException(errorCode, errorMsg);
        }
    }

    /**
     * 断言集合不为空
     * 
     * @param objs
     * @param errorMsg
     */
    @SuppressWarnings("rawtypes")
    public static void assertNotEmpty(Collection objs, GscSmartServiceResultCodeEnum errorCode, String errorMsg) {
        if (objs == null || objs.isEmpty()) {
            throw new GscSmartServiceException(errorCode, errorMsg);
        }
    }

    /**
     * 断言为真
     * 
     * @param b
     * @param errorMsg
     */
    public static void assertTrue(boolean b, GscSmartServiceResultCodeEnum errorCode, String errorMsg) {
        if (!b) {
            throw new GscSmartServiceException(errorCode, errorMsg);
        }
    }

}
