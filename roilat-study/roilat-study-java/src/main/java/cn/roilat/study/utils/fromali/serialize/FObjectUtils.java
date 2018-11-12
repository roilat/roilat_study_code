package cn.roilat.study.utils.fromali.serialize;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.alibaba.common.lang.StringUtil;
import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.gsmartcenter.serialize.FlatObject;
import com.alipay.gsmartcenter.serialize.FlatObjectSerializer;
import org.springframework.util.PatternMatchUtils;

/**
 * FObject��ʽ���Ի�ȡ����
 *
 * @author Frankie
 * @version $Id: FObjectPropertyGetsUtil.java, v 0.1 2015��7��28�� ����8:55:16 Frankie Exp $
 */
public class FObjectUtils {

    /** ��־ */
    private static final Logger         LOGGER            = LoggerFactory.getLogger("MODEL-SCRIPT");

    /** FObject���л��� */
    private static FlatObjectSerializer fObjectSerializer = new FlatObjectSerializer();

    /**
     * ���ݱ��ʽ��ȡ���ԣ���ȷ��ȡ,��ֵ��
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

        return getPropertyByJsonObj(obj, expression);

    }

    private static Object getPropertyByJsonObj(Object obj, String expression) {

        String[] exprs = expression.split("\\.");
        Object jsonObj = JSON.toJSON(obj);

        Object subJsonObj = jsonObj;
        for (String expr : exprs) {
            if(subJsonObj==null)
            {
                return null;
            }

            if (subJsonObj instanceof JSONObject) {
                subJsonObj = ((JSONObject) subJsonObj).get(expr);
            }
            else
            if (subJsonObj instanceof JSONArray) {
                subJsonObj = ((JSONArray) subJsonObj).get(new Integer(expr.substring(1, expr.length() - 1)));
            }

        }

        return subJsonObj;
    }

    /**
     * ���ݱ��ʽ��ȡ���ԣ���ȷ��ȡ,��ֵ��
     *
     * @param jsonStr
     * @param expression
     *
     * @return
     */
    public static Object getPropertyByJson(String jsonStr, String expression) {

        FlatObject fobject = fObjectSerializer.toFlatObjFromJson(jsonStr);
        Set<String> keys = fobject.getValueMap().keySet();

        if (keys != null) {
            for (String key : keys) {
                if (StringUtil.equals(key, expression)) {

                    return fobject.get(key);

                }
            }
        }

        LOGGER.warn("���ʽ��ƥ�䣬û�л�ȡ����Ҫ�����ԣ�fobject=" + fobject + ",expression=" + expression);

        return null;

    }

    /**
     * ���ݱ��ʽ��ȡ���ԣ�ģ����ȡ�����Map��key����·����valueΪ����ֵ��
     *
     * @param obj        ����
     * @param expression ����FObject���ʽ��֧��simpleMatch��
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
