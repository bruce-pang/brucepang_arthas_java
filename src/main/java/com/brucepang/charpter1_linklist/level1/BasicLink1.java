package com.brucepang.charpter1_linklist.level1;

/**
 *  一个简单的链表实例，基于BasicLink0的基础上，构建双链表
 *  BrucePang
 */
public class BasicLink1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        // 创建链表
        Node node = creatLinkedList(arr);
        System.out.println(node);
    }

    /**
     * 通过数组创建链表
     * @param arr 被传入的数组元素
     * @return
     */
    private static Node creatLinkedList(int[] arr) {
        // 创建表头
        Node head = null; // 由于链表是由头节点查找下一个节点的，所以这里单独定义一个头节点，以保证每次都能使用到头节点

        // 如果按照正序去构造节点,当前节点可能不知道下一个节点是null还是节点，所以这里使用倒序的方式去构造节点:
        // 先构造最后一个节点，然后再构造倒数第二个节点，以此类推
        // 此处是为了演示原理,所以先用硬编码,因为开发人员知道构造了一个多长的数组
        Node node5 = new Node(arr[5]);
        Node node4 = new Node(arr[4]);
        Node node3 = new Node(arr[3]);
        Node node2 = new Node(arr[2]);
        Node node1 = new Node(arr[1]);
        Node node0 = new Node(arr[0]);

        // 构造节点之间的关系
        head = node0;
        node0.pre = null; // 头节点的上一个节点是null
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null; // 最后一个节点的下一个节点是null

        // 构造所有节点的前驱节点
        node0.pre = null;
        node1.pre = node0;
        node2.pre = node1;
        node3.pre = node2;
        node4.pre = node3;
        node5.pre = node4;

        return head; // 返回头节点,debug时可以通过头节点去查看整个链表的结构
    }

    static class Node{ // 链表的节点:由于重点是学习算法，所以这里不考虑使用面向对象的getter与setter，直接用有参构造器完成每个节点的初始化，简化代码，使用对象.属性的方式直接赋值
        int val; // 节点的值
        Node next; // 下一个节点的引用

        Node pre; // 上一个节点的引用

        public Node(int val){
            this.val = val;
            next = null;
            pre = null;
        }
    }
}
