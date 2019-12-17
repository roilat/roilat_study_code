package cn.roilat.framework.utils;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Java 操作Properties的工具类
 * 实现功能：
 * 1、Properties文件的增删查改功能
 * 2、解决读写中文乱码问题
 * @author Sean
 * 
 */
public class PropertyUtil {

    /**
     * Properties地址值，不需要加根标记"/"
     */
    private String src = "";
    private InputStreamReader inputStream = null;
    private OutputStreamWriter outputStream = null;
    private String encode="utf-8";
    public Properties properties ;

    /**
     * 默认构造函数
     */
    public PropertyUtil() {
    }

    /**
     * 构造函数
     * 
     * @param src        传入Properties地址值，不需要加根标记"/"
     */
    public PropertyUtil(String src) {
        this.src = src;
    }
    
    
    /**
     * 构造函数，提供设置编码模式
     * @param src        传入Properties地址值，不需要加根标记"/"
     * @param encode    传入对应的编码模式，默认是utf-8
     */
    public PropertyUtil(String src, String encode) {
        this(src);
        this.encode = encode;
    }

    /**
     * 加载properties文件
     * @author Sean
     * @date 2015-6-5
     * @return 返回读取到的properties对象
     */
    public Properties load(){
        if(src.trim().equals("")){
            throw new RuntimeException("The path of Properties File is need");
        }
        try {
            inputStream=new InputStreamReader(ClassLoader.getSystemResourceAsStream(src),encode);
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        properties=new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    
    /**
     * 将配置写入到文件
     * @author Sean
     * @date 2015-6-5
     * @throws Exception
     */
    public void write2File() throws Exception{
        //获取文件输出流
        outputStream=new OutputStreamWriter(new FileOutputStream(new File(ClassLoader.getSystemResource(src).toURI())),encode);
        properties.store(outputStream, null);
        close();
    }
    
    
    /**
     * 通过关键字获取值
     * @author Sean
     * @date 2015-6-5
     * @param key    需要获取的关键字
     * @return        返回对应的字符串，如果无，返回null
     */
    public String getValueByKey(String key){
        properties=load();
        String val =properties.getProperty(key.trim());
        close();
        return val;
        
    }
    
    /**
     * 通过关键字获取值
     * @author Sean
     * @date 2015-6-5
     * @param key            需要获取的关键字
     * @param defaultValue    若找不到对应的关键字时返回的值
     * @return                返回找到的字符串
     */
    public String getValueByKey(String key ,String defaultValue){
        properties=load();
        String val =properties.getProperty(key.trim(),defaultValue.trim());
        close();
        return val;
    }
    
    /**
     * 关闭输入输出流
     * @author Sean
     * @date 2015-6-5
     */
    public void close(){
        try {
            if(inputStream!=null){inputStream.close();}
            if(outputStream!=null){outputStream.close();}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取Properties所有的值
     * @author Sean
     * @date 2015-6-5
     * @return            返回Properties的键值对
     */
    public Map<String,String> getAllProperties(){
        properties=load();
        Map<String,String> map=new HashMap<String,String>();
        //获取所有的键值
        Enumeration<?> enumeration=properties.propertyNames();
        while(enumeration.hasMoreElements()){
            String key=(String) enumeration.nextElement();
            String value=getValueByKey(key);
            map.put(key, value);
        }
        close();
        return  map;
    }
    
    /**
     * 往Properties写入新的键值
     * @author Sean
     * @date 2015-6-5
     * @param key    对应的键
     * @param value    对应的值
     */
    public void addProperties(String key,String value){
        properties=load();
        properties.put(key, value);
        try {
            write2File();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 添加Map中所有的值
     * @author Sean
     * @date 2015-6-5
     * @param map    对应的键值对集合
     */
    public void addAllProperties(Map<String,String> map){
        properties=load();
        properties.putAll(map);
        try {
            write2File();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("write fail");
        }
    }
    
    /**
     * 更新配置文件
     * @author Sean
     * 2015-6-5
     * @param key    需要更新的键值
     * @param value    对应的值
     */
    public void update(String key,String value){
        properties=load();
        if(!properties.containsKey(key)){
            throw new RuntimeException("not such key");
        }
        properties.setProperty(key, value);
        try {
            write2File();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("write fail");
        }
    }
    
    /**
     * 删除某一键值对
     * @author Sean
     * 2015-6-5
     * @param key    对应的键值
     */
    public void deleteKey(String key){
        properties=load();
        if(!properties.containsKey(key)){
            throw new RuntimeException("not such key");
        }
        properties.remove(key);
        try {
            write2File();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("write fail");
        }
    }
    
    /**
     * 设置path值
     * @author Sean
     * @date 2015-6-5
     * @param src    对应文件值
     */
    public void setSrc(String src) {
        this.src = src;
    }
}