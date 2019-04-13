package com.algorithm.offer.leetcode1;

import java.util.LinkedList;

/**
 * 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class Exercise20 {

    public static void main(String[] args) {
        System.out.println(isValid(""));
    }

    /**
     * 使用栈存储左括号 是有括号进行判断 匹配成功出栈 不成功直接返回false
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s == null || (s.length() & 1 ) != 0){
            return false;
        }

        if (s.length() == 0){
            return true;
        }

        LinkedList<Character> linkedList = new LinkedList<>();
        char ch;
        for (int i = 0;i < s.length();i++){
            ch = s.charAt(i);
            if (!isPush(ch) && (linkedList.isEmpty() ||
                    Math.abs((int)ch - (int)linkedList.peek()) > 3)){
                return false;
            }else if (!isPush(ch)){
                linkedList.pop();
            }else {
                linkedList.push(ch);
            }

        }
        return linkedList.isEmpty();
    }

    /**
     * 判断是否入栈
     * @param ch
     * @return
     */
    public static boolean isPush(char ch){
        return ch == '[' || ch == '{' || ch == '(';
    }
}
