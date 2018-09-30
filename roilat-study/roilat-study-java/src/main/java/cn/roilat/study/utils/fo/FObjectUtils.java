package cn.roilat.study.utils.fo;

import org.springframework.util.PatternMatchUtils;

import cn.roilat.study.utils.StringUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * FObject格式属性获取工具
 *
 * @author Frankie
 * @version $Id: FObjectPropertyGetsUtil.java, v 0.1 2015年7月28日 下午8:55:16 Frankie Exp $
 */
public class FObjectUtils {

    /** FObject序列化器 */
    private static FlatObjectSerializer fObjectSerializer = new FlatObjectSerializer();


    /**
     * 根据表达式获取属性（精确获取,单值）
     *
     * @param obj
     * @param expression
     *
     * @return
     */
    public static Object getProperty(Object obj, String expression) {

        FlatObject fobject = fObjectSerializer.toFlatObj(obj);
        Set<String> keys = fobject.getValueMap().keySet();

        if (keys != null) {
            for (String key : keys) {
                if (StringUtil.equals(key, expression)) {

                    return fobject.get(key);

                }
            }
        }


        return null;

    }

    /**
     * 根据表达式获取属性（模糊获取，结果Map的key属性路径，value为属性值）
     *
     * @param obj        对象
     * @param expression 采用FObject表达式（支持simpleMatch）
     *
     * @return
     */
    public static Map<String, Object> getPropertyByFuzzy(Object obj, String expression) {

        Map<String, Object> properties = new HashMap<String, Object>();

        FlatObject fobject = fObjectSerializer.toFlatObj(obj);
        Set<String> keys = fobject.getValueMap().keySet();

        if (keys != null) {
            for (String key : keys) {
                if (PatternMatchUtils.simpleMatch(expression, key)) {
                    properties.put(key, fobject.get(key));

                }
            }
        }
        return properties;

    }
}
