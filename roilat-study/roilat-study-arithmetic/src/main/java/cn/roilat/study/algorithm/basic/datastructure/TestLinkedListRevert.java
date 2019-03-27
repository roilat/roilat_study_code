package cn.roilat.study.algorithm.basic.datastructure;

import java.util.Random;

public class TestLinkedListRevert {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.init(10);
        linkedList.print(true);
        linkedList.print(false);
        linkedList.reversal(false);
        linkedList.print(false);
        linkedList.reversal(true);
        linkedList.print(true);
    }

}

class LinkedList {
    Node head;

    public LinkedList init(int len) {
        LinkedList.Node curNode = head = new Node();
        Random random = new Random();
        curNode.data = random.nextInt(100);
        while (--len > 0) {
            curNode = curNode.next = new Node();
            curNode.data = random.nextInt(100);

        }
        return this;
    }

    public void reversal(boolean useRecursion) {
        if (useRecursion) {
            doReversalWithRecursion(this.head);
        } else {
            doReversal();
        }
    }

    private void doReversal() {
        if (head == null) {
            return;
        }
        Node next2Node = head.next;
        head.next = null;
        for (; next2Node != null;) {
            Node next = next2Node;
            next2Node = next2Node.next;//下下个节点提前保存起来
            next.next = head;
            head = next;
        }
    }

    private Node doReversalWithRecursion(Node node) {
        if (node.next != null) {
            Node next = doReversalWithRecursion(node.next);
            node.next = null;
            next.next = node;
            return node;
        } else {
            head = node;
            return node;
        }
    }

    public void print(boolean useRecursion) {
        if (useRecursion) {
            printWithRecursion(head);
        } else {
            print();
        }
        System.out.println();
    }

    private void printWithRecursion(Node node) {
        if (node != null) {
            System.out.print(node.data + "  ");
            printWithRecursion(node.next);
        }
    }

    private void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + "  ");
            node = node.next;
        }
        System.out.println();
    }

    public String toString() {
        return head.toString();
    }

    class Node {
        int  data;
        Node next;

        public String toString() {
            return data + " " + (next != null ? next.toString() : "");
        }
    }
}