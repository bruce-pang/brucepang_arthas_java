package com.brucepang.charpter1_linklist.level2.topic2_5;

import com.brucepang.charpter1_linklist.level2.ListNode;

/**
 * 删除重复元素
 *
 * @author BrucePang
 */
public class DeleteDuplatePoint {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 3, 4, 5, 5, 5};
        ListNode listNode = initLinkedList(arr);

        int testMethod = 2;
        switch (testMethod) {
            case 1:
                System.out.println(toString(deleteDuplicate(listNode)));
                break;
            case 2:
                System.out.println(toString(deleteDuplicates(listNode)));
                break;
        }
    }

    /**
     * 重复元素都不要
     * 当一个都不要时，链表只要直接对cur.next 以及 cur.next.next 两个node进行比较就行了，这里要注意两个node可能为空，稍加判断就行了。
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) { // 非空校验
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 升序链表的重复元素只保留一个
     * LeetCode83 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素只出现一次 。返回同样按升序排列的结果链表。
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicate(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }

        }
        return head;
    }

    public static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append("\t");
            head = head.next;
        }
        return sb.toString();
    }

    /**
     * 获取链表长度
     *
     * @param head
     * @return
     */
    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
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

