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
                System.out.println(toString(reverseBetweenByDummyNode(listNode, 2,4)));
                break;
        }
    }

    /**
     * 方式一: 根据虚拟头结点,利用头插法完成给定区间的链表反转
     * @param head 链表
     * @param left 左区间
     * @param right 右区间
     * @return
     */
    public static ListNode reverseBetweenByDummyNode(ListNode head, int left, int right){
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // 1.首先找出左区间上一个位置的节点,用于到时候衔接反转后的链表
        ListNode pre = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // 2.找到右区间的节点
        ListNode rightNode = pre; // 接着从pre开始找, 从当前往后找 (right - left + 1)次 可以找到要被反转的右节点
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        // 3.保存右区间之后的结点,防止丢失
        ListNode success = rightNode.next;
        ListNode reverseNode = pre.next; // 要被反转的链表的结点
        // 4.释放右区间.next,形成独立的一个链表
        rightNode.next = null;
        // 5.反转"区间"摘下来的链表
        reverseListNode(reverseNode);
        // 5.将反转后的链表组装回去
        pre.next = rightNode; // 反转后原来的reverseNode节点想应的减少了,被反转的结点附加到了rightNode
        reverseNode.next = success;
        return dummyHead.next;

    }

    /**
     * 直接反转链表
     * @param head
     * @return
     */
    public static ListNode reverseListNode(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            // 1.保存当前节点的下一个节点,以免反转过程中丢失
            ListNode next = cur.next;
            // 2.当前节点的next指向pre,实现链表反转指向
            cur.next = pre;
            // 3.更新最新的pre
            pre = cur;
            // 4.cur移动到下一个
            cur = next;
        }
        return pre; // 反转单链表的本质就是cur的最后一个结点变成头结点
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
