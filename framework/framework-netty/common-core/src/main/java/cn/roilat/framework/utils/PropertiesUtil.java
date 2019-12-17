package cn.roilat.framework.utils;


import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import cn.roilat.framework.core.mvc.URLHandlerFactory;

public class PropertiesUtil {
	
	public static Properties property = null;
	/*******
	 * 加载属性文件，制定classpath下的属性文件路径及名称  config/xx.properties   
	 * 默认编码为utf-8
	 * @param srcFilePath   属性文件路径名称
	 * @return
	 * @throws Exception
	 */
	
	static{
		try {
			property = loadProperties("keyCode.properties",URLHandlerFactory.UTF8);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Properties loadProperties(String srcFilePath) throws Exception{
		return loadProperties(srcFilePath,cn.roilat.framework.core.mvc.URLHandlerFactory.UTF8);
	}
	
	public static Properties loadProperties(String srcFilePath,String encoding) throws Exception{
		InputStream inStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(srcFilePath);
		Properties property = new Properties();
		property.load(inStream);
		return property;
	}
	
	public static String getValue(final String key){
		return property.getProperty(key);
	}
	
	/*********
	 * 增加或更新属性值
	 * @param property
	 * @param key
	 * @param value
	 */
	public static void addOrUpdateProperty(Properties property,String key,String value){
		if(property == null || key == null || value == null){
			return;
		}
		if(property.containsKey(key)){
			property.setProperty(key, value);   //更新属性值
		}else{
			property.put(key, value);			//增加属性值
		}
	}
	
	/*******
	 * 属性转换成map
	 * @param property
	 * @return
	 */
	public static Map<String,String> getAllProperties(Properties property){
        Map<String,String> map=new HashMap<String,String>();
        //获取所有的键值
        Enumeration<?> enumeration=property.propertyNames();
        while(enumeration.hasMoreElements()){
            String key=(String) enumeration.nextElement();
            String value=(String)property.get(key);
            map.put(key, value);
        }
        return  map;
    }
	
	/*********
	 * 存在给定key属性就删除，否则不操作
	 * @param property
	 * @param key
	 */
	public static void deleteProperty(Properties property,String key){
		if(property == null || key == null){
			return;
		}
		if(property.containsKey(key)){
			property.remove(key);   //更新属性值
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(loadProperties("ftpconfig.properties"));
	}
}
