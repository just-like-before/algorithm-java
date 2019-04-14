package com.algorithm.offer.leetcode1;

/**
 * 合并两个有序链表
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Exercise21 {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead;
        ListNode p1 = l1,p2 = l2;
        //p1 p2 都不为空 比较然后加入新链表
        while (p1 != null && p2 != null){
            if (p1.val > p2.val){
                tail = tail.next = p2;
                p2 = p2.next;
            }else {
                tail = tail.next = p1;
                p1 = p1.next;
            }
        }

        //如果一个为空 则进行判断选择 部位空的加入新链表
        while (p1 != null){
            tail = tail.next = p1;
            p1 = p1.next;
        }

        while (p2 != null){
            tail = tail.next = p2;
            p2 = p2.next;
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
