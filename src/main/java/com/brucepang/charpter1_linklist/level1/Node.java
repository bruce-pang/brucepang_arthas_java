package com.brucepang.charpter1_linklist.level1;

/**
 * 用"面相对象"的思想来定义链表的节点,这里的节点是单向列表的节点
 * @author BrucePang
 */
public class Node {
    private int val; // 节点的值
    private Node next; // 下一个节点的引用

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
