package cn.roilat.study.java.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
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
    }
}
