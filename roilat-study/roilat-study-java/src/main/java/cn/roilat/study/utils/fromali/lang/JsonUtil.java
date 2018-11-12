/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package cn.roilat.study.utils.fromali.lang;

import java.util.Collection;

//import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

/**
 * json处理类工具
 * @author wb-qiantf
 * @version $Id: JsonUtil.java, v 0.1 2011-3-10 下午09:52:26 wb-qiantf Exp $
 */
public class JsonUtil {

    /**
     * 从一个JSON数组得到一个java对象数组，形如： [{"id" : idValue, "name" : nameValue}, {"id" :
     * idValue, "name" : nameValue}, ...]
     *
     * @param object
     * @param clazz
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Object[] getDTOArray(String jsonString, Class clazz) {
        setDataFormat2JAVA();
        JSONArray array = JSONArray.fromObject(jsonString);
        Object[] obj = new Object[array.size()];
        for (int i = 0; i < array.size(); i++) {
            JSONObject jsonObject = array.getJSONObject(i);
            obj[i] = JSONObject.toBean(jsonObject, clazz);
        }
        return obj;
    }

    /**
     * 把数据对象转换成json字符串 DTO对象形如：{"id" : idValue, "name" : nameValue, ...}
     * 数组对象形如：[{}, {}, {}, ...] map对象形如：{key1 : {"id" : idValue, "name" :
     * nameValue, ...}, key2 : {}, ...}
     *
     * @param object
     * @return
     */
    public static String getJSONString(Object object) {
        String jsonString = null;
        if (object != null) {
            if (object instanceof Collection || object instanceof Object[]) {
                jsonString = JSONArray.fromObject(object).toString();
            } else {
                jsonString = JSONObject.fromObject(object).toString();
            }
        }
        return jsonString == null ? "{}" : jsonString;
    }

    private static void setDataFormat2JAVA() {
        // 设定日期转换格式
        /*JSONUtils.getMorpherRegistry()
            .registerMorpher(new DateMorpher(new String[] { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss" }));*/
    }
}
