package com.brucepang.charpter1_linklist.level2.topic2_5;

import com.brucepang.charpter1_linklist.level2.ListNode;

/**
 * 删除给定的节点
 * @author BrucePang
 */
public class DeletePoint {
    public static void main(String[] args) {
        int[] arr = {1,5,3,4,5};
        ListNode listNode = initLinkedList(arr);

        int testMethod = 2;
        switch (testMethod){
            case 1:
                deleteTargetNode(listNode.next.next);
                System.out.println(toString(listNode));;
                break;
            case 2:
                System.out.println(toString(removeElements(listNode, 5)));;
                break;
        }
    }


    /**
     * 删除给定的结点(非最后一个节点)
     *
     * @param node
     */
    public static void deleteTargetNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }


    /**
     * 删除特定值的结点
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0); // 虚拟头结点
        dummyHead.next = head;
        ListNode  cur = dummyHead; // 从虚拟头节点开始就能正常的将原来的头结点进行处理
        while (cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next; // 删除下一个结点
            } else {
                cur = cur.next; // 移动到下一个节点继续判断
            }
        }
        return dummyHead.next;
    }


    public static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null){
            sb.append(head.val).append("\t");
            head = head.next;
        }
        return sb.toString();
    }

    /**
     * 创建链表
     * @param arr 数组
     * @return
     */
    public static ListNode initLinkedList(int[] arr){
        if (arr == null || arr.length == 0){
            return new ListNode(0);
        }
        ListNode head = null, cur = null;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0){
                head = new ListNode(arr[i]);
                cur = head;
            } else {
                cur.next = new ListNode(arr[i]);
                cur = cur.next; // 指针后移到最新节点
            }
        }
        return head; // 返回头结点
    }
}
