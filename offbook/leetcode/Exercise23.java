package com.algorithm.offer.leetcode1;

/**
 * 合并k个排序链表
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Exercise23 {

    public static void main(String[] args) {
        ListNode[] listNodes = {};
        System.out.println(mergeKLists(listNodes));
    }

    /**
     * 整体采用分治的思想 分成小份在进行合并
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        return divide(lists,0,lists.length - 1);
    }

    public static ListNode divide(ListNode[] listNodes,int left,int right){
        if (left == right){
            return listNodes[left];
        }

        //分治
        int mid = left + right >> 1;
        ListNode l1 = divide(listNodes,left,mid);
        ListNode l2 = divide(listNodes,mid + 1,right);

        return mergeTwoLists(l1,l2);
    }

    /**
     * 两个链表的合并
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
