package com.brucepang.charpter1_linklist.level1;



/**
 * 构造单向链表，使用静态内部类定表示结点，实现增加和删除元素的功能
 * @author BrucePang
 */
public class BasicLinkList02 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        // Node head = new Node(arr[0]); // 创建头节点
        // Node newNode = new Node(99); // 创建待插入节点
        // head = insertNode(head, newNode, 1); // 将待插入节点插入到头节点后面
        Node head = creatLinkedList(arr);
        Node newNode = new Node(7);
        head = insertNode(head, newNode, 6); // 模拟下标越界异常
        System.out.println(head);
    }

    /**
     * 链表插入
     * @param head       链表头节点
     * @param newNode    待插入节点
     * @param position   待插入位置，从1开始
     * @return 插入后得到的链表头节点
     */
    public static Node insertNode(Node head, Node newNode, int position) {
        if (head == null) { // 如果头节点为空,则直接将newNode节点赋值给head,表示newNode节点是新的头节点
            head = newNode;
            return head;
        }

        // 已经存放的元素个数
        int size = getLinkedLength(head);

        // 判断待插入位置是否越界
        if (position < 1 || position > size + 1) {
            System.out.println("插入位置越界");
            return head;
        }

        // 1. 链表头部插入
        if (position == 1) {
            newNode.next = head; // head指向的是第一个节点位置的引用，所以这里将head赋值给newNode的next属性,表示newNode节点的下一个节点是原来head指向的节点
            head = newNode; // 将newNode赋值给head,表示newNode节点是新的头节点
            return head;
        }

        Node pNode = head;
        int count = 1;
        //这里position被上面的size被限制住了，不用考虑pNode=null
        while (count < position - 1) { // 找到要插入现在位置的前一个节点,方便操作
            pNode = pNode.next;
            count++;
        }
        newNode.next = pNode.next; // pNode.next上一个节点的next属性的值,实际上就是要插入该位置之前的老节点的引用,将老引用赋值给新节点的next,代表原来的位置已经被新节点替代了
        pNode.next = newNode; // 将老节点的next属性赋值为新节点的引用,表示老节点的下一个节点是新节点
        return head;

    }

    /**
     * 获取链表长度
     * @param head 链表头节点
     * @return
     */
    private static int getLinkedLength(Node head) {
        int length = 0;
        Node node = head;
        while (node != null) { //
             // 如果head的next属性为null,则表示当前节点是最后一个节点
                length++;
                node = node.next;
        }
        return length;
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
                cur.next = new Node(arr[i]); // 此处引用还是上一轮的节点: 新一轮的for循环开始时,首先将上一轮的Node节点的next指向新的Node节点
                cur = cur.next; // 然后将cur节点引用更新为当前for循环的Node节点
            }

        }
        return head; // 返回头节点,debug时可以通过头节点去查看整个链表的结构
    }




    static class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
}
