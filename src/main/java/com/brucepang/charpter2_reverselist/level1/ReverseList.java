package com.brucepang.charpter2_reverselist.level1;

import com.brucepang.charpter2_reverselist.ListNode;

import java.util.List;

/**
 * 反转链表
 * @author BrucePang
 */
public class ReverseList {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        ListNode listNode = initLinkedList(a);
        System.out.println(toString(reverseList(listNode)));
    }

    /**
     * 反转链表方式一： 基于虚拟头结点
     * @param head 链表
     * @return 反转后的链表
     */
    public static ListNode reverseList(ListNode head) {
        // 1.定义虚拟头结点
        ListNode ans = new ListNode(-1);
        ListNode cur = head;
        while (cur != null){
            // 2. 保存cur.next，谨防被覆盖
            ListNode next = cur.next;
            // 3. cur.next断开原来的链接，指向ans.next;
            cur.next = ans.next;
            // 4. ans.next更新引用为当前操作的结点（加入到虚拟头结点的链表）
            ans.next = cur;
            // 5.cur指向下一个要被操作的结点(开始时就保存了引用了，此时cur.next已经断开了与原来链表的联系)
            cur = next;
        }
        return ans.next;
    }

    /**
     * 获取链表长度
     * @param head 链表
     * @return 链表长度
     */
    public static int getLength(ListNode head){
        int i = 0;
        while (head != null){
            ++i;
            head = head.next;
        }
        return i;
    }

    /**
     * 打印链表
     * @param head 链表
     * @return
     */
    public static String toString(ListNode head){
        StringBuilder sb = new StringBuilder();
        while (head != null){
            sb.append(head.val).append("\t");
            head = head.next;
        }
        return sb.toString();
    }

    /**
     * 基于数组创建一个链表
     * @param arr 数组
     * @return 链表
     */
    public static ListNode initLinkedList(int[] arr){
        if (arr == null || arr.length == 0){
            return null;
        }

        ListNode head = null, cur = null;
    for (int i = 0; i < arr.length; i++) {
        ListNode newNode = new ListNode(arr[i]);
        if (i == 0){
            head = newNode;
            cur = newNode;
        } else {
            cur.next = newNode;
            cur = newNode;
        }
    }
    return head;
}
}
