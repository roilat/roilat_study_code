package cn.roilat.study.java.designmode.staticproxy;

public class TestProxy {

    public static void main(String[] args) {
        Proxyable proxyee = new Proxyee();
        Proxyable proxyor = new Proxyor(proxyee);
        proxyor.doSomeThing();
    }

}
