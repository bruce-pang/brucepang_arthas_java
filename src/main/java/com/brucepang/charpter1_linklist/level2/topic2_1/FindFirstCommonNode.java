package com.brucepang.charpter1_linklist.level2.topic2_1;

import com.brucepang.charpter1_linklist.level2.ListNode;

import java.util.*;

/**
 * 1 两个链表第一个公共子节点 - 使用Set集合解决
 * 解题思路:
 * 告诉你一个屡试不爽的方法：将常用数据结构和常用算法思想都想一遍，看看哪些能解决问题。
 * 常用的数据结构有数组、链表、队、栈、Hash、集合、树、堆。常用的算法思想有查找、排序、双指针、递归、迭代、分治、贪心、回溯和动态规划等等。
 * 首先想到的是蛮力法，类似于冒泡排序的方式，将第一个链表中的每一个结点依次与第二个链表的进行比较，当出现相等的结点指针时，即为相交结点。虽然简单，但是时间复杂度高，排除！
 * 再看Hash，先将第一个链表元素全部存到Map里，然后一边遍历第二个链表，一边检测当前元素是否在Hash中，如果两个链表有交点，那就找到了。OK，第二种方法出来了。既然Hash可以，那集合呢？和Hash一样用，也能解决，OK，第三种方法出来了。
 * 队列和栈呢？这里用队列没啥用，但用栈呢？现将两个链表分别压到两个栈里，之后一边同时出栈，一边比较出栈元素是否一致，如果一致则说明存在相交，然后继续找，最晚出栈的那组一致的节点就是要找的位置，于是就有了第四种方法。
 * @author BrucePang
 */
public class FindFirstCommonNode {

    public static void main(String[] args) {
        ListNode[] heads = initLinkedList();

        ListNode la = heads[0];
        ListNode lb = heads[1];

        ListNode firstCommonNodeBySet = findFirstCommonNodeBySet(la, lb);
        System.out.println("第1个公共结点为：" + firstCommonNodeBySet.val);

        ListNode findFirstCommonNodeByStack = findFirstCommonNodeByStack(la, lb);
        System.out.println("第1个公共结点为====：" + findFirstCommonNodeByStack.val);
    }

    /**
     * 初始化两个链表
     * @return
     */
    private static ListNode[] initLinkedList() {
        // 将两个链表头节点放入数组中
        ListNode[] head = new ListNode[2];

        head[0] = new ListNode(1); // 初始化第一个链表
        head[1] = new ListNode(1); // 初始化第二个链表
        // head[1] = head[0]; // 初始化第二个链表

        // node1、node2是用来辅助构建链表的节点
        ListNode node1 = head[0];
        ListNode node2 = head[1];

        // 构建第一个链表
        node1.next = new ListNode(2);
        node1 = node1.next; // node1指向下一个节点

        node1.next = new ListNode(3);
        ListNode common1 = node1.next; // 公共节点1
        node1 = node1.next; // node1指向下一个节点

        node1.next = new ListNode(4);
        ListNode common2 = node1.next; // 公共节点2
        node1 = node1.next; // node1指向下一个节点

        // 构建第二个链表
        node2.next = new ListNode(2);
        node2 = node2.next; // node2指向下一个节点

        node2.next = new ListNode(13);
        node2 = node2.next; // node2指向下一个节点

        // 两个链表相交的节点1
       node2.next = common1;
       node2 = node2.next; // node2指向下一个节点

        node2.next = new ListNode(5);
        node2 = node2.next; // node2指向下一个节点

        // 两个链表相交的节点2
        node2.next = common2;
        node2 = node2.next; // node2指向下一个节点

        return head;




    }

    public static ListNode findFirstCommonNodeBySet(ListNode headA, ListNode headB) {
        // 1.将第一个链表元素全部存到Set里
        Set<ListNode> set = new HashSet<>();
        while (headA != null) { // 每次都判断当前的节点是否为null,,若为null,则已经添加完毕
            set.add(headA);
            headA = headA.next;
        }

        // 2.遍历第二个链表，一边检测当前元素是否在Set中
        while (headB != null) {
            if (set.contains(headB)) { // 如果存在,则直接返回
                return headB;
            }
            headB = headB.next; // 否则继续遍历下一个节点
        }
        return null;
    }


    /**
     * 方法3：通过栈
     * 原理： 链表具有“唯一后继结点”的特性，通过栈同一个结点弹栈的时候，就能找到第一个公共结点，因为在栈中下一个结点若不一致，则说明上一轮的结点就是第一个公共结点， 因为一个当前结点，不能出现两个不一样的后继结点。
     */
    public static ListNode findFirstCommonNodeByStack(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack();
        Stack<ListNode> stackB = new Stack();
        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }

        ListNode preNode = null;
        while (stackB.size() > 0 && stackA.size() > 0) {
            if (stackA.peek() == stackB.peek()) {
                preNode = stackA.pop();
                stackB.pop();
            } else {
                break;
            }
        }
        return preNode;
    }
}



