package cn.roilat.study.java.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Arrays.asList()方法生成的ArrayList是Arrays自己定义的，不是java.util.ArrayList.没有实现add方法。其中的add方法是abstractList的方法，会抛异常。
 *     public void add(int index, E element) {
 *       throw new UnsupportedOperationException();
 *     }
 * 
 * @author roilat-J
 * @version $Id: TestArrayAsList.java, v 0.1 2018年9月29日 下午3:00:11 roilat-J Exp $
 */
public class TestArrayAsList {

    public static void main(String[] args) {
        String[] str = new String[] { "you", "wu" };
        List<?> list = Arrays.asList(str);
        //list.add("21212");
        System.out.println(list.getClass());

        Object o = new Object();
        new ArrayList<>().indexOf(o);
        try {
            testCurrentModException1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        testCurrentModException2();
        
    }
    /**
     * 会抛出异常
     */
    public static void testCurrentModException1(){
        System.out.println("====testCurrentModException1==会抛出异常===");
        List<String> list = new LinkedList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("bbb");
        for (String s : list) {
            if(s.equals("aaa")){
                list.remove(s);
            }
        }
        System.out.println("testCurrentModException1:" + list);
    }
    
    /**
     * 不会抛出异常
     */
    public static void testCurrentModException2() {
        System.out.println("====testCurrentModException2==不会抛出异常===");

        List<String> list = new LinkedList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("bbb");
        Iterator<String> iter = list.iterator();
        for (;iter.hasNext();) {
            String s= iter.next();
            if(s.equals("aaa")){
                iter.remove();
            }
        }
        System.out.println("testCurrentModException2:" + list);
    }
    public static void testArrayAsList() {
        List<String> lists = new ArrayList<String>();
        lists.add("abc");
        lists.add("bbb");
        List<String> result = new ArrayList<String>();
        //System.out.println(result= Arrays.asList(lists.toArray()));//这种方式在jdk1.6的时候，好像没有问题
        System.out.println(result = Arrays.asList(lists.toArray(new String[lists.size()])));
    }
}
