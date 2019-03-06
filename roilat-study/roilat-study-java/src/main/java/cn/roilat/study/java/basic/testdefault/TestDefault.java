package cn.roilat.study.java.basic.testdefault;

/**
 * 接口中，可以定义default方法，实现类可以直接使用：${interfaceName}.super.${defaultMethodName}
 * 
 * @author roilat-J
 * @version $Id: TestSuper.java, v 0.1 2019年2月25日 上午11:50:18 roilat-J Exp $
 */
public class TestDefault {

    public static void main(String[] args) {
        CA ca = new CC();
        ca.say();//this CB
    }

}
interface IA{
    default void say() {
    }
}
class CA implements IA{

    @Override
    public void say() {
        System.out.println();
        IA.super.say();
        System.out.println("this CA");
    }
    
}
class CB extends CA{

    @Override
    public void say() {
        //IA.super.say();
        System.out.println("this CB");
    }
    
}
class CC extends CB{
    @Override
    public void say() {
        CC.this.doSay();
    }
    private void doSay() {
        System.out.println("this CC");
    }
}