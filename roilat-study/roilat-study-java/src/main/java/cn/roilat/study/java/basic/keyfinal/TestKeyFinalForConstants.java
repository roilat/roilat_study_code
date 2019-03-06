package cn.roilat.study.java.basic.keyfinal;

/**
 * final修饰的常量必须是static的且必须初始化
 * 常量可以是基本数据类型，也可以是类的对象，在静态初始化代码中会构造对象（new）然后赋值。和String及基本数据类型不同，它们是直接存放到常量池中的。
 * 
 * @author roilat-J
 * @version $Id: TestKeyFinalForConstants.java, v 0.1 2019年2月12日 上午11:50:32 roilat-J Exp $
 */
public class TestKeyFinalForConstants {
    public static final TestKeyFinalForConstants FINAL_FOR_CONSTANTS = new TestKeyFinalForConstants();
    public static final String key = "";
    static {
        //System.out.println(OTHER_CLASS);
        //System.out.println(key1);
        key1 = "123";
        OTHER_CLASS = new OtherClass();
    }
    public static String key1;
    public static final OtherClass OTHER_CLASS ;
    public static void main(String[] args) {
        System.out.println(TestKeyFinalForConstants.key1);
    }
}
class OtherClass{
    
}