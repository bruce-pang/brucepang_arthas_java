package com.brucepang.charpter1_linklist.level1;

/**
 *  一个简单的链表实例，用于演示JVM怎么构造链表的(基于BasicLink0使用for循环改造单链表)
 *  BrucePang
 */
public class BasicLink2 {
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
        Node cur = null; // 当前节点
        for (int i = 0; i < arr.length; i++) { // 每次cur.next能够指向新的节点,发生的时机实际上是下一次for循环,若没有下一次for循环,则cur.next指向null
            if (i == 0) { // 第一次循环时，创建头节点
                cur = new Node(arr[i]);
                head = cur; // 头节点赋值,有且只赋值一次
            } else {
                cur.next = new Node(arr[i]); // 新一轮的for循环开始时,首先将上一轮的Node节点的next指向新的Node节点
                cur = cur.next; // 然后将cur节点更新当前for循环的Node节点
            }

        }
        return head; // 返回头节点,debug时可以通过头节点去查看整个链表的结构
    }

    static class Node{ // 链表的节点:由于重点是学习算法，所以这里不考虑使用面向对象的getter与setter，直接用有参构造器完成每个节点的初始化，简化代码，使用对象.属性的方式直接赋值
        int val; // 节点的值
        Node next; // 下一个节点的引用

        public Node(int val){
            this.val = val;
            next = null;
        }
    }
}
