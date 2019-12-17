package cn.roilat.framework.utils;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ReflectUtil {
	
	
	/**********
	 * 获取对象中的字段信息 （非static类型）
	 * @param obj
	 * @return
	 */
	public static List<Field> getFields(Object obj){
		List<Field> list = new ArrayList<Field>();
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			for(Field field:fields){
				if(Modifier.isStatic(field.getModifiers())){
					continue;
				}
				list.add(field);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Field getField(String fieldName,Object obj){
		Field field = null;
		try {
			field = obj.getClass().getDeclaredField(fieldName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return field;
	}
	
	public static Field getField(String fieldName,Class<?> clazz){
		Field field = null;
		try {
			field = clazz.getDeclaredField(fieldName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return field;
	}
	
	public static Object getValueByField(Field field,Object obj){
		Object value = null;
		try {
			if(!field.isAccessible()){
				field.setAccessible(true);
			}
			value = field.get(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public static Object getValueByField(String fieldName,Object obj){
		Field field = getField(fieldName, obj);
		return getValueByField(field,obj);
	}
	
	/**********
	 * 通过属性字段设置其值
	 * @param fieldName
	 * @param obj
	 * @param value
	 */
	public static void setValue(String fieldName,Object obj,Object value){
		Field field = getField(fieldName, obj);
		setValue(field,obj,value);
	}
	
	public static void setValue(Field field,Object obj,Object value){
		if(field != null && !ObjectUtil.isEmptyForObject(obj)){
			if(!field.isAccessible()){
				field.setAccessible(true);
			}
			try {
				field.set(obj, value);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	/******
	 * 实例化对象
	 * @param clazz  需要实例化对象的class
	 * @return
	 */
	public static <T> T instantClass(Class<T> clazz){
		T t = null;
		try {
			if(!clazz.isInterface()){
				t = clazz.newInstance();
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	public static Method getMethod(Object target,String methodName){
		if(ObjectUtil.isEmptyForObject(target)){
			return null;
		}
		return getMethod(target.getClass(),methodName);
	}
	
	public static Method getMethod(Class<?> clazz,String methodName){
		if(ObjectUtil.isEmptyForObject(clazz)){
			return null;
		}
		if(StringUtil.isEmpty(methodName)){
			return null;
		}
		Class<?> searchType = clazz;
		while(searchType != null && !Object.class.equals(searchType)){
			Method[] methods = searchType.isInterface() ? searchType.getMethods() : searchType.getDeclaredMethods();
			for(Method method:methods){
				if(methodName.equals(method.getName())){
					return method;
				}
			}
			searchType = clazz.getSuperclass();
		}
		return null;
	}
	
	/*******
	 * 调用方法
	 * @param method  目标方法
	 * @param target  目标对象
	 * @param args	     目标方法中的参数
	 * @return
	 */
	public static Object invokeMethod(Method method,Object target,Object ... args){
		Object value = null;
		try {
			if(method == null || ObjectUtil.isEmptyForObject(target)){
				return null;
			}
			value = method.invoke(target, args);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return value;
	}
	/*******
	 * 调用方法
	 * @param method  目标方法
	 * @param target  目标对象
	 * @param args	     目标方法中的参数
	 * @return
	 */
	public static Object invokeMethod(String methodName,Object target,Object ... args){
		if(StringUtil.isEmpty(methodName)){
			try {
				throw new Exception("方法名称不能为空");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Method method = getMethod(target, methodName);
		return invokeMethod(method,target,args);
	}
	
	public static void main(String[] args) {
	}
}
