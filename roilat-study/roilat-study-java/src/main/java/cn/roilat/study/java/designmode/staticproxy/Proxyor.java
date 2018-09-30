package cn.roilat.study.java.designmode.staticproxy;

public class Proxyor implements Proxyable {
    
    private Proxyable proxyee;
    

    public Proxyor(Proxyable proxyee) {
        super();
        this.proxyee = proxyee;
    }


    @Override
    public void doSomeThing() {
        System.out.println("before real doSomeThing");
        proxyee.doSomeThing();
        System.out.println("after real doSomeThing");
    }

}
