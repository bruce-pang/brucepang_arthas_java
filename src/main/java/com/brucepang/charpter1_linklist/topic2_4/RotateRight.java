package com.brucepang.charpter1_linklist.topic2_4;

import com.brucepang.charpter1_linklist.level2.ListNode;

/**
 * leetcode61.旋转链表
 *
 * @author BrucePang
 */
public class RotateRight {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = initLinkedList(arr);
        /*int length = getLength(listNode);
        System.out.println(length);*/
        System.out.println(toString(rotateRight(listNode, 2)));
    }

    /**
     * 旋转链表:
     * 因为k有可能大于链表长度，所以首先获取一下链表长度len，如果然后k=k % len，如果k == 0，则不用旋转，直接返回头结点。否则：
     * 1.快指针先走k步。
     * 2.慢指针和快指针一起走。
     * 3.快指针走到链表尾部时，慢指针所在位置刚好是要断开的地方。把快指针指向的节点连到原链表头部，慢指针指向的节点断开和下一节点的联系。
     * 4.返回结束时慢指针指向节点的下一节点。
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) { // 直接返回
            return head;
        }

        // 统计链表长度len , 为了防止 k > len, 所以采用取模的方式进行计算
        int len = getLength(head);
        if (k % len == 0){ // 移动代码的位置刚好为数组的长度
            return head; // 直接返回
        }

        // 定义三个指针
        ListNode temp = head,  slow = head, fast = head;

        // 将fast偏移 k 个位置
        while (k % len > 0){
            fast = fast.next;
            k--;
        }

        // 同时移动slow, fast, 当fast.next = null 时, slow刚好位于要断开链表的位置
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        // 将fast.next指向原来的head,即temp保存的引用
        // 此时 slow.next正好是题解的 倒数第k个位置(注意,这里是以1为起始点计算的), 成为新的 head
        // slow.next指向的地址成为新head的地址后, 原来的slow.next需要把链断开,即指向null;
        // 返回新的head的地址;
        fast.next = temp;
        ListNode res = slow.next;
        slow.next = null;
        return res;
    }

    /**
     * 获取链表的长度
     *
     * @param head
     * @return
     */
    public static int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int i = 0;
        while (head != null) {
            i++;
            head = head.next;
        }
        return i;
    }

    /**
     * 格式化链表
     *
     * @param head
     * @return
     */
    public static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append("\t");
            head = head.next; // 链表结点往后移动一个
        }
        return sb.toString();
    }

    /**
     * 根据数组创建链表
     *
     * @param arr 数组
     * @return
     */
    public static ListNode initLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode head = null, cur = null;
        for (int i = 0; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            if (i == 0) {
                head = newNode;
                cur = head;
            } else {
                cur.next = newNode;
                cur = cur.next;
            }

        }

        return head;

    }
}
