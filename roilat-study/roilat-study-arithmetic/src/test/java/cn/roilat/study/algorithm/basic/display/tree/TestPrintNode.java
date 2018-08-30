package cn.roilat.study.algorithm.basic.display.tree;

/** 
 * @author John 
 * 
 */
public class TestPrintNode {

    public static void main(String[] args) {
        test2();
    }

    public static void test1() {
        Node n = new Node("root");

        n.addChild(new Node("a1"));
        n.addChild(new Node("a2"));

        Node n2 = new Node("a3");
        n2.addChild(new Node("b1"));
        n2.addChild(new Node("b2"));
        n2.addChild(new Node("b3"));
        Node n3 = new Node("b4");
        n2.addChild(n3);
        n3.addChild(new Node("c1"));
        n3.addChild(new Node("c2"));
        n.addChild(n2);

        n.printAllNode(n); //输出树  
    }

    public static void test2() {
        Node n = new Node("a0");

        Node n1 = new Node("n1");
        Node n2 = new Node("n2");
        Node n3 = new Node("n3");
        Node n4 = new Node("n4");
        n1.addChild(n2);
        n2.addChild(n3);
        n3.addChild(n4);
        n.addChild(n1);

        Node a1 = new Node("a1");
        Node a2 = new Node("a2");
        Node a3 = new Node("a3");
        Node a4 = new Node("a4");
        a3.addChild(a4);
        n.addChild(a1);
        a1.addChild(a2);
        a2.addChild(a3);

        n.printAllNode(n); //输出树  
    }
}