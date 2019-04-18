package com.algorithm.offer.leetcode1;

import java.util.ArrayList;
import java.util.List;

/**
 * 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class Exercise24 {

    public static void main(String[] args) {

    }

    /**
     * 不利于扩展 只能处理 两个节点的翻转
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return head;
        }
        List<Integer> list = new ArrayList<>();
        ListNode p = head,q = null;
        int cnt = 0;
        //p往链表的尾部跑
        for (;p != null;p = p.next){
            cnt++;
            //cnt用于计数 当cnt是偶数的时候 分别将这两个数加入到 list 先加入后面的 在加入前面的
            if ((cnt & 1) == 0){
                list.add(p.val);
                list.add(q.val);
            }
            q = p;
        }

        //当链表的节点个数是奇数的时候 直接将最后一个数加入到list
        if ((cnt & 1) != 0){
            list.add(q.val);
        }

        //遍历链表 创建节点 进行尾插
        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead,node;
        for (int i : list){
            tail = tail.next = new ListNode(i);

        }
        return newHead.next;
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
