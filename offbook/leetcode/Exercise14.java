package com.algorithm.offer.leetcode1;

/**
 * 14 最常公共子串
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 所有输入只包含小写字母 a-z
 */
public class Exercise14 {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix2(strs));
    }

    /**
     * 横向进行比较
     * 以数组中的字符串个数为外层循环
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }

        String prefix = strs[0];
        for (int i = 1;i < strs.length;i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * 以数组中的每一个字符为外层循环
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }

        for (int i = 0;i < strs[0].length();i++){
            char ch = strs[0].charAt(i);
            for (int j = 1;j < strs.length;j++){
                if (i == strs[j].length() || strs[j].charAt(i) != ch){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 使用分支的思想进行求解
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }

        if(strs.length == 1){
            return strs[0];
        }

        String s = divide(strs,0,strs.length - 1);
        return s;
    }

    public static String divide(String[] strs,int start,int end){
        if(start == end){
            return strs[end];
        }
        int mid = (start + end) >> 1;
        String s1 = divide(strs,start,mid);
        String s2 = divide(strs,mid + 1,end);

        return merge(s1,s2);
    }

    public static String merge(String s1,String s2){
        for (int i = 0;i < s1.length();i++){
            if (i == s2.length() || s1.charAt(i) != s2.charAt(i)){
                return s1.substring(0,i);
            }
        }
        return s1;
    }
}
