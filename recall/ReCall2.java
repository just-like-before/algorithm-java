package com.algorithm.recall;

/**
 * 给出一个字符串 找一个它的所有组合
 */
public class ReCall2 {

    public static void main(String[] args) {
        String s = "abc";
        find(s,"");
    }

    public static void find(String s,String target){
        if (s.length() == 0) {
            System.out.println(target);
            return;
        }

        for (int i = 0;i < s.length();i++){
            String newS = s.substring(0,i) + s.substring(i + 1,s.length());
            find(newS,target + s.charAt(i));
        }
    }
}
