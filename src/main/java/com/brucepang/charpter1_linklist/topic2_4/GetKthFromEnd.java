package com.brucepang.charpter1_linklist.topic2_4;

import com.brucepang.charpter1_linklist.level2.ListNode;

/**
 * 寻找倒数第K个结点开头的链表
 * 要求：
 * 输入一个链表，输出该链表中倒数第k个节点。本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 示例
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 *
 * @author BrucePang
 */
public class GetKthFromEnd {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode nodeA = initListNode(arr);

        // 寻找倒数第K个结点开头的链表
        ListNode kthFromEnd = getKthFromEnd(nodeA, 2);
        System.out.println(toString(kthFromEnd));
    }

    /**
     * 寻找倒数第K个结点开头的链表
     *
     * @param head 链表
     * @param k    倒数第K个位置处
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head; // 快慢指针
        // 首先slow指向head， 将fast 向后遍历到第 k+1 个节点【注意：不是倒数第k +1， 现在让两个结点之间相差 k 个结点】
        // 注意，fast结点不能空，且 k > 0
        while (fast != null && k > 0) { // 将fast指向第k+1结点的位置
            fast = fast.next;
            k--;
        }

        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;


    }

    public static String toString(ListNode head){
        StringBuilder sb = new StringBuilder();
        while (head != null){
            sb.append(head.val).append("\t");
            head = head.next;
        }
        return sb.toString();
    }

    /**
     * 根据数组创建链表
     *
     * @param arr 数组
     * @return
     */
    public static ListNode initListNode(int[] arr) {
        if (arr == null || arr.length == 0) { // 非空校验
            return null;
        }

        ListNode head = null, cur = null;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                head = new ListNode(arr[i]);
                cur = head;
            } else {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }
        return head;
    }
}
