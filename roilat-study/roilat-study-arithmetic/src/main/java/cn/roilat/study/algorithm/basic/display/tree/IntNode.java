package cn.roilat.study.algorithm.basic.display.tree;

public class IntNode extends Node {
    protected Integer val;

    public IntNode(String name) {
        super(name);
    }

    public IntNode(Integer[] heap) {
        super(null);
        this.buildTree(heap);
    }

    private IntNode(Integer val) {
        super(null);
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public void buildTree(Integer[] heap) {
        if (heap != null && heap.length > 0) {
            doBuildTree(heap, 0);
        }
    }

    private void doBuildTree(Integer[] heap, int i) {
        this.val = heap[i];
        IntNode node;
        int temp = 0;
        if ((temp = i * 2 + 1) < heap.length) {
            node = new IntNode(heap[temp]);
            this.addChild(node);
            node.doBuildTree(heap, temp);
        }
        if ((temp = i * 2 + 2) < heap.length) {
            node = new IntNode(heap[temp]);
            this.addChild(node);
            node.doBuildTree(heap, temp);
        }
    }

    public void addChild(Node n) {
        super.addChild(n);
    }

}
