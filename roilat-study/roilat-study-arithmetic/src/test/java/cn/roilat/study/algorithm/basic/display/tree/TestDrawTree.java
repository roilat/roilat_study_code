package cn.roilat.study.algorithm.basic.display.tree;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/** 
 * @author John 
 * 
 */
public class TestDrawTree/* extends JFrame*/ {

    public static void main(String[] args) {
        System.out.println(Math.log(8) / Math.log(2));
        test2();
    }

    public static void test2() {
        Integer[] ints = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        TreePanel.printHeap(ints);
    }

    public static void test1() {
        /* 
         * 初始化树的数据 
         */
        Node n = new Node("root");
        Node a1 = new Node("a1");
        Node a2 = new Node("a2");

        Node b1 = new Node("b1");
        Node b2 = new Node("b2");
        a1.addChild(b1);
        a1.addChild(b2);

        Node b3 = new Node("b3");
        Node b4 = new Node("b4");
        a2.addChild(b3);
        a2.addChild(b4);

        Node d1 = new Node("d1");
        Node d2 = new Node("d2");

        Node b5 = new Node("b3");
        b5.addChild(d1);
        b5.addChild(d2);

        Node n3 = new Node("b4");
        n3.addChild(new Node("c1"));
        n3.addChild(new Node("c2"));

        Node a3 = new Node("a3");
        a3.addChild(b5);
        a3.addChild(new Node("b2"));
        a3.addChild(new Node("b3"));
        a3.addChild(n3);

        n.addChild(a1);
        n.addChild(a2);
        n.addChild(a3);
        //n.printAllNode(n);    //输出树  

        /* 
         * 创建一个用于绘制树的面板并将树传入,使用相对对齐方式 
         */
        TreePanel panel1 = new TreePanel(TreePanel.CHILD_ALIGN_RELATIVE);
        panel1.setTree(n);

        /* 
         * 创建一个用于绘制树的面板并将树传入,使用绝对对齐方式 
         */
        TreePanel panel2 = new TreePanel(TreePanel.CHILD_ALIGN_ABSOLUTE);
        panel2.setTree(n);
        panel2.setBackground(Color.BLACK);
        panel2.setGridColor(Color.WHITE);
        panel2.setLinkLineColor(Color.WHITE);
        panel2.setStringColor(Color.BLACK);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(2, 1));
        contentPane.add(panel1);
        contentPane.add(panel2);

        JFrame frame = new JFrame();
        frame.add(contentPane, BorderLayout.CENTER);

        frame.setSize(1200, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
