/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package cn.roilat.study.utils.fromali.lang;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import cn.roilat.study.utils.fromali.log.ExceptionUtil;

/**
 * Json序列化工具类fastjson
 * <p>
 *     解决JsonObject嵌套对象序列化失败问题
 * </p>
 *
 * @author xfy90168
 * @version $Id: JsonUtils.java, v 0.1 2018-5-1 下午7:49:41 xfy90168 Exp $
 */
public class JsonUtils {

    /** Comment for <code>objectMapper</code> */
    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(JsonParser.Feature.INTERN_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.CANONICALIZE_FIELD_NAMES, true);
        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    }

    /**
     * 获取objectMapper实例
     *
     * @return            objectMapper实例
     */
    public static ObjectMapper getObjectMapperInstance() {
        return objectMapper;
    }

    /**
     * 将对象转换为json字符串
     * @param data          对象
     * @return              json字符串
     */
    public static String toJsonString(Object data) {
        if (data == null) {
            return "{}";
        }
        try {
            return getObjectMapperInstance().writeValueAsString(data);
        } catch (IOException e) {
            ExceptionUtil.caught(e, "反序列化对象失败");
            throw new RuntimeException(e);
        }
    }

    /**
     * 将json字符串转换为指定类型实例
     *
     * @notice 当json字符串为空或者类型为null时,返回null,调用方要做非空判断
     *
     * @param jsonString    json字符串
     * @param type          class类型
     * @return              指定类型的实例
     */
    public static <T> T getObject(String jsonString, Class<T> type) {
        if (StringUtils.isBlank(jsonString) || type == null) {
            return null;
        }
        try {
            return getObjectMapperInstance().readValue(jsonString, type);
        } catch (IOException e) {
            ExceptionUtil.caught(e, "序列化json字符串失败");
            throw new RuntimeException(e);
        }
    }
}
