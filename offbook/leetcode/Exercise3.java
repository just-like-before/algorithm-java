package com.algorithm.offer.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Exercise3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    /**
     * 逻辑上定义一个滑动窗口 窗口内的字符不重复的
     * 使用HashMap作为辅助空间
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1){
            return 0;
        }

        int max = 0;
        int index = -1;
        char ch;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0;i < s.length();i++){
            if (map.containsKey(ch = s.charAt(i))){
                //abba 时 ch=b 这时index=2 当ch=a时 index=3 选择index中大的一个数
                //防止窗口回调 使index=0 这时j-index=3 出现错误
                index = Math.max(index,map.get(ch));
            }

            //有新值创建一个entry 没有回覆盖之前的值
            map.put(s.charAt(i),i);

            max = Math.max(i - index,max);
        }
        return max;
    }

}
