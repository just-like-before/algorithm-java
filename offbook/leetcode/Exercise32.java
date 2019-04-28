package com.algorithm.offer.leetcode1;

/**
 * 最常有效括号
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 */
public class Exercise32 {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()"));
    }

    public static int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0;i < s.length();i++){
            if (chars[i] == ')' && isPatition(chars,i)) {
                cnt += 2;
                max = Math.max(max,cnt);
            }
            else if (chars[i] == ')'){
                cnt = 0;
            }
        }
        return max;
    }

    public static boolean isPatition(char[] chars,int index){
        int beforeIndex = index - 1;
        while (beforeIndex > -1 && chars[beforeIndex] == 'h')
            beforeIndex--;

        if (beforeIndex > -1 && chars[beforeIndex] == '('){
            chars[index] = 'h';
            chars[beforeIndex] = 'h';
            return true;
        }
        return false;
    }
}
