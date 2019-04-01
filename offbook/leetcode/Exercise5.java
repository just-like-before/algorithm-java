package com.algorithm.offer.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Exercise5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1){
            return null;
        }

        int end = 0,start = 0;

        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0;i < s.length();i++){
            //aba 样式的查找
            int x = partition(s,i,i);
            //abba 样式的查找
            int y = partition(s,i,i+1);

            max = Math.max(x,y);
            if (max > end - start){
                //通过i max值计算出 start 和end 的值 方便后面的截取
                start = i - ((max - 1) >> 1);
                end = (max >> 1) + i;
            }
        }
        return s.substring(start,end + 1);
    }

    /**
     * 以一个字符为中心 找到两端满足回文条件的字符串
     * 返回这个字符串的长度
     * @param str
     * @param left
     * @param right
     * @return
     */
    public static int partition(String str,int left,int right){
        while (left > -1 && right < str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
