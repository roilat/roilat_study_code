package cn.roilat.framework.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;

public class MapUtil {
	@SuppressWarnings("unused")
	public static String getSortMapExceptObject(Map<String, String> sortedParams) {
        StringBuffer content = new StringBuffer();
        List<String> keys = new ArrayList<String>(sortedParams.keySet());
        Collections.sort(keys);
        int index = 0;
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            // 特殊处理
            if (key.equals("beginTime") || key.equals("endTime")) {
				index++;
				continue;
			}
            String value = sortedParams.get(key);
            if (StringUtil.areNotEmpty(key, value) ) {
            	if (!(value.contains("{") && value.contains("}")) && !(value.contains("[") && value.contains("]"))) {
            		 content.append((content.length() > 0 ? "&" : "") + key + "=" + value); 
            	}
            	index++;
            }
        }
        return content.toString();
    }
	
	/************
	 * 该方法已经废弃。使用 ObjectUtil.isEmptyForObject(Object obj)
	 * @param map
	 * @return
	 */
	@Deprecated
	public static boolean isEmpty(Map<?,?> map){
		return map == null || map.isEmpty();
	}
	
	/************
	 * 该方法已经废弃。使用 ObjectUtil.isEmptyForObject(Object obj)
	 * @param map
	 * @return
	 */
	@Deprecated
	public static boolean isNotEmpty(Map<?,?> map){
		return !isEmpty(map);
	}
	
	/**********
	 * 将map转换成实体bean
	 * @param parameter  参数
	 * @param clazz      需要转换的对象
	 * @return
	 */
	public static <T> T transMap2Bean(Map<String,Object> parameter,Class<T> clazz){
		if(CollectionUtils.isEmpty(parameter)){
			return null;
		}
		return JSONObject.parseObject(JSONObject.toJSONString(parameter), clazz);
	}

	// Map --> Bean 2: 利用org.apache.commons.beanutils 工具类实现 Map --> Bean  
    public static void transMap2Bean2(Map<String, Object> map, Object obj) {  
        if (map == null || obj == null) {  
            return;  
        }  
        try {  
            BeanUtils.copyProperties(obj, map);  
        } catch (Exception e) {  
            System.out.println("transMap2Bean2 Error " + e);  
        }  
    }  
  
    // Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean  
    public static void transMap2Bean(Map<String, String> map, Object obj) {  
  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
  
                if (map.containsKey(key)) {  
                    Object value = map.get(key);  
                    if (value == null) {
                    	continue;
                    }
                    // 得到property对应的setter方法  
                    Method setter = property.getWriteMethod();  
                    Class<?> type = property.getPropertyType();
                    if (type.getName().contains("Integer")) {
                    	Integer intValue = Integer.parseInt(value.toString());
                    	 setter.invoke(obj, intValue);  
                    } else {
                    	 setter.invoke(obj, value.toString());  
                    }
                   
                }  
  
            }  
  
        } catch (Exception e) {  
            System.out.println("transMap2Bean Error " + e);  
            e.printStackTrace();
        }  
  
        return;  
  
    }  
  
    // Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map  
    public static Map<String, Object> transBean2Map(Object obj) {  
  
        if(obj == null){  
            return null;  
        }          
        Map<String, Object> map = new HashMap<String, Object>();  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
  
                // 过滤class属性  
                if (!key.equals("class")) {  
                    // 得到property对应的getter方法  
                    Method getter = property.getReadMethod();  
                    Object value = getter.invoke(obj);  
  
                    map.put(key, value);  
                }  
  
            }  
        } catch (Exception e) {  
            System.out.println("transBean2Map Error " + e);  
        }  
  
        return map;  
  
    }
    
    // Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map  
    public static Map<String, String> transBeanString2Map(Object obj) {  
  
        if(obj == null){  
            return null;  
        }          
        Map<String, String> map = new HashMap<String, String>();  
        try {  
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());  
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();  
            for (PropertyDescriptor property : propertyDescriptors) {  
                String key = property.getName();  
  
                // 过滤class属性  
                if (!key.equals("class")) {  
                    // 得到property对应的getter方法  
                    Method getter = property.getReadMethod();  
                    Object value = getter.invoke(obj);  
                    if (value != null && !"".equals(value.toString())) {
                    	map.put(key, value.toString());  
                    }
                }  
  
            }  
        } catch (Exception e) {  
            System.out.println("transBean2Map Error " + e);  
        }  
  
        return map;
    }
}
