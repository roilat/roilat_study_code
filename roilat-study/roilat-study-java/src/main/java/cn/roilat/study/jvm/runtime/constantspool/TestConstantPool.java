package cn.roilat.study.jvm.runtime.constantspool;

public class TestConstantPool {

    public static String a  = "a";
    public static Long   lo = 123L;
    public int           c;

    public static void main() {
        String b = "b";
        System.out.println(b);
    }

    public static int main1(java.util.Date date) {
        return 0;
    }
}
/*
执行命令:
javac TestConstantPool.java
javap -verbose TestConstantPool
 javap结果:
Classfile /C:/Users/wb-dtw368035/Desktop/Test.class
  Last modified 2018-10-12; size 782 bytes
  MD5 checksum 1492ce41dd0f3186e7568ddd8349b2e7
  Compiled from "Test.java"
public class Test
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #11.#35        // java/lang/Object."<init>":()V
   #2 = String             #36            // b
   #3 = Class              #37            // Test
   #4 = Methodref          #3.#35         // Test."<init>":()V
   #5 = String             #12            // a
   #6 = Fieldref           #3.#38         // Test.a:Ljava/lang/String;
   #7 = Long               123l
   #9 = Methodref          #39.#40        // java/lang/Long.valueOf:(J)Ljava/lang/Long;
  #10 = Fieldref           #3.#41         // Test.lo:Ljava/lang/Long;
  #11 = Class              #42            // java/lang/Object
  #12 = Utf8               a
  #13 = Utf8               Ljava/lang/String;
  #14 = Utf8               lo
  #15 = Utf8               Ljava/lang/Long;
  #16 = Utf8               c
  #17 = Utf8               I
  #18 = Utf8               <init>
  #19 = Utf8               ()V
  #20 = Utf8               Code
  #21 = Utf8               LineNumberTable
  #22 = Utf8               main
  #23 = Utf8               main1
  #24 = Utf8               (Ljava/util/Date;)I
  #25 = Utf8               StackMapTable
  #26 = Class              #43            // java/util/Date
  #27 = Class              #44            // java/lang/String
  #28 = Class              #42            // java/lang/Object
  #29 = Class              #45            // java/lang/Throwable
  #30 = Utf8               Exceptions
  #31 = Class              #46            // java/lang/Exception
  #32 = Utf8               <clinit>
  #33 = Utf8               SourceFile
  #34 = Utf8               Test.java
  #35 = NameAndType        #18:#19        // "<init>":()V
  #36 = Utf8               b
  #37 = Utf8               Test
  #38 = NameAndType        #12:#13        // a:Ljava/lang/String;
  #39 = Class              #47            // java/lang/Long
  #40 = NameAndType        #48:#49        // valueOf:(J)Ljava/lang/Long;
  #41 = NameAndType        #14:#15        // lo:Ljava/lang/Long;
  #42 = Utf8               java/lang/Object
  #43 = Utf8               java/util/Date
  #44 = Utf8               java/lang/String
  #45 = Utf8               java/lang/Throwable
  #46 = Utf8               java/lang/Exception
  #47 = Utf8               java/lang/Long
  #48 = Utf8               valueOf
  #49 = Utf8               (J)Ljava/lang/Long;
{
  public static java.lang.String a;
    descriptor: Ljava/lang/String;
    flags: ACC_PUBLIC, ACC_STATIC

  public static java.lang.Long lo;
    descriptor: Ljava/lang/Long;
    flags: ACC_PUBLIC, ACC_STATIC

  public Test();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 1: 0

  public static void main();
    descriptor: ()V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=1, locals=1, args_size=0
         0: ldc           #2                  // String b
         2: astore_0
         3: return
      LineNumberTable:
        line 6: 0
        line 7: 3

  public static int main1(java.util.Date) throws java.lang.Exception;
    descriptor: (Ljava/util/Date;)I
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=4, args_size=1
         0: ldc           #2                  // String b
         2: astore_1
         3: ldc           #3                  // class Test
         5: dup
         6: astore_2
         7: monitorenter
         8: new           #3                  // class Test
        11: dup
        12: invokespecial #4                  // Method "<init>":()V
        15: pop
        16: aload_2
        17: monitorexit
        18: goto          26
        21: astore_3
        22: aload_2
        23: monitorexit
        24: aload_3
        25: athrow
        26: iconst_0
        27: ireturn
      Exception table:
         from    to  target type
             8    18    21   any
            21    24    21   any
      LineNumberTable:
        line 9: 0
        line 10: 3
        line 11: 8
        line 12: 16
        line 13: 26
      StackMapTable: number_of_entries = 2
        frame_type = 255 // full_frame
          offset_delta = 21
          locals = [ class java/util/Date, class java/lang/String, class java/lang/Object ]
          stack = [ class java/lang/Throwable ]
        frame_type = 250 // chop
          offset_delta = 4
    Exceptions:
      throws java.lang.Exception

  static {};
    descriptor: ()V
    flags: ACC_STATIC
    Code:
      stack=2, locals=0, args_size=0
         0: ldc           #5                  // String a
         2: putstatic     #6                  // Field a:Ljava/lang/String;
         5: ldc2_w        #7                  // long 123l
         8: invokestatic  #9                  // Method java/lang/Long.valueOf:(J)Ljava/lang/Long;
        11: putstatic     #10                 // Field lo:Ljava/lang/Long;
        14: return
      LineNumberTable:
        line 2: 0
        line 3: 5
}
SourceFile: "Test.java"
*/
/**
 * 1.对于某个类或接口而言，其自身、父类和继承或实现的接口的信息会被直接组装成CONSTANT_Class_info常量池项放置到常量池中； 
 * 2. 类中或接口中使用到了其他的类，只有在类中实际使用到了该类时，该类的信息才会在常量池中有对应的CONSTANT_Class_info常量池项；(ps:如果只是声明了其它类型则没有,但是如果方法用户了其它类,则直接放到常量池中)
 * 3. 类中或接口中仅仅定义某种类型的变量，JDK只会将变量的类型描述信息以UTF-8字符串组成CONSTANT_Utf8_info常量池项放置到常量池中，上面在类中的private Date date;JDK编译器只会将表示date的数据类型的“Ljava/util/Date”字符串放置到常量池中。
 */
