package cn.roilat.study.utils.fromali.check;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String 工具类
 *
 * @author yu.qian
 * @version $Id: StringUtils.java, v 0.1 2018年8月31日 下午5:43:53 yu.qian Exp $
 */
public class StringUtils {

    /**
     * 校验是否是json串
     * 
     * @param str
     * @return
     */
    public static boolean isJson(String str) {

        if (isEmpty(str)) {
            return false;
        }
        try {
           Object obj= JSON.parse(str);

           if(obj instanceof JSONObject ||obj instanceof JSONArray)
           {
               return true;
           }

        } catch (Throwable t) {
            return false;
        }

        return false;

    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
}
