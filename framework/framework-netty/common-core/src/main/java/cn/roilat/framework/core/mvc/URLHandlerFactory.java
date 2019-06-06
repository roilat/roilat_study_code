package cn.roilat.framework.core.mvc;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class URLHandlerFactory {
	public static final String ISO88591 = "ISO-8859-1";
	public static final String GBK = "GBK";
	public static final String UTF8 = "UTF-8";
	
	public static Map<String,Object> urlToClassmapping = new HashMap<String,Object>();
	public static Map<String,Method> urlMappingToMethod = new HashMap<String,Method>();
}
