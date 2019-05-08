package com.algorithm.offer.leetcode2;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 */
public class Exercise58 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a aa "));
    }

    /**
     * 一次遍历
     * 当s.charAt(i) == ' ' cnt=0
     * 否则cnt++ last记录最后一个单词的长度
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        int cnt = 0;
        //用于记录单词的长度
        int last = 0;
        for (int i = 0;i < s.length();i++) {
            if (s.charAt(i) == ' ') {
                cnt = 0;
            } else {
                cnt++;
                last = cnt;
            }
        }
        return last;
    }
}
