package cn.roilat.study.java.basic.extend;

/**
 * 类和接口都不能循环继承
 * 
 * @author roilat-J
 * @version $Id: TestExtends.java, v 0.1 2019年1月31日 下午6:36:26 roilat-J Exp $
 */
public class TestExtends {
    public static void main(String[] args) {
    }
}
class A/* extends C*/{}
class B extends A{}
class C extends B{}
interface D/* extends F*/{}
interface E extends D{}
interface F extends E{}