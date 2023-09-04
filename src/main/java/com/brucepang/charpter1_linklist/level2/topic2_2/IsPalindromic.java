package com.brucepang.charpter1_linklist.level2.topic2_2;

import com.brucepang.charpter1_linklist.level2.ListNode;

import java.util.List;
import java.util.Stack;

/**
 * 判断链表是否回文
 *
 * @author BrucePang
 */
public class IsPalindromic {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 0, 3, 2, 1};
        // 创建链表
        ListNode node = initLinkedList(a);

        // 判断该链表是否为回文链表
        int testMethod = 2;
        switch (testMethod) {
            case 1: // 面试一般不用，因为会回避链表
                System.out.println("方法1：通过数组两端向中间比较的方式来判断");
                System.out.println("result:" + isPalindromeByArray(node));
                break;
            case 2:
                System.out.println("方法2：通过栈的方式来判断");
                System.out.println("result:" + isPalindromeByStack0(node));
                break;
        }

    }

    /**
     * 方法1：将链表元素都赋值到数组中，然后可以从数组两端向中间对比。这种方法会被视为逃避链表，面试不能这么干。
     */
    public static boolean isPalindromeByArray(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        // 将链表元素都赋值到数组中
        ListNode[] nodes = new ListNode[getLength(head)];

        for (int i = 0; i < nodes.length; i++) { // 将链表元素都赋值到数组中
            nodes[i] = head;
            head = head.next;
        }

        // 判断该链表是否为回文链表
        int left = 0;              // 左指针从数组开头开始
        int right = nodes.length - 1; // 右指针从数组末尾开始

        while (left < right) {      // 循环直到两个指针相遇或交叉
            if (nodes[left].val != nodes[right].val) {
                return false;       // 如果发现元素不相等，返回 false
            }
            left++;                 // 向右移动左指针
            right--;                // 向左移动右指针
        }

        return true;               // 如果没有发现不相等的元素，返回 true
    }

    /**
     * 方法2：将链表元素全部压栈，然后一边出栈，一边重新遍历链表，一边比较两者元素值，只要有一个不相等，那就不是。
     */
    public static boolean isPalindromeByStack0(ListNode head) {
        if (head == null || head.next == null) { // 链表为空或只有一个元素，直接返回true
            return true;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head; // 用临时变量来操作链表，避免head丢失
        while (cur != null) { // 压栈
            stack.push(cur);
            cur = cur.next;
        }

        while (!stack.isEmpty()) { // 出栈
            ListNode node = stack.pop(); // 出栈，并删除栈顶元素
            if (node.val != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 获取链表长度
     */
    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    /**
     * 初始化链表
     *
     * @param a
     * @return
     */
    public static ListNode initLinkedList(int[] a) {
        // 非空校验
        if (a == null || a.length == 0) {
            return null;
        }

        // 初始化头结点
        ListNode head = null;
        ListNode cur = null;
        // 创建链表
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                head = new ListNode(a[i]);
                cur = head;
            } else {
                cur.next = new ListNode(a[i]);
                cur = cur.next;
            }
        }
        return head;

    }
}
