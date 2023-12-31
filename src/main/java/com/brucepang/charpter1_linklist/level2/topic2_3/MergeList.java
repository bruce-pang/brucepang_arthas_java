package com.brucepang.charpter1_linklist.level2.topic2_3;

import com.brucepang.charpter1_linklist.level2.ListNode;

/**
 * 合并有序链表
 *
 * @author BrucePang
 */
public class MergeList {

    public static void main(String[] args) {
        int[] a = {1, 2, 6, 8, 12};
        ListNode nodeA = initLinkedList(a);

        int[] b = {2, 5, 9, 13, 15, 17, 19};
        ListNode nodeB = initLinkedList(b);

        int[] c = {3, 6, 10, 14};
        ListNode nodeC = initLinkedList(c);

        ListNode[] array = {nodeA, nodeB, nodeC};

        int testMethod = 4;
        ListNode d = null;
        switch (testMethod) {
            case 1: // 方法1：最直接的方法
                d = mergeTwoListsOrigin(nodeA, nodeB);
                System.out.println(toString(d));
                break;
            case 2: // 方法1：最直接的方法
                d = mergeTwoListsTwo(nodeA, nodeB);
                System.out.println(toString(d));
                break;
            case 3: // 合并K个有序链表
                d = mergeKLists(array);
                System.out.println(toString(d));
                break;
            case 4: // 合并list2到list1的a到b位置
                d = mergeInBetween(nodeA, 2, 60, nodeB);
                System.out.println(toString(d));
                break;
        }
    }

    /**
     * 打印链表
     *
     * @param d listNode
     * @return
     */

    private static String toString(ListNode d) {
        StringBuilder sb = new StringBuilder();
        while (d != null) {
            sb.append(d.val).append("\t");
            d = d.next;  // 链表后移
        }
        return sb.toString();
    }

    /**
     * 合并K个有序链表
     * @param lists  有序链表数组
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (ListNode list : lists) {
            res = mergeTwoListsTwo(res, list);
        }
        return res;
    }

    /**
     * 合并两个有序链表(优化原始版),使用一个while循环,并且优化if else的判断
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoListsTwo(ListNode list1, ListNode list2) {
        ListNode newNode = new ListNode(0); // 用于存储合并后的链表,当前的这个newHead现在存储内存地址不是我们需要的,newHead.next开始才是我们需要的
        ListNode res = newNode; // 由于上面的newHead会不断的往后移动，所以需要一个res来记录最开始的位置
        while (list1 != null && list2 != null) { // 两个链表都不为null
            if (list1.val <= list2.val) { // 如果当前list1节点的val < 当前list2节点的val
                newNode.next = list1; // 将list1节点接到newHead后面
                list1 = list1.next; // list1节点后移
            } else { // 如果当前list1节点的val > 当前list2节点的val
                newNode.next = list2; // 将list2节点接到newHead后面
                list2 = list2.next; // list2节点后移
            }
            newNode = newNode.next; // 老的newHead节点后移
        }

        // 最多只有一个还未被合并完，直接接上去就行了,这是链表合并比数组合并方便的地方
        newNode.next = list1 == null ? list2 : list1;
        return res.next; // 返回合并后的链表部分
    }


    /**
     * 合并list2到list1的a到b位置
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     */
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2){
        ListNode pre = list1,  // pre用于帮助找到list1的a位置
                post1 = list1, // post1用于帮助找到list1的b位置
                post2 = list2; // post2用于帮助找到list2的最后一个节点的位置
        int i = 0, j = 0; // i 用于跟踪 pre 的位置。j 用于跟踪 post1 的位置, 必须从0开始，否则会造成b位置的元素不被截取掉。
        while(pre != null && post1 != null && j < b){
          if(i < a - 1){ // 找到a前一个节点的位置
                pre = pre.next;
                i++;
          }
          if (j != b){ // 找到b的位置
                post1 = post1.next;
                j++;
          }
        }

        while (post2.next != null){ // 找到list2的最后一个节点
            post2 = post2.next;
        }

        // 将a节点前一个节点的next指向list2的头节点，将list2的最后一个节点的next指向b节点的下一个节点
        pre.next = list2;
        post2.next = post1 == null ? null : post1.next; // 谨防空指针异常

        return list1;
    }

/*    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode pre1 = list1, post1 = list1, post2 = list2;
        int i = 0, j = 0;
        while(pre1 != null && post1 != null && j < b){
            if(i != a - 1){
                pre1 = pre1.next;
                i++;
            }
            if(j != b){
                post1 = post1.next;
                j++;
            }
        }
        post1 = post1.next;
        //寻找list2的尾节点
        while(post2.next != null){
            post2 = post2.next;
        }
        //链1尾接链2头，链2尾接链1后半部分的头
        pre1.next = list2;
        post2.next = post1;
        return list1;
    }*/


    /**
     * 合并两个有序链表(原始版)
     *
     * @param list1 有序链表1
     * @param list2 有序链表2
     * @return
     */
    public static ListNode mergeTwoListsOrigin(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(0); // 用于存储合并后的链表,当前的这个newHead现在存储内存地址不是我们需要的,newHead.next开始才是我们需要的
        ListNode res = newHead; // 由于上面的newHead会不断的往后移动，所以需要一个res来记录最开始的位置
        while (list1 != null && list2 != null) { //  两个链表都不为null
            if (list1.val < list2.val) { // 如果当前list1节点的val < 当前list2节点的val
                newHead.next = list1; // 将list1节点接到newHead后面
                list1 = list1.next; // list1节点后移
            } else if (list1.val > list2.val) { // 如果当前list1节点的val > 当前list2节点的val
                newHead.next = list2; // 将list2节点接到newHead后面
                list2 = list2.next; // list2节点后移
            } else { // 当前的list1.val == 当前的list2.val
                newHead.next = list1; // 将list1节点接到newHead后面
                list1 = list1.next; // list1节点后移
                newHead = newHead.next; // newHead节点后移

                newHead.next = list2; // 将list2节点接到newHead后面
                list2 = list2.next; // list2节点后移
            }
            newHead = newHead.next; // 老的newHead节点后移

        }

        while (list1 != null && list2 == null) { // list1不为null，list2为null
            ;
            newHead.next = list1; // 将list1节点接到newHead后面
            list1 = list1.next; // list1节点后移
            newHead = newHead.next; // newHead节点后移
        }

        while (list1 == null && list2 != null) { // list1为null，list2不为null
            newHead.next = list2; // 将list1节点接到newHead后面
            list2 = list2.next; // list1节点后移
            newHead = newHead.next; // newHead节点后移
        }

        return res.next; // 返回合并后的链表部分
    }


    /**
     * 根据数组创建链表
     *
     * @param a 数组
     */
    public static ListNode initLinkedList(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        ListNode head = new ListNode(a[0]);
        ListNode current = head;
        for (int i = 1; i < a.length; i++) {
            ListNode node = new ListNode(a[i]); // 创建新的链表节点
            current.next = node; // 存放下一个链表节点的引用
            current = current.next; // 链表移动至最新位置
        }
        return head;
    }
}
