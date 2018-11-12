package cn.roilat.study.utils.fromali;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.util.Assert;

import com.alibaba.common.lang.StringUtil;
import com.alibaba.common.logging.Logger;
import com.alibaba.common.logging.LoggerFactory;

/**
 * 反射工具。【看看和spring的有没有重复的，可以的话就复用】
 *
 * @author Frankie
 * @version $Id: ReflectionUtil.java, v 0.1 2015年2月15日 下午12:39:17 Frankie Exp $
 */
public class ReflectionUtil {

    /** 日志 */
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * 判断是否是接口方法
     *
     * @param className
     * @param methodName
     * @return
     */
    public static boolean isInterfaceMethod(String className, String methodName) {

        try {
            Class<?>[] classes = Class.forName(className).getInterfaces();

            for (Class<?> clazz : classes) {
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.getName().equals(methodName)) {
                        return true;
                    }
                }
            }
        } catch (Throwable ex) {
            LOGGER.error("判断方法是否是该类的接口方法时发生异常", ex);
        }
        return false;

    }

    /**
     * 获取一个对象所有的（含父类的） DeclaredField，有异常返回空List
     *
     * @param object 子类对象
     * @return       属性对象列表
     */

    public static List<Field> getAllDeclaredField(Object object) {

        List<Field> fields = new ArrayList<Field>();

        try {
            Class<?> clazz = object.getClass();

            for (; clazz != null; clazz = clazz.getSuperclass()) {
                fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            }
        } catch (Throwable ex) {

            LOGGER.error("获取一个对象的DeclaredField时发生异常", ex);
        }

        return fields;
    }

    /**
     * 根据fieldName获取field，策略是如果当前对象没有对应的field就向上寻找，直到找到
     *
     * @param object
     * @param fieldName
     * @return
     */
    public static Field getDeclaredField(Object object, String fieldName) {

        try {
            Class<?> clazz = object.getClass();

            for (; clazz != null; clazz = clazz.getSuperclass()) {
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (StringUtil.equals(fieldName, field.getName())) {
                        return field;
                    }
                }

            }

        } catch (Throwable ex) {

            LOGGER.error("获取一个对象的DeclaredField时发生异常", ex);
        }

        return null;
    }

    /**
     * 获取一个field的value，异常已处理（ignore）
     *
     * @param object 子类对象
     * @param field  field
     * @return       一个field的value
     */

    public static Object getFieldValue(Object object, Field field) {

        //允许访问field
        field.setAccessible(true);

        try {

            return field.get(object);

        } catch (Throwable ex) {

            LOGGER.error("获取一个DeclaredField的value时发生异常", ex);
        }

        return null;
    }

    /**
     * 判断一个field是否是静态的
     *
     * @param field
     * @return
     */
    public static boolean isStatic(Field field) {

        return Modifier.isStatic(field.getModifiers());

    }

    /**
     * 判断一个对象是否是集合类型
     *
     * @param obj
     * @return
     */
    public static boolean isCollectionType(Object obj) {

        if (obj instanceof Collection) {

            return true;
        }
        return false;
    }

    /**
     * 判断一个对象是否是List类型
     *
     * @param obj
     * @return
     */
    public static boolean isListType(Object obj) {

        if (obj instanceof List) {

            return true;
        }
        return false;
    }

    /**
     * 判断一个对象是否是对象数组类型
     *
     * @param fieldValue
     * @return
     */
    public static boolean isArrayType(Object obj) {

        return obj.getClass().isArray();
    }

    /**
     * 判断一个对象是否是对象数组类型
     *
     * @param fieldValue
     * @return
     */
    public static boolean isSetType(Object obj) {

        if (obj instanceof Set) {

            return true;
        }
        return false;
    }

    /**
     * 判断一个类型是否是基本类型
     *
     * @param fieldValue
     * @return
     */
    public static boolean isPrimitiveType(Object fieldValue) {

        Class<?> classType = fieldValue.getClass();

        if (classType.isPrimitive() || fieldValue instanceof Boolean || fieldValue instanceof Byte
                || fieldValue instanceof Character || fieldValue instanceof Short
                || fieldValue instanceof Integer || fieldValue instanceof Long
                || fieldValue instanceof Float || fieldValue instanceof Double
                || fieldValue.equals(Void.class) || fieldValue instanceof CharSequence) {
            return true;
        }
        return false;
    }

    public static boolean isNumber(Object fieldValue) {
        if (fieldValue instanceof Short || fieldValue instanceof Integer
                || fieldValue instanceof Long || fieldValue instanceof Float
                || fieldValue instanceof Double || short.class.equals(fieldValue.getClass())
                || int.class.equals(fieldValue.getClass()) || long.class.equals(fieldValue.getClass())
                || float.class.equals(fieldValue.getClass())
                || double.class.equals(fieldValue.getClass())) {
            return true;
        }
        return false;
    }

    /**
     * 判断一个对象是否是Map类型
     *
     * @param fieldValue
     * @return
     */
    public static boolean isMapType(Object fieldValue) {
        if (fieldValue instanceof Map) {

            return true;
        }
        return false;
    }

    /**
     * 替换字段值
     *
     * @param obj
     * @param field
     * @param replaceValue
     * @return 成功返回true，失败返回false
     */
    public static boolean setFieldValue(Object obj, Field field, Object replaceValue) {
        field.setAccessible(true);
        try {
            field.set(obj, replaceValue);
        } catch (Throwable e) {
            LOGGER.error("字段设置值时发生异常", e);
            return false;
        }

        return true;

    }

    /**
     * 强制替换字段值，类型不一致的强转
     *
     * @param obj
     * @param field
     * @param replaceValue
     * @return 成功返回true，失败返回false
     */
    public static boolean setFieldValueForce(Object obj, Field field, Object replaceValue) {
        field.setAccessible(true);
        if (replaceValue != null) {

            Class<?> clazz = field.getType();

            if (!clazz.isAssignableFrom(replaceValue.getClass())) {
                if (String.class.isAssignableFrom(replaceValue.getClass())) {
                    String singleValue = replaceValue + "";
                    if (Boolean.class.isAssignableFrom(clazz)
                            || boolean.class.isAssignableFrom(clazz)) {
                        replaceValue = new Boolean(singleValue);
                    } else if (Byte.class.isAssignableFrom(clazz)
                            || byte.class.isAssignableFrom(clazz)) {
                        replaceValue = new Byte(singleValue);
                    } else if (Short.class.isAssignableFrom(clazz)
                            || short.class.isAssignableFrom(clazz)) {
                        replaceValue = new Short(singleValue);
                    } else if (Integer.class.isAssignableFrom(clazz)
                            || int.class.isAssignableFrom(clazz)) {
                        replaceValue = new Integer(singleValue);
                    } else if (Long.class.isAssignableFrom(clazz)
                            || long.class.isAssignableFrom(clazz)) {
                        replaceValue = new Long(singleValue);
                    } else if (Float.class.isAssignableFrom(clazz)
                            || float.class.isAssignableFrom(clazz)) {
                        replaceValue = new Float(singleValue);
                    } else if (Double.class.isAssignableFrom(clazz)
                            || double.class.isAssignableFrom(clazz)) {
                        replaceValue = new Double(singleValue);
                    } else if (Character.class.isAssignableFrom(clazz)
                            || char.class.isAssignableFrom(clazz)) {
                        replaceValue = new Character(singleValue.charAt(0));
                    } else if (Date.class.isAssignableFrom(clazz)) {

                        replaceValue = new Date(Long.parseLong(singleValue));
                    } else if (Calendar.class.isAssignableFrom(clazz)) {

                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(new Date(Long.parseLong(singleValue)));
                        replaceValue = calendar;
                    } else if (BigDecimal.class.isAssignableFrom(clazz)) {

                        replaceValue = new BigDecimal(singleValue);
                    }
                }
            }
        }

        try {
            field.set(obj, replaceValue);
        } catch (Throwable e) {
            LOGGER.error("字段设置值时发生异常", e);
            return false;
        }

        return true;

    }

    /**
     * 根据paramLoaction获取param
     *
     * @param arguments
     * @param paramLoaction
     * @return
     */
    public static Object getParamByParamLoaction(Object[] arguments, String paramLoaction)
            throws Throwable {

        String[] locations = paramLoaction.split("\\.");

        String locationStr = locations[0];
        int location = new Integer(locationStr.substring(1, locationStr.length() - 1));
        Object tmpArg = arguments[location];

        for (int i = 1; i < locations.length; i++) {
            String fieldName = locations[i];
            Field field = ReflectionUtil.getDeclaredField(tmpArg, fieldName);
            tmpArg = ReflectionUtil.getFieldValue(tmpArg, field);
        }

        return tmpArg;
    }

    /**
     * Attempt to find a {@link Field field} on the supplied {@link Class} with the
     * supplied <code>name</code>. Searches all superclasses up to {@link Object}.
     * @param clazz the class to introspect
     * @param name the name of the field
     * @return the corresponding Field object, or <code>null</code> if not found
     */
    public static Field findField(Class<?> clazz, String name) {
        return findField(clazz, name, null);
    }

    /**
     * Attempt to find a {@link Field field} on the supplied {@link Class} with the
     * supplied <code>name</code> and/or {@link Class type}. Searches all superclasses
     * up to {@link Object}.
     * @param clazz the class to introspect
     * @param name the name of the field (may be <code>null</code> if type is specified)
     * @param type the type of the field (may be <code>null</code> if name is specified)
     * @return the corresponding Field object, or <code>null</code> if not found
     */
    public static Field findField(Class<?> clazz, String name, Class<?> type) {
        Assert.notNull(clazz, "Class must not be null");
        Assert.isTrue(name != null || type != null,
                "Either name or type of the field must be specified");
        Class<?> searchType = clazz;
        while (!Object.class.equals(searchType) && searchType != null) {
            Field[] fields = searchType.getDeclaredFields();
            for (Field field : fields) {
                if ((name == null || name.equals(field.getName()))
                        && (type == null || type.equals(field.getType()))) {
                    return field;
                }
            }
            searchType = searchType.getSuperclass();
        }
        return null;
    }

    /**
     * Set the field represented by the supplied {@link Field field object} on the
     * specified {@link Object target object} to the specified <code>value</code>.
     * In accordance with {@link Field#set(Object, Object)} semantics, the new value
     * is automatically unwrapped if the underlying field has a primitive type.
     * <p>Thrown exceptions are handled via a call to {@link #handleReflectionException(Exception)}.
     * @param field the field to set
     * @param target the target object on which to set the field
     * @param value the value to set; may be <code>null</code>
     */
    public static void setField(Field field, Object target, Object value) {
        try {
            field.set(target, value);
        } catch (IllegalAccessException ex) {
            handleReflectionException(ex);
            throw new IllegalStateException("Unexpected reflection exception - "
                    + ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    /**
     * Get the field represented by the supplied {@link Field field object} on the
     * specified {@link Object target object}. In accordance with {@link Field#get(Object)}
     * semantics, the returned value is automatically wrapped if the underlying field
     * has a primitive type.
     * <p>Thrown exceptions are handled via a call to {@link #handleReflectionException(Exception)}.
     * @param field the field to get
     * @param target the target object from which to get the field
     * @return the field's current value
     */
    public static Object getField(Field field, Object target) {
        try {
            return field.get(target);
        } catch (IllegalAccessException ex) {
            handleReflectionException(ex);
            throw new IllegalStateException("Unexpected reflection exception - "
                    + ex.getClass().getName() + ": " + ex.getMessage());
        }
    }

    /**
     * Attempt to find a {@link Method} on the supplied class with the supplied name
     * and no parameters. Searches all superclasses up to <code>Object</code>.
     * <p>Returns <code>null</code> if no {@link Method} can be found.
     * @param clazz the class to introspect
     * @param name the name of the method
     * @return the Method object, or <code>null</code> if none found
     */
    public static Method findMethod(Class<?> clazz, String name) {
        return findMethod(clazz, name, new Class[0]);
    }

    /**
     * Attempt to find a {@link Method} on the supplied class with the supplied name
     * and parameter types. Searches all superclasses up to <code>Object</code>.
     * <p>Returns <code>null</code> if no {@link Method} can be found.
     * @param clazz the class to introspect
     * @param name the name of the method
     * @param paramTypes the parameter types of the method
     * (may be <code>null</code> to indicate any signature)
     * @return the Method object, or <code>null</code> if none found
     */
    public static Method findMethod(Class<?> clazz, String name, Class<?>... paramTypes) {
        Assert.notNull(clazz, "Class must not be null");
        Assert.notNull(name, "Method name must not be null");
        Class<?> searchType = clazz;
        while (searchType != null) {
            Method[] methods = (searchType.isInterface() ? searchType.getMethods() : searchType
                    .getDeclaredMethods());
            for (Method method : methods) {

                if (name.equals(method.getName())
                        && (paramTypes == null || isParamTypesMatch(paramTypes,
                        method.getParameterTypes()))) {
                    return method;
                }
            }
            searchType = searchType.getSuperclass();
        }
        return null;
    }

    /**
     * Attempt to find a {@link Method} on the supplied class with the supplied name
     * and parameter types. Searches all superclasses up to <code>Object</code>.
     * <p>Returns <code>null</code> if no {@link Method} can be found.
     * @param clazz the class to introspect
     * @param name the name of the method
     * @param paramTypes the parameter types of the method
     * (may be <code>null</code> to indicate any signature)
     * @return the Method object, or <code>null</code> if none found
     */
//    public static Method findMethod(Class<?> clazz, String name, Class[] paramTypes) {
//        Assert.notNull(clazz, "Class must not be null");
//        Assert.notNull(name, "Method name must not be null");
//        Class<?> searchType = clazz;
//        while (searchType != null) {
//            Method[] methods = (searchType.isInterface() ? searchType.getMethods() : searchType
//                    .getDeclaredMethods());
//            for (Method method : methods) {
//
//                if (name.equals(method.getName())
//                        && (paramTypes == null || isParamTypesMatch(paramTypes,
//                        method.getParameterTypes()))) {
//                    return method;
//                }
//            }
//            searchType = searchType.getSuperclass();
//        }
//        return null;
//    }

    /**
     *
     *
     * @param paramTypes
     * @param methodParamTypes
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static boolean isParamTypesMatch(Class[] paramTypes, Class[] methodParamTypes) {

        if (paramTypes == methodParamTypes)
            return true;
        if (paramTypes == null || methodParamTypes == null)
            return false;

        int length = paramTypes.length;
        if (methodParamTypes.length != length)
            return false;

        for (int i = 0; i < length; i++) {
            Class o1 = paramTypes[i];
            //当方法入参为null的时候，o1取不到值，不做匹配
            if (null == o1) {
                continue;
            }
            Class o2 = methodParamTypes[i];
            if ((o1.equals(Integer.class) && o2.equals(int.class)) || o1.equals(Long.class)
                    && o2.equals(long.class) || o1.equals(Boolean.class) && o2.equals(boolean.class)
                    || o1.equals(Byte.class) && o2.equals(byte.class) || o1.equals(Character.class)
                    && o2.equals(char.class) || o1.equals(Short.class) && o2.equals(short.class)
                    || o1.equals(Float.class) && o2.equals(float.class) || o1.equals(Double.class)
                    && o2.equals(double.class)) {
                continue;
            }
            if (!(o1 == null ? o2 == null : o1.equals(o2))) {

                //只要定义的参数类型，可以从实参复制。就可以传递。
                if (o1 != null && o2 != null && o2.isAssignableFrom(o1)) {
                    continue;
                }
                return false;
            }

        }

        return true;

    }

    //    public static void main(String[] args) {
    //
    //        Class[] c1 = new Class[1];
    //        Class[] c2 = new Class[1];
    //
    //        LinkedList<String> l1 = new LinkedList<String>();
    //        c1[0] = l1.getClass();
    //
    //        ArrayList<String> l2 = new ArrayList<String>();
    //        c2[0] = l2.getClass();
    //
    //        System.out.println(isParamTypesMatch(c1, c2));
    //
    //    }

    /**
     * Invoke the specified {@link Method} against the supplied target object with no arguments.
     * The target object can be <code>null</code> when invoking a static {@link Method}.
     * <p>Thrown exceptions are handled via a call to {@link #handleReflectionException}.
     * @param method the method to invoke
     * @param target the target object to invoke the method on
     * @return the invocation result, if any
     * @see #invokeMethod(java.lang.reflect.Method, Object, Object[])
     */
    public static Object invokeMethod(Method method, Object target) {
        return invokeMethod(method, target, new Object[0]);
    }

    /**
     * Invoke the specified {@link Method} against the supplied target object with the
     * supplied arguments. The target object can be <code>null</code> when invoking a
     * static {@link Method}.
     * <p>Thrown exceptions are handled via a call to {@link #handleReflectionException}.
     * @param method the method to invoke
     * @param target the target object to invoke the method on
     * @param args the invocation arguments (may be <code>null</code>)
     * @return the invocation result, if any
     */
    public static Object invokeMethod(Method method, Object target, Object... args) {
        try {
            return method.invoke(target, args);
        } catch (Exception ex) {
            handleReflectionException(ex);
        }
        throw new IllegalStateException("Should never get here");
    }

    /**
     * Invoke the specified JDBC API {@link Method} against the supplied target
     * object with no arguments.
     * @param method the method to invoke
     * @param target the target object to invoke the method on
     * @return the invocation result, if any
     * @throws SQLException the JDBC API SQLException to rethrow (if any)
     * @see #invokeJdbcMethod(java.lang.reflect.Method, Object, Object[])
     */
    public static Object invokeJdbcMethod(Method method, Object target) throws SQLException {
        return invokeJdbcMethod(method, target, new Object[0]);
    }

    /**
     * Invoke the specified JDBC API {@link Method} against the supplied target
     * object with the supplied arguments.
     * @param method the method to invoke
     * @param target the target object to invoke the method on
     * @param args the invocation arguments (may be <code>null</code>)
     * @return the invocation result, if any
     * @throws SQLException the JDBC API SQLException to rethrow (if any)
     * @see #invokeMethod(java.lang.reflect.Method, Object, Object[])
     */
    public static Object invokeJdbcMethod(Method method, Object target, Object... args)
            throws SQLException {
        try {
            return method.invoke(target, args);
        } catch (IllegalAccessException ex) {
            handleReflectionException(ex);
        } catch (InvocationTargetException ex) {
            if (ex.getTargetException() instanceof SQLException) {
                throw (SQLException) ex.getTargetException();
            }
            handleInvocationTargetException(ex);
        }
        throw new IllegalStateException("Should never get here");
    }

    /**
     * Handle the given reflection exception. Should only be called if no
     * checked exception is expected to be thrown by the target method.
     * <p>Throws the underlying RuntimeException or Error in case of an
     * InvocationTargetException with such a root cause. Throws an
     * IllegalStateException with an appropriate message else.
     * @param ex the reflection exception to handle
     */
    public static void handleReflectionException(Exception ex) {
        if (ex instanceof NoSuchMethodException) {
            throw new IllegalStateException("Method not found: " + ex.getMessage());
        }
        if (ex instanceof IllegalAccessException) {
            throw new IllegalStateException("Could not access method: " + ex.getMessage());
        }
        if (ex instanceof InvocationTargetException) {
            handleInvocationTargetException((InvocationTargetException) ex);
        }
        if (ex instanceof RuntimeException) {
            throw (RuntimeException) ex;
        }
        handleUnexpectedException(ex);
    }

    /**
     * Handle the given invocation target exception. Should only be called if no
     * checked exception is expected to be thrown by the target method.
     * <p>Throws the underlying RuntimeException or Error in case of such a root
     * cause. Throws an IllegalStateException else.
     * @param ex the invocation target exception to handle
     */
    public static void handleInvocationTargetException(InvocationTargetException ex) {
        rethrowRuntimeException(ex.getTargetException());
    }

    /**
     * Rethrow the given {@link Throwable exception}, which is presumably the
     * <em>target exception</em> of an {@link InvocationTargetException}. Should
     * only be called if no checked exception is expected to be thrown by the
     * target method.
     * <p>Rethrows the underlying exception cast to an {@link RuntimeException} or
     * {@link Error} if appropriate; otherwise, throws an
     * {@link IllegalStateException}.
     * @param ex the exception to rethrow
     * @throws RuntimeException the rethrown exception
     */
    public static void rethrowRuntimeException(Throwable ex) {
        if (ex instanceof RuntimeException) {
            throw (RuntimeException) ex;
        }
        if (ex instanceof Error) {
            throw (Error) ex;
        }
        handleUnexpectedException(ex);
    }

    /**
     * Rethrow the given {@link Throwable exception}, which is presumably the
     * <em>target exception</em> of an {@link InvocationTargetException}. Should
     * only be called if no checked exception is expected to be thrown by the
     * target method.
     * <p>Rethrows the underlying exception cast to an {@link Exception} or
     * {@link Error} if appropriate; otherwise, throws an
     * {@link IllegalStateException}.
     * @param ex the exception to rethrow
     * @throws Exception the rethrown exception (in case of a checked exception)
     */
    public static void rethrowException(Throwable ex) throws Exception {
        if (ex instanceof Exception) {
            throw (Exception) ex;
        }
        if (ex instanceof Error) {
            throw (Error) ex;
        }
        handleUnexpectedException(ex);
    }

    /**
     * Throws an IllegalStateException with the given exception as root cause.
     * @param ex the unexpected exception
     */
    private static void handleUnexpectedException(Throwable ex) {
        throw new IllegalStateException("Unexpected exception thrown", ex);
    }

    /**
     * Determine whether the given method explicitly declares the given
     * exception or one of its superclasses, which means that an exception of
     * that type can be propagated as-is within a reflective invocation.
     * @param method the declaring method
     * @param exceptionType the exception to throw
     * @return <code>true</code> if the exception can be thrown as-is;
     * <code>false</code> if it needs to be wrapped
     */
    public static boolean declaresException(Method method, Class<?> exceptionType) {
        Assert.notNull(method, "Method must not be null");
        Class<?>[] declaredExceptions = method.getExceptionTypes();
        for (Class<?> declaredException : declaredExceptions) {
            if (declaredException.isAssignableFrom(exceptionType)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determine whether the given field is a "public static final" constant.
     * @param field the field to check
     */
    public static boolean isPublicStaticFinal(Field field) {
        int modifiers = field.getModifiers();
        return (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers) && Modifier
                .isFinal(modifiers));
    }

    /**
     * Determine whether the given method is an "equals" method.
     * @see java.lang.Object#equals(Object)
     */
    public static boolean isEqualsMethod(Method method) {
        if (method == null || !method.getName().equals("equals")) {
            return false;
        }
        Class<?>[] paramTypes = method.getParameterTypes();
        return (paramTypes.length == 1 && paramTypes[0] == Object.class);
    }

    /**
     * Determine whether the given method is a "hashCode" method.
     * @see java.lang.Object#hashCode()
     */
    public static boolean isHashCodeMethod(Method method) {
        return (method != null && method.getName().equals("hashCode") && method.getParameterTypes().length == 0);
    }

    /**
     * Determine whether the given method is a "toString" method.
     * @see java.lang.Object#toString()
     */
    public static boolean isToStringMethod(Method method) {
        return (method != null && method.getName().equals("toString") && method.getParameterTypes().length == 0);
    }

    /**
     * Make the given field accessible, explicitly setting it accessible if
     * necessary. The <code>setAccessible(true)</code> method is only called
     * when actually necessary, to avoid unnecessary conflicts with a JVM
     * SecurityManager (if active).
     * @param field the field to make accessible
     * @see java.lang.reflect.Field#setAccessible
     */
    public static void makeAccessible(Field field) {
        if ((!Modifier.isPublic(field.getModifiers())
                || !Modifier.isPublic(field.getDeclaringClass().getModifiers()) || Modifier
                .isFinal(field.getModifiers())) && !field.isAccessible()) {
            field.setAccessible(true);
        }
    }

    /**
     * Make the given method accessible, explicitly setting it accessible if
     * necessary. The <code>setAccessible(true)</code> method is only called
     * when actually necessary, to avoid unnecessary conflicts with a JVM
     * SecurityManager (if active).
     * @param method the method to make accessible
     * @see java.lang.reflect.Method#setAccessible
     */
    public static void makeAccessible(Method method) {
        if ((!Modifier.isPublic(method.getModifiers()) || !Modifier.isPublic(method
                .getDeclaringClass().getModifiers())) && !method.isAccessible()) {
            method.setAccessible(true);
        }
    }

    /**
     * Make the given constructor accessible, explicitly setting it accessible
     * if necessary. The <code>setAccessible(true)</code> method is only called
     * when actually necessary, to avoid unnecessary conflicts with a JVM
     * SecurityManager (if active).
     * @param ctor the constructor to make accessible
     * @see java.lang.reflect.Constructor#setAccessible
     */
    public static void makeAccessible(Constructor<?> ctor) {
        if ((!Modifier.isPublic(ctor.getModifiers()) || !Modifier.isPublic(ctor.getDeclaringClass()
                .getModifiers())) && !ctor.isAccessible()) {
            ctor.setAccessible(true);
        }
    }

    /**
     * Perform the given callback operation on all matching methods of the given
     * class and superclasses.
     * <p>The same named method occurring on subclass and superclass will appear
     * twice, unless excluded by a {@link MethodFilter}.
     * @param clazz class to start looking at
     * @param mc the callback to invoke for each method
     * @see #doWithMethods(Class, MethodCallback, MethodFilter)
     */
    public static void doWithMethods(Class<?> clazz, MethodCallback mc)
            throws IllegalArgumentException {
        doWithMethods(clazz, mc, null);
    }

    /**
     * Perform the given callback operation on all matching methods of the given
     * class and superclasses (or given interface and super-interfaces).
     * <p>The same named method occurring on subclass and superclass will appear
     * twice, unless excluded by the specified {@link MethodFilter}.
     * @param clazz class to start looking at
     * @param mc the callback to invoke for each method
     * @param mf the filter that determines the methods to apply the callback to
     */
    public static void doWithMethods(Class<?> clazz, MethodCallback mc, MethodFilter mf)
            throws IllegalArgumentException {

        // Keep backing up the inheritance hierarchy.
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (mf != null && !mf.matches(method)) {
                continue;
            }
            try {
                mc.doWith(method);
            } catch (IllegalAccessException ex) {
                throw new IllegalStateException("Shouldn't be illegal to access method '"
                        + method.getName() + "': " + ex);
            }
        }
        if (clazz.getSuperclass() != null) {
            doWithMethods(clazz.getSuperclass(), mc, mf);
        } else if (clazz.isInterface()) {
            for (Class<?> superIfc : clazz.getInterfaces()) {
                doWithMethods(superIfc, mc, mf);
            }
        }
    }

    /**
     * Get all declared methods on the leaf class and all superclasses. Leaf
     * class methods are included first.
     */
    public static Method[] getAllDeclaredMethods(Class<?> leafClass)
            throws IllegalArgumentException {
        final List<Method> methods = new ArrayList<Method>(32);
        doWithMethods(leafClass, new MethodCallback() {
            public void doWith(Method method) {
                methods.add(method);
            }
        });
        return methods.toArray(new Method[methods.size()]);
    }

    /**
     * Invoke the given callback on all fields in the target class, going up the
     * class hierarchy to get all declared fields.
     * @param clazz the target class to analyze
     * @param fc the callback to invoke for each field
     */
    public static void doWithFields(Class<?> clazz, FieldCallback fc)
            throws IllegalArgumentException {
        doWithFields(clazz, fc, null);
    }

    /**
     * Invoke the given callback on all fields in the target class, going up the
     * class hierarchy to get all declared fields.
     * @param clazz the target class to analyze
     * @param fc the callback to invoke for each field
     * @param ff the filter that determines the fields to apply the callback to
     */
    public static void doWithFields(Class<?> clazz, FieldCallback fc, FieldFilter ff)
            throws IllegalArgumentException {

        // Keep backing up the inheritance hierarchy.
        Class<?> targetClass = clazz;
        do {
            Field[] fields = targetClass.getDeclaredFields();
            for (Field field : fields) {
                // Skip static and final fields.
                if (ff != null && !ff.matches(field)) {
                    continue;
                }
                try {
                    fc.doWith(field);
                } catch (IllegalAccessException ex) {
                    throw new IllegalStateException("Shouldn't be illegal to access field '"
                            + field.getName() + "': " + ex);
                }
            }
            targetClass = targetClass.getSuperclass();
        } while (targetClass != null && targetClass != Object.class);
    }

    /**
     * Given the source object and the destination, which must be the same class
     * or a subclass, copy all fields, including inherited fields. Designed to
     * work on objects with public no-arg constructors.
     * @throws IllegalArgumentException if the arguments are incompatible
     */
    public static void shallowCopyFieldState(final Object src, final Object dest)
            throws IllegalArgumentException {
        if (src == null) {
            throw new IllegalArgumentException("Source for field copy cannot be null");
        }
        if (dest == null) {
            throw new IllegalArgumentException("Destination for field copy cannot be null");
        }
        if (!src.getClass().isAssignableFrom(dest.getClass())) {
            throw new IllegalArgumentException("Destination class [" + dest.getClass().getName()
                    + "] must be same or subclass as source class ["
                    + src.getClass().getName() + "]");
        }
        doWithFields(src.getClass(), new FieldCallback() {
            public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
                makeAccessible(field);
                Object srcValue = field.get(src);
                field.set(dest, srcValue);
            }
        }, COPYABLE_FIELDS);
    }

    /**
     * Action to take on each method.
     */
    public interface MethodCallback {

        /**
         * Perform an operation using the given method.
         * @param method the method to operate on
         */
        void doWith(Method method) throws IllegalArgumentException, IllegalAccessException;
    }

    /**
     * Callback optionally used to method fields to be operated on by a method callback.
     */
    public interface MethodFilter {

        /**
         * Determine whether the given method matches.
         * @param method the method to check
         */
        boolean matches(Method method);
    }

    /**
     * Callback interface invoked on each field in the hierarchy.
     */
    public interface FieldCallback {

        /**
         * Perform an operation using the given field.
         * @param field the field to operate on
         */
        void doWith(Field field) throws IllegalArgumentException, IllegalAccessException;
    }

    /**
     * Callback optionally used to filter fields to be operated on by a field callback.
     */
    public interface FieldFilter {

        /**
         * Determine whether the given field matches.
         * @param field the field to check
         */
        boolean matches(Field field);
    }

    /**
     * Pre-built FieldFilter that matches all non-static, non-final fields.
     */
    public static FieldFilter  COPYABLE_FIELDS       = new FieldFilter() {

        public boolean matches(Field field) {
            return !(Modifier.isStatic(field
                    .getModifiers()) || Modifier
                    .isFinal(field.getModifiers()));
        }
    };

    /**
     * Pre-built MethodFilter that matches all non-bridge methods.
     */
    public static MethodFilter NON_BRIDGED_METHODS   = new MethodFilter() {

        public boolean matches(Method method) {
            return !method.isBridge();
        }
    };

    /**
     * Pre-built MethodFilter that matches all non-bridge methods
     * which are not declared on <code>java.lang.Object</code>.
     */
    public static MethodFilter USER_DECLARED_METHODS = new MethodFilter() {

        public boolean matches(Method method) {
            return (!method.isBridge() && method
                    .getDeclaringClass() != Object.class);
        }
    };
}
