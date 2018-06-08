
package cn.roilat.study.libs;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParseTest {
	 
    public static void main(String[] args) throws JsonProcessingException {
        Monitoring.begin();
        List<Corp> list = new ArrayList<>();// Lists.newArrayList();
        for (int i = 0; i < 1000; i++) {
            list.add(fullObject(Corp.class));
        }
        Monitoring.end("生成数据");
 
        Monitoring.begin();
        jackson(list);
        Monitoring.end("Jackson");
 
        Monitoring.begin();
        fastjson(list);
        Monitoring.end("fastjson");
 
    }
 
    public static void fastjson(List<Corp> list) {
        for (Corp corp : list) {
            String string = JSON.toJSONString(corp);
        }
    }
 
    public static void jackson(List<Corp> list) throws JsonProcessingException {
        for (Corp corp : list) {
            String string = new ObjectMapper().writeValueAsString(corp);
        }
    }
 
    /**
     * 填充一个对象（一般用于测试）
     */
    public static <T> T fullObject(Class<T> cl) {
        T t = null;
        try {
            t = cl.newInstance();
            Method methods[] = cl.getMethods();
            for (Method method : methods) {
                // 如果是set方法,进行随机数据的填充
                if (method.getName().indexOf("set") == 0) {
                    Class param = method.getParameterTypes()[0];
                    if (param.equals(String.class)) {
                        method.invoke(t, randomCodes(5));
                    } else if (param.equals(Short.class)) {
                        method.invoke(t, (short) new Random().nextInt(5));
                    } else if (param.equals(Float.class)) {
                        method.invoke(t, new Random().nextFloat());
                    } else if (param.equals(Double.class)) {
                        method.invoke(t, new Random().nextDouble());
                    } else if (param.equals(Integer.class)) {
                        method.invoke(t, new Random().nextInt(10));
                    } else if (param.equals(Long.class)) {
                        method.invoke(t, new Random().nextLong());
                    } else if (param.equals(Date.class)) {
                        method.invoke(t, new Date());
                    } else if (param.equals(java.sql.Timestamp.class)) {
                        method.invoke(t, new java.sql.Timestamp(System.currentTimeMillis()));
                    } else if (param.equals(java.sql.Date.class)) {
                        method.invoke(t, new java.sql.Date(System.currentTimeMillis()));
                    }
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return t;
    }

    private static char[] CHAR_TABLE = new char[36];
    private final static Random random = new Random();
    static {
        for (int idx = 0; idx < 10; ++idx)
        	CHAR_TABLE[idx] = (char) ('0' + idx);
        for (int idx = 10; idx < 36; ++idx)
        	CHAR_TABLE[idx] = (char) ('a' + idx - 10);
      }
	private static Object randomCodes(int i) {
		StringBuffer sb = new StringBuffer();
		while(i-- > 0){
			sb.append(random.nextInt(36));
		}
		return null;
	}
}
