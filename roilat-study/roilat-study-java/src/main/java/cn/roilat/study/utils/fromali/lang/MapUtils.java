package cn.roilat.study.utils.fromali.lang;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>map工具类</p>
 *
 * @author maping.mp
 * @version $$Id: MapUtils.java, v 0.1 17/3/6 下午4:55 maping.mp Exp $$
 */
public class MapUtils {

    /**
     * 从map中获取string,不区分key的大小写
     * @param data
     * @param key
     * @return
     */
    public static String getStringIgnoreCase(Map<String, Object> data, String key) {
        Object value = data.get(key);
        if (value == null) {
            value = data.get(StringUtils.lowerCase(key));

            if (value == null) {
                value = data.get(StringUtils.upperCase(key));
            }
        }
        return value == null ? "" : value + "";
    }

    /**
     * 获取integer
     * @param data
     * @param key
     * @return
     */
    public static Integer getIntegerIgnoreCase(Map<String, Object> data, String key) {
        return NumberUtils.toInt(getStringIgnoreCase(data, key), 0);
    }

    /**
     * 从list中根据map的key,value值查找某个map对象
     * @param dataList
     * @param key
     * @param value
     * @return
     */
    @SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
    public static Map<String, Object> findMapInListByKey(List<Map<String, Object>> dataList,
                                                         final String key, final Object value) {
        Map<String, Object> result = (Map<String, Object>) CollectionUtils.find(dataList,
            new Predicate() {
                @Override
                public boolean evaluate(Object object) {
                    Map<String, Object> next = (Map<String, Object>) object;
                    return value == null ? false : value.equals(getStringIgnoreCase(next, key));
                }
            });
        return result == null ? new HashMap<String, Object>() : result;
    }

    /**
     * 根据value查找key,找不到返回null
     * @param headers
     * @param value
     * @return
     */
    public static Integer getKeyByValue(Map<Integer, String> headers, String value) {
        for (Integer key : headers.keySet()) {
            if (StringUtils.equalsIgnoreCase(value, headers.get(key))) {
                return key;
            }
        }
        return null;
    }
}
