package com.brucepang.charpter1_linklist.level1;

/**
 * 在算法中最常用的链表定义方式
 *
 * @author BrucePang
 */
public class ListNode {
    public int val;
    public ListNode next;

    // 为什么使用有参构造器给属性赋值,并且属性是public的?
    // 如果是在开发一个项目的话,那么这样的写法是不合理的,因为属性是public的,会导致属性被随意修改,不符合面向对象的封装特性
    // 但是在算法中,我们只关注算法的实现,不关注属性的封装,所以这样的写法是合理的,并且也减少了代码的行数,增加了代码的可读性
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static void main(String[] args) {
        ListNode listnode=new ListNode(1);
    }
}
