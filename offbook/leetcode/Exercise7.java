﻿package com.algorithm.offer.leetcode;

/**
 * 整数翻转
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，
 * 则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Exercise7 {

    public static void main(String[] args) {
        System.out.println(-22 % 12);
        //System.out.println(reverse(-222));
    }

    public static int reverse(int x) {

        int result = 0;
        int mid = 0;
        while (x != 0){
            mid = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE && mid > 7)){
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MAX_VALUE && mid < -8)){
                return 0;
            }
            result = result * 10 + mid;
        }

        return result;
    }
}
