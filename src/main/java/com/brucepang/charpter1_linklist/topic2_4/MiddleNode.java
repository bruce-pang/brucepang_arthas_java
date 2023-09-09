package com.brucepang.charpter1_linklist.topic2_4;

import com.brucepang.charpter1_linklist.level2.ListNode;

/**
 * 寻找链表中间结点: LeetCode876 给定一个头结点为 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
 *
 * @author BrucePang
 */
public class MiddleNode {
    public static void main(String[] args) {
int[] a = {1,2,3,4,6,5};
        ListNode nodeA = initLinkedList(a);
        ListNode middle = middleNode(nodeA);
        System.out.println(middle.val);
    }

    /**
     * LeetCode876 给定一个头结点为 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
       while( fast != null && fast.next != null){ // 当快指针走到尾部时，慢指针刚好走到中间
           slow = slow.next; // 慢指针走一步
           fast = fast.next.next; // 快指针走两步
       }
         return slow;
    }


    private static ListNode initLinkedList(int[] array) {
        ListNode head = null, cur = null;

        for (int i = 0; i < array.length; i++) {
            ListNode newNode = new ListNode(array[i]);
            newNode.next = null;
            if (i == 0) {
                head = newNode;
                cur = head;
            } else {
                cur.next = newNode;
                cur = newNode;
            }
        }
        return head;
    }

}
