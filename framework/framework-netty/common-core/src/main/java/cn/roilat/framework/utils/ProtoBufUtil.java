package cn.roilat.framework.utils;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ProtoBufUtil {

    @SuppressWarnings("unchecked")
	public static <T> byte[] serializer(T o) {
        @SuppressWarnings("rawtypes")
		Schema schema = RuntimeSchema.getSchema(o.getClass());
        return ProtobufIOUtil.toByteArray(o, schema, LinkedBuffer.allocate(256));
    }

    @SuppressWarnings("unchecked")
	public static <T> T deserializer(byte[] bytes, Class<T> clazz) {

        T obj = null;
        try {
            obj = clazz.newInstance();
            @SuppressWarnings("rawtypes")
			Schema schema = RuntimeSchema.getSchema(obj.getClass());
            ProtostuffIOUtil.mergeFrom(bytes, obj, schema);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return obj;
    }
    
    public static <T> byte[] serializeList(List<T> objList) {
        if (objList == null || objList.isEmpty()) {
            throw new RuntimeException("序列化对象列表(" + objList + ")参数异常!");
        }
        @SuppressWarnings("unchecked")
        Schema<T> schema = (Schema<T>) RuntimeSchema.getSchema(objList.get(0).getClass());
        LinkedBuffer buffer = LinkedBuffer.allocate(1024 * 1024);
        byte[] protostuff = null;
        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream();
            ProtostuffIOUtil.writeListTo(bos, objList, schema, buffer);
            protostuff = bos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("序列化对象列表(" + objList + ")发生异常!", e);
        } finally {
            buffer.clear();
            try {
                if(bos!=null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return protostuff;
    }
    
    public static <T> List<T> deserializeList(byte[] paramArrayOfByte, Class<T> targetClass) {
        if (paramArrayOfByte == null || paramArrayOfByte.length == 0) {
            throw new RuntimeException("反序列化对象发生异常,byte序列为空!");
        }
        
        Schema<T> schema = RuntimeSchema.getSchema(targetClass);
        List<T> result = null;
        try {
            result = ProtostuffIOUtil.parseListFrom(new ByteArrayInputStream(paramArrayOfByte), schema);
        } catch (IOException e) {
            throw new RuntimeException("反序列化对象列表发生异常!",e);
        }
        return result;
    }
    
    public static void main(String[] args) {
    	DemoUser user = new DemoUser();
    	user.setName("liuj");
    	byte[] b = serializer(user);
    	DemoUser u = deserializer(b,DemoUser.class);
    	System.out.println(u);
	}
}