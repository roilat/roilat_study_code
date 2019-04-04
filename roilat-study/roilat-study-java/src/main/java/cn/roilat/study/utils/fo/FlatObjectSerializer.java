/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package cn.roilat.study.utils.fo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Set;

/**
 * @author liuzhengzheng.lz
 * @version $Id: FlatObjectSerializer, v 0.1 2018-09-03 下午9:30 liuzhengzheng.lz Exp $
 */
public class FlatObjectSerializer {

    /**
     * 构造扁平对象
     *
     * @param obj
     *
     * @return
     */
    public FlatObject toFlatObj(Object obj) {
        Object jsonObj = JSON.toJSON(obj);
        FlatObject flatObj = new FlatObject();
        convertToFlatObject(flatObj, "", jsonObj);
        return flatObj;
    }

    private void convertToFlatObject(FlatObject flatObj, String key, Object obj) {

        if (obj instanceof JSONArray) {
            String next;
            JSONArray jsonArray = (JSONArray)obj;
            for (int i = 0; i < jsonArray.size(); i++) {
                next = key + "[]." + i;
                Object arrObj = jsonArray.get(i);
                if (isJSON(arrObj)) {
                    convertToFlatObject(flatObj, next + ".", jsonArray.get(i));
                } else {
                    flatObj.put(next, jsonArray.get(i));
                }
            }
        } else if (obj instanceof JSONObject) {
            Set<String> keySet = ((JSONObject)obj).keySet();
            for (String objKey : keySet) {
                Object jsonObj = ((JSONObject)obj).get(objKey);
                if (isJSON(jsonObj)) {
                    convertToFlatObject(flatObj, key + objKey + ".", jsonObj);
                } else {
                    flatObj.put(key + objKey, jsonObj);
                }
            }
        } else {
            flatObj.put(key, obj);
        }
    }

    /**
     * @param obj
     *
     * @return
     */
    private boolean isJSON(Object obj) {

        if (obj instanceof JSONArray || obj instanceof JSONObject) {
            return true;
        } else {
            return false;
        }
    }

    public FlatObject toFlatObjFromJson(String jsonStr) {
        return toFlatObj(JSONObject.parse(jsonStr));
    }
}
