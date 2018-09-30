package cn.roilat.study.java.designmode.staticproxy;

/**
 * 被代理类
 * 
 * @author roilat-J
 * @version $Id: Proxyee.java, v 0.1 2018年9月20日 下午4:39:17 roilat-J Exp $
 */
public class Proxyee implements Proxyable{

    @Override
    public void doSomeThing() {
        System.out.println("I'm doSomeThing...");
    }

}
