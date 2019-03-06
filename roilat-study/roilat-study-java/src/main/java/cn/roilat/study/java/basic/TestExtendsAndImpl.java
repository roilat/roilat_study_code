package cn.roilat.study.java.basic;

public class TestExtendsAndImpl {
    public static void main(String[] args) {
        Parent1 p = new Child2();
        p.sayAage();//20
        Child2 c2 = (Child2) p;
        c2.sayAage();//20
    }

}

/**
 * B1实现I1的接口在parent类A1中已经实现，但是通过I1的methodA是无法找到实现类的。因为B1中不存在
 * 
 * @author roilat-J
 * @version $Id: TestExtendsAndImpl.java, v 0.1 2018年12月12日 下午7:25:31 roilat-J Exp $
 */
interface I1{
    void methodA();
    void methodB();
    default void methodC() {
        System.out.println("aaa");
    }
}
class A1{
    public void methodA() {
        System.out.println("methodA");
    }
}
class B1 extends A1 implements I1{
    public void methodB() {
        System.out.println("");
    }
}

/**
 * 所以无论怎么样（和引用无关），只关注实例的类型，以及真实方法的上下文范围。
 * 如子类中的方法，可以使用super和this两种方法读取到不同的数据，但是父类的方法是读取不到子类的数据的。
 * 但是父类调用自己的类时，会使用子类的重写的方法，与读取属性不同（属性不能取子类的，而方法可以）
 */

class Parent1{
    protected int age = 20;
    public void sayAage() {
        System.out.println(this.age);//无论是否添加this都会输出20
        print();
    }
    public void print() {
        System.out.println("Parent1 print");
    }
}
class Child2 extends Parent1{
    protected int age = 30;
   /* public void sayAage() {
        System.out.println(super.age);//如果这里覆盖了父类的方法，则这里使用本地变量
    }*/
    public void print() {
        System.out.println("Child2 print");
    }
}