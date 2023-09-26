package com.brucepang.charpter2_reverselist.level2.topic2_1;

import com.brucepang.charpter2_reverselist.ListNode;

/**
 * 链表反转的扩展问题
 * @author BrucePang
 */
public class ReverseListBetween {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode listNode = initListNode(arr);

        int testMethod = 1;
        switch (testMethod){
            case 1:
                System.out.println(toString(listNode));
                break;
        }
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
     * 获取链表长度
     * @param head 链表
     * @return 链表长度
     */
    public static int getLength(ListNode head){
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }

    /**
     * 根据数组创建链表
     * @param arr 数组
     * @return 链表
     */
    public static ListNode initListNode(int[] arr){
        if (arr == null || arr.length == 0){
            return null;
        }
        ListNode head = null;
        ListNode cur = null;
        for (int i = 0; i < arr.length; i++) {
            ListNode listNode = new ListNode(arr[i]);
            if (i == 0){
                head = listNode;
                cur = listNode;
            } else {
                cur.next = listNode;
                cur = listNode;
            }
        }
        return head;
    }
}
