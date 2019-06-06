package cn.roilat.framework.utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

public class ObjectUtil {
	
	/********
	 * 判断对象是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmptyForObject(Object obj){
		if(obj == null) return true;
		if (obj.getClass().isArray()) {
			return Array.getLength(obj) == 0;
		}
		if (obj instanceof CharSequence) {
			return ((CharSequence) obj).length() == 0;
		}
		if (obj instanceof Collection) {
			return ((Collection<?>) obj).isEmpty();
		}
		if (obj instanceof Map) {
			return ((Map<?, ?>) obj).isEmpty();
		}
		return false;
	}
	
	/********
	 * 如需比较对象内容是否一致，需复写对象的equals和hashcode方法
	 * @param obj
	 * @param obj2
	 * @return
	 */
	public static boolean equals(Object obj,Object obj2){
		return equals(new Object[]{obj},new Object[]{obj2});
	}
	
	public static boolean equals(Object[] a, Object[] a2) {
        if (a == a2)
            return true;
        if (a == null || a2 == null)
            return false;

        int length = a.length;
        if (a2.length != length)
            return false;

        for (int i=0; i<length; i++) {
            Object o1 = a[i];
            Object o2 = a2[i];
            if(!(o1==null ? o2==null : o1.equals(o2))){
            	return false;
            }
        }
        return true;
    }
}
