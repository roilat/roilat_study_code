package cn.roilat.study.java.basic.object;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试结果说明，如果重写了equal或者hashCode方法后，最好也要重写另一个方法，因为在很多地方（如HashMap）在处理两个对象是否相等时
 * ，会同时使用到hashcode和equal方法
 * 原则就是，判断一个类的两个实例是否相等时，hashcode和equals方法的参考逻辑最好是一致的，即hashCode一致，则equals也应该返回true;
 * 
 * 
 * @author roilat-J
 * @version $Id: TestHashMap.java, v 0.1 2018年10月12日 下午6:16:39 roilat-J Exp $
 */
public class TestEqualAndHashCodeInHashMap {
    public static void main(String[] args) {
        Map<TestKey1, String> map1 = new HashMap<TestKey1, String>();
        TestKey1 tk11, tk12;
        map1.put(tk11 = new TestKey1("roilat", 12), "hello1");
        map1.put(tk12 = new TestKey1("roilat", 12), "hello2");
        System.out.println(map1);
        System.out.println(tk11.hashCode() + "---" + tk12.hashCode());//value 相同
        System.out.println(tk11.equals(tk12));//false
        //使用默认的equals方法
        System.out.println("hash code返回一样，但是equal 结果不一样，导致对象是两个");

        System.out.println("-----------------------------------------------");

        Map<TestKey2, String> map2 = new HashMap<TestKey2, String>();
        TestKey2 tk21, tk22;
        map2.put(tk21 = new TestKey2("roilat", 12), "hello1");
        map2.put(tk22 = new TestKey2("roilat", 12), "hello2");
        System.out.println(map2);
        System.out.println(tk21.hashCode() + "---" + tk22.hashCode());//value 相同
        System.out.println(tk21.equals(tk22));//true
        System.out.println("hash code返回一样，重写equal逻辑一样，所以两个结果一样");
    }
}

class TestKey1 {
    private String name;
    private int    age;

    public TestKey1(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    /*@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TestKey other = (TestKey) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }*/
}

class TestKey2 {
    private String name;
    private int    age;

    public TestKey2(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TestKey2 other = (TestKey2) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}