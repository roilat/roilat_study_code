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
Classfile /D:/WorkSpace/roilat/roilat-study/roilat-study-java/target/classes/cn/roilat/study/jvm/runtime/constantspool/TestConstantPool.class
  Last modified 2018-12-17; size 942 bytes
  MD5 checksum abd11f9dfe8f00350f43757b64bdf4e3
  Compiled from "TestConstantPool.java"
public class cn.roilat.study.jvm.runtime.constantspool.TestConstantPool
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Class              #2             // cn/roilat/study/jvm/runtime/constantspool/TestConstantPool
   #2 = Utf8               cn/roilat/study/jvm/runtime/constantspool/TestConstantPool
   #3 = Class              #4             // java/lang/Object
   #4 = Utf8               java/lang/Object
   #5 = Utf8               a
   #6 = Utf8               Ljava/lang/String;
   #7 = Utf8               lo
   #8 = Utf8               Ljava/lang/Long;
   #9 = Utf8               c
  #10 = Utf8               I
  #11 = Utf8               <clinit>
  #12 = Utf8               ()V
  #13 = Utf8               Code
  #14 = String             #5             // a
  #15 = Fieldref           #1.#16         // cn/roilat/study/jvm/runtime/constantspool/TestConstantPool.a:Ljava/lang/String;
  #16 = NameAndType        #5:#6          // a:Ljava/lang/String;
  #17 = Long               123l
  #19 = Methodref          #20.#22        // java/lang/Long.valueOf:(J)Ljava/lang/Long;
  #20 = Class              #21            // java/lang/Long
  #21 = Utf8               java/lang/Long
  #22 = NameAndType        #23:#24        // valueOf:(J)Ljava/lang/Long;
  #23 = Utf8               valueOf
  #24 = Utf8               (J)Ljava/lang/Long;
  #25 = Fieldref           #1.#26         // cn/roilat/study/jvm/runtime/constantspool/TestConstantPool.lo:Ljava/lang/Long;
  #26 = NameAndType        #7:#8          // lo:Ljava/lang/Long;
  #27 = Utf8               LineNumberTable
  #28 = Utf8               LocalVariableTable
  #29 = Utf8               <init>
  #30 = Methodref          #3.#31         // java/lang/Object."<init>":()V
  #31 = NameAndType        #29:#12        // "<init>":()V
  #32 = Utf8               this
  #33 = Utf8               Lcn/roilat/study/jvm/runtime/constantspool/TestConstantPool;
  #34 = Utf8               main
  #35 = String             #36            // b
  #36 = Utf8               b
  #37 = Fieldref           #38.#40        // java/lang/System.out:Ljava/io/PrintStream;
  #38 = Class              #39            // java/lang/System
  #39 = Utf8               java/lang/System
  #40 = NameAndType        #41:#42        // out:Ljava/io/PrintStream;
  #41 = Utf8               out
  #42 = Utf8               Ljava/io/PrintStream;
  #43 = Methodref          #44.#46        // java/io/PrintStream.println:(Ljava/lang/String;)V
  #44 = Class              #45            // java/io/PrintStream
  #45 = Utf8               java/io/PrintStream
  #46 = NameAndType        #47:#48        // println:(Ljava/lang/String;)V
  #47 = Utf8               println
  #48 = Utf8               (Ljava/lang/String;)V
  #49 = Utf8               main1
  #50 = Utf8               (Ljava/util/Date;)I
  #51 = Utf8               date
  #52 = Utf8               Ljava/util/Date;
  #53 = Utf8               SourceFile
  #54 = Utf8               TestConstantPool.java
{
  public static java.lang.String a;
    descriptor: Ljava/lang/String;
    flags: ACC_PUBLIC, ACC_STATIC

  public static java.lang.Long lo;
    descriptor: Ljava/lang/Long;
    flags: ACC_PUBLIC, ACC_STATIC

  public int c;
    descriptor: I
    flags: ACC_PUBLIC

  static {};
    descriptor: ()V
    flags: ACC_STATIC
    Code:
      stack=2, locals=0, args_size=0
         0: ldc           #14                 // String a
         2: putstatic     #15                 // Field a:Ljava/lang/String;
         5: ldc2_w        #17                 // long 123l
         8: invokestatic  #19                 // Method java/lang/Long.valueOf:(J)Ljava/lang/Long;
        11: putstatic     #25                 // Field lo:Ljava/lang/Long;
        14: return
      LineNumberTable:
        line 5: 0
        line 6: 5
      LocalVariableTable:
        Start  Length  Slot  Name   Signature

  public cn.roilat.study.jvm.runtime.constantspool.TestConstantPool();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #30                 // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 3: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lcn/roilat/study/jvm/runtime/constantspool/TestConstantPool;

  public static void main();
    descriptor: ()V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=1, args_size=0
         0: ldc           #35                 // String b
         2: astore_0
         3: getstatic     #37                 // Field java/lang/System.out:Ljava/io/PrintStream;
         6: aload_0
         7: invokevirtual #43                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        10: return
      LineNumberTable:
        line 10: 0
        line 11: 3
        line 12: 10
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            3       8     0     b   Ljava/lang/String;

  public static int main1(java.util.Date);
    descriptor: (Ljava/util/Date;)I
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=1, locals=1, args_size=1
         0: iconst_0
         1: ireturn
      LineNumberTable:
        line 15: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       2     0  date   Ljava/util/Date;
}
SourceFile: "TestConstantPool.java"
*/
/**
 * 1.对于某个类或接口而言，其自身、父类和继承或实现的接口的信息会被直接组装成CONSTANT_Class_info常量池项放置到常量池中； 
 * 2. 类中或接口中使用到了其他的类，只有在类中实际使用到了该类时，该类的信息才会在常量池中有对应的CONSTANT_Class_info常量池项；(ps:如果只是声明了其它类型则没有,但是如果方法用户了其它类,则直接放到常量池中)
 * 3. 类中或接口中仅仅定义某种类型的变量，JDK只会将变量的类型描述信息以UTF-8字符串组成CONSTANT_Utf8_info常量池项放置到常量池中，上面在类中的private Date date;JDK编译器只会将表示date的数据类型的“Ljava/util/Date”字符串放置到常量池中。
 */
