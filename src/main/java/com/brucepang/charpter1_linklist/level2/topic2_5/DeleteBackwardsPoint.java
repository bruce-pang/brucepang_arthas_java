package com.brucepang.charpter1_linklist.level2.topic2_5;

import com.brucepang.charpter1_linklist.level2.ListNode;

/**
 * 几个与倒数有关的问题
 *
 * @author BrucePang
 */
public class DeleteBackwardsPoint {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = initLinkedList(arr);

        int testMethod = 2;
        switch (testMethod) {
            case 1:
                System.out.println(toString(removeNthFromEnd(listNode, 5)));
                break;
            case 2:
                System.out.println(toString(removeNthFromEndByDoublePoint(listNode,5)));
        }
    }

    /**
     * 删除倒数第n个结点
     * 方法二： 双指针
     * 我们定义first和second两个指针，first先走N步，然后second再开始走，当first走到队尾的时候，second就是我们要的节点。代码如下：
     *
     * @param head 链表
     * @param n    要被删除的倒数第n个元素的位置
     * @return
     */
    public static ListNode removeNthFromEndByDoublePoint(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0); // 考虑到头节点也有被删除的可能，所以需要一个虚拟头节点，方便操作
        dummyHead.next  = head;
        ListNode first = head; // 需要first从head先走N步
        ListNode second = dummyHead; // 然后再让second从dummyHead向后移动，first也移动，当first走到队尾时，second.next就指向要被删除的倒数第n个结点
        // 1.first先走N步
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        //
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummyHead.next;

    }

    /**
     * 删除倒数第n个结点
     * 方法一:
     * 1.获取链表长度l
     * 2. 遍历链表,当 遍历到 l - n +1 个结点时,该结点就是要被删除的节点
     *
     * @param head 链表
     * @param n    要被删除的倒数第n个元素的位置
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0); // 考虑到头节点也有被删除的可能，所以需要一个虚拟头节点，方便操作
        dummyHead.next = head;

        ListNode cur = dummyHead;

        // 1.获取head整个链表的长度
        int l = getLength(head);

        // 2.遍历链表，遍历到 l - n + 1 个结点时，该节点就是要被删除的结点
        for (int i = 1; i < l - n + 1; i++){ // 假设要被删除的是头节点，从dummyHead开始，下标就是为1，以此类推
            cur = cur.next; // 拿到要被删除结点的上一个结点
        }
        cur.next = cur.next.next;
        return dummyHead.next;
    }



    /**
     * 打印链表
     *
     * @param head 链表头结结点
     * @return
     */
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
        int i = 0;
        while (head != null) {
            head = head.next;
            i++;
        }
        return i;
    }

    /**
     * 根据数组创建链表
     *
     * @param arr 数组
     * @return
     */
    public static ListNode initLinkedList(int[] arr) {

        ListNode head = null, cur = null;
        for (int i = 0; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            if (i == 0) {
                head = newNode;
                cur = newNode;
            } else {
                cur.next = newNode;
                cur = cur.next;
            }
        }
        return head;

    }
}
