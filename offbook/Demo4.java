package com.algorithm.offer.book;

import java.util.LinkedList;
import java.util.List;

//链表->链表遍历->从尾部到头部进行遍历
public class Demo4 {

    //静态内部类
    public static class Link{

        private int value;
        private Link next;

        public Link(){

        }
    }


    //创建链表
    public static Link createLink(int[] array){
        Link head = null;
        Link p = null;
        int length = array.length;
        if (length < 1){
            new Throwable("输入的数组有误");
        }

        for (int i = 0; i < length; i++) {
            Link link = new Link();
            link.value = array[i];
            link.next = null;

            if (head == null){
                p = head = link;
            }else {
                p = p.next = link;
            }
        }
        return head;
    }

    //正向遍历
    public static void printLink(Link link){
        Link p = link;
        while (p != null){
            System.out.println(p.value);
            p = p.next;
        }
    }

    //使用栈结构实现 链表的翻转遍历
    public static void run1(Link link){
        int top = -1;
        List<Integer> list = new LinkedList<>();
        Link p = link;
        while (p != null){
            list.add(p.value);
            p = p.next;
            top++;
        }

        for (int i = top ; i > -1 ; i--) {
            System.out.println(list.get(i)+"--->");
        }
    }

    public static void main(String[] args) {
        int[] array = {2,5,6,4,5,6,9};
        Link link = createLink(array);
        run1(link);
    }

}
