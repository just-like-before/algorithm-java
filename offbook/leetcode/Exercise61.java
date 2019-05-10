package com.algorithm.offer.leetcode2;

/**
 * 旋转链表
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class Exercise61 {

    public static void main(String[] args) {
        ListNode h1 = new ListNode(0);
        ListNode h2 = new ListNode(1);
        ListNode h3 = new ListNode(2);

        h1.next = h2;
        h2.next = h3;
        ListNode head = rotateRight(h1,4);
        ListNode p = head;
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }

    /**
     * 进行两次链表的遍历
     * 1 计算链表的长度 然后cnt - (k % cnt); 计算要截取的位置
     * 2 找到截取的位置 是最后一个位置直接 不是尾指向头
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        //两种是0的情况
        if (k == 0 || head == null){
            return head;
        }

        //计算链表的长度
        int cnt = 0;
        ListNode newHead = new ListNode(-1);
        ListNode p = head,tail = null,newTail = null;

        while (p != null){
            cnt++;
            tail = p;
            p = p.next;
        }

        //将p指向链表的头部 进行第二次遍历
        p = head;
        newHead.next = head;
        //计算第二次遍历的长度
        int num = cnt - (k % cnt);
        //num == cnt时 证明不需要进行截取 直接返回原链表
        if (num != cnt){
            while (num > 0){
                newTail = p;
                p = p.next;
                num--;
            }

            //新头指p p前设null 尾部值头部
            newHead.next = p;
            newTail.next = tail.next;
            tail.next = head;
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
