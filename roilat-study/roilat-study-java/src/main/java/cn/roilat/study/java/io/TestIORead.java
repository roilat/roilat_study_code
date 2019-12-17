package cn.roilat.study.java.io;

public class TestIORead {

    public static void main(String[] args) {

    }

}
interface A{
    public String s = "aaa";//

}
class B implements A{
    {
        //s = "bbb";s应该是final的
    }
    public void hello() {
        System.out.println(s);
    }
}