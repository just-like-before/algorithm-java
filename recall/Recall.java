package com.algorithm.recall;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯算法
 * 给出n对括号 求出所有括号组合的可能
 */
public class Recall {

    public static void main(String[] args) {
        int n = 2;
        int left = n,right = n;
        List<String> list = new ArrayList<>();
        recall("",left,right,list);
        list.forEach(System.out::println);
    }

    public static void recall(String s,int left,int right,List<String> list){
        if (left == 0 && right == 0)
            list.add(s);
        if (right > left)
            recall(s + ")",left,right - 1,list);
        if (left > 0)
            recall(s + "(",left - 1,right,list);
    }
}
