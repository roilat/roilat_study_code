package cn.roilat.study.java.basic.object;

public class TestEqualAndHashCode {
    public static void main(String[] args) {
        Object obj = new Object() ;
        System.out.println(obj.hashCode());//hotspot/src/share/vm/runtime/synchronizer.cpp
        System.out.println("aaa".hashCode());
    }
    
}
