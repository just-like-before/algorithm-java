package com.algorithm.offer.book;

import java.util.ArrayList;
import java.util.List;

;

/**
使用两个栈实现队列 stack1 stack2 -> queue
 实现有两个情况 stack2为空的时候 就将stack1的元素以次的压入stack2
 如果stack2不为空就以次将stack2的元素以次弹出
 */
public class Demo7 {

    private static List<Integer> list1 = new ArrayList<>();
    private static List<Integer> list2 = new ArrayList<>();
    private static int p1 = -1;
    private static int p2 = -1;

    public static void enQueue(int num){
        list1.add(num);
    }

    public static int deQueue(){
        if (list2.size() == 0){
            int size = list1.size();
            for (int i = 0;i < size;i++){
                list2.add(list1.remove(list1.size() - 1));
            }
        }
        return list2.remove(list2.size() - 1);
    }

    public static void enQueue1(int num){
        list1.add(num);
        p1++;
    }

    public static void main(String[] args) {
        enQueue(1);
        enQueue(2);
        enQueue(3);
        enQueue(4);
        System.out.println(deQueue());
        System.out.println(deQueue());
        System.out.println(deQueue());
        enQueue(5);
        System.out.println(deQueue());
        System.out.println(deQueue());

    }
}
