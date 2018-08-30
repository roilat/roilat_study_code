package cn.roilat.study.algorithm.basic.display.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class Treenode extends JFrame implements TreeSelectionListener {

    /**  */
    private static final long serialVersionUID = -2338494605517891600L;
    JLabel                    jl;

    public Treenode() {
        super("树形结构");

        //创建根节点和子节点
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("文本编辑器");

        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode("文件");
        DefaultMutableTreeNode node2 = new DefaultMutableTreeNode("编辑");

        //利用根节点创建treemodel
        DefaultTreeModel treemodel = new DefaultTreeModel(root);
        //插入子节点
        treemodel.insertNodeInto(node1, root, root.getChildCount());
        treemodel.insertNodeInto(node2, root, root.getChildCount());

        //创建node1的子节点并插入
        DefaultMutableTreeNode leafnode = new DefaultMutableTreeNode("打开");
        treemodel.insertNodeInto(leafnode, node1, node1.getChildCount());

        leafnode = new DefaultMutableTreeNode("保存");
        treemodel.insertNodeInto(leafnode, node1, node1.getChildCount());

        leafnode = new DefaultMutableTreeNode("另存为");
        treemodel.insertNodeInto(leafnode, node1, node1.getChildCount());

        leafnode = new DefaultMutableTreeNode("关闭");
        treemodel.insertNodeInto(leafnode, node1, node1.getChildCount());

        //创建node2的子节点并插入
        leafnode = new DefaultMutableTreeNode("剪切");
        treemodel.insertNodeInto(leafnode, node2, node2.getChildCount());

        leafnode = new DefaultMutableTreeNode("复制");
        treemodel.insertNodeInto(leafnode, node2, node2.getChildCount());

        leafnode = new DefaultMutableTreeNode("粘贴");
        treemodel.insertNodeInto(leafnode, node2, node2.getChildCount());

        //创建树对象
        JTree tree = new JTree(treemodel);

        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(this);
        tree.setRowHeight(20);

        //创建节点绘制对象
        DefaultTreeCellRenderer cell = (DefaultTreeCellRenderer) tree.getCellRenderer();

        //设置字体
        cell.setFont(new Font("Serif", Font.PLAIN, 14));
        cell.setBackgroundNonSelectionColor(Color.white);
        cell.setBackgroundSelectionColor(Color.LIGHT_GRAY);
        cell.setForeground(Color.red);

        cell.setIcon(new ImageIcon("/image/folder.jpg"));

        //设置选中和不选中时文字的变化颜色
        cell.setTextNonSelectionColor(Color.black);
        cell.setTextNonSelectionColor(Color.black);

        this.add(new JScrollPane(tree));

        jl = new JLabel("你当前选择的节点为：", JLabel.CENTER);
        jl.setFont(new Font("Serif", Font.PLAIN, 14));
        this.add(jl, BorderLayout.SOUTH);
        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Treenode();
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {

        JTree tree = (JTree) e.getSource();

        //获取当前选中的节点
        DefaultMutableTreeNode selectnode = (DefaultMutableTreeNode) tree
            .getLastSelectedPathComponent();
        String nodename = selectnode.toString();

        jl.setText("您当前选择的节点为：" + nodename);

    }

}