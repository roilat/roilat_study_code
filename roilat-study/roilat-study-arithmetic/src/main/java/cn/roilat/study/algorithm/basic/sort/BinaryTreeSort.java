package cn.roilat.study.algorithm.basic.sort;

/**
 * 二叉树排序 
 * @author roilat-J
 * @version $Id: BinaryTreeSort.java, v 0.1 2018年6月29日 下午4:23:54 roilat-J Exp $
 */
public class BinaryTreeSort extends BaseSort {

    @Override
    public void doSort(Integer[] a, int pos, int len, int start) {
        System.out.println("start to do BinaryTreeSort...");

        int end = pos + len - 1;
        assert pos <= start && start <= end;

        //build root node
        TreeNode root = new TreeNode();
        root.currrentVal = a[start];
        root.index = start;
        buildTree(a, root, start + 1, end);
        Integer s = new Integer(0);
        getResult(a, root, s);
        System.out.println(s);
        System.out.println("end to do BinaryTreeSort...");

    }

    private void buildTree(Integer[] a, TreeNode root, int start, int end) {
        //root.currrentVal = a[start];
        for (int i = start; i <= end; i++) {
            addNode(root, a[i], i);
        }
    }

    private void addNode(TreeNode node, Integer val, int index) {
        if (node == null) {
            node = new TreeNode();
            node.currrentVal = val;
            node.index = index;
            return;
        }
        if (node.currrentVal > val) {//小于当前节点,为左节点
            if (node.left == null) {
                node.left = new TreeNode();
                node.left.currrentVal = val;
                node.left.index = index;
                return;
            } else {
                addNode(node.left, val, index);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode();
                node.right.currrentVal = val;
                node.right.index = index;
                return;
            } else {
                addNode(node.right, val, index);
            }
        }
    }

    private int getResult(Integer[] a, TreeNode node, Integer index) {
        if (node == null) {
            return index;//空节点返回原来的数组下标
        }
        index = getResult(a, node.left, index);//取返回后的下标，可能已经移动
        a[index++] = node.currrentVal;//数组下标+1
        index = getResult(a, node.right, index);
        return index;
    }

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        Integer  currrentVal;
        int      index;
    }
}
