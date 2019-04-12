package com.algorithm.offer.leetcode1;

/**
 * 19. 删除链表的倒数第N个节点
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class Exercise19 {

    public static void main(String[] args) {
        //测试
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode.next = listNode1;
        ListNode head = removeNthFromEnd(listNode,1);
        for (;head != null;head = head.next){
            System.out.println(head.val);
        }
    }

    /**
     * 两个指针一起跑 一个指针先跑n步 然后两个指针一起跑
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head,q = head,k;
        //q先跑n步
        while (q != null && n > 0){
            q = q.next;
            n--;
        }


        //判断q是null的情况
        if (q == null && n == 0){
            return head.next;
        }else if (q == null && n != 0){
            return head;
        }

        //q在跑一步
        q = q.next;
        //q p一起跑 知道q到null
        while (q != null){
            q = q.next;
            p = p.next;
        }

        /**
         * 1 2 3 4 删除3时 p = 2
         * 删除4时 p = 3 所以直接删除
         */
        k = p.next;
        p.next = k.next;

        return head;
    }

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
