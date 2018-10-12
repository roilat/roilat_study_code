package cn.roilat.study.jvm.runtime.constantspool;

public class TestStringConstantsPool {
    public static void main(String[] args) {
        String str = "laji";
        //String str2 = new String("MySQL");
        String str3 = new String("laji");

        System.out.println(str == str3);// 运行后结果为false
        System.out.println(str.hashCode() == str3.hashCode());//true
        System.out.println(str == str.intern());//true
        System.out.println(str == str3.intern());//true
        System.out.println(str3 == str3.intern());//false前者在堆上，后者在常量池

        primaryType();
    }

    /** 
     * * 8种基本类型的包装类和对象池 
     * * 包装类：java提供的为原始数据类型的封装类，如：int(基本数据类型)，Integer封装类。 
     * *      对象池：为了一定程度上减少频繁创建对象，将一些对象保存到一个"容器"中。 
     * *  
     * *   Byte,Short,Integer,Long,Character。这5种整型的包装类的对象池范围在-128~127之间，也就是说， 
     * *    超出这个范围的对象都会开辟自己的堆内存。 
     * *  
     * *  Boolean也实现了对象池技术。Double,Float两种浮点数类型的包装类则没有实现。 
     * *     String也实现了常量池技术。 
     * * 
     * * 自动装箱拆箱技术 
     * *    JDK5.0及之后允许直接将基本数据类型的数据直接赋值给其对应地包装类。
     * *  如：Integer i = 3;（这就是自动装箱） 
     * *  实际编译代码是：Integer i=Integer.valueOf(3); 编译器自动转换 
     * *    自动拆箱则与装箱相反：int i = (Integer)5; 
     * */

    public static void primaryType() {
        System.out.println("start primaryType...");
        //基本数据类型常量池范围-128~127       
        Integer n1 = -129;
        Integer n2 = -129;
        Long n3 = 100L;
        Long n4 = 100L;
        Double n5 = 12.0;
        Double n6 = 12.0;
        System.out.println("(n1 == n2) = " + (n1 == n2)); //false
        System.out.println("(n3 == n4) = " + (n3 == n4));//true
        System.out.println("(n5 == n6) = " + (n5 == n6)); //false
        System.out.println("(Integer) (-129) == (Integer) (-129) = " + ((Integer) (-129) == (Integer) (-129))); //false
        System.out.println("(Integer) 127.0 == (Integer) 127.0 = " + ((Integer) 127 == (Integer) 127)); //true
        System.out.println("(-129L == -129L) = " + (-129L == -129L)); //true(只有装箱了才会有常量池及地址比较的问题出现)
        System.out.println("(Long)  (-129L) == (Long)  (-129L) = " + ((Long) (-129L) == (Long) (-129L))); //false
        System.out.println("(Long) 127L == (Long) 127L = " + ((Long) 127L == (Long) 127L)); //true
        String str1 = "abcd";
        String str2 = "abcd";
        //String常量池技术,注意：这里String不是用new创建的对象 
        System.out.println("str1 == str2 = " + (str1 == str2));//true
        System.out.println("end primaryType...");

    }
}
