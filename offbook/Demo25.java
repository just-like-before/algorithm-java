package com.algorithm.offer.book;

import com.algorithm.link.Node;
import com.algorithm.link.Test;

/**
 * 合并两个有序的链表
 */
public class Demo25 {

    public static void main(String[] args) {
        int[] link1 = {1,3};
        int[] link2 = {2};

        Node head1 = Test.createLinkToHead(link1);
        Node head2 = Test.createLinkToHead(link2);

        Node newLinkHead = mergeLink(head1,head2);
        Test.printLink(newLinkHead);
    }

    public static Node mergeLink(Node head1,Node head2){
        if (head1 == null)
            return head2;
        else if (head2 == null)
            return head1;

        //1 3
        //2
        Node newLinkHead = null;
        if (head1.getValue() < head2.getValue()){
            newLinkHead = head1;
            newLinkHead.setNext(mergeLink(head1.getNext(),head2));
        }else {
            newLinkHead = head2;
            newLinkHead.setNext(mergeLink(head1,head2.getNext()));
        }

        return newLinkHead;
    }


}
