package com.algorithm.offer.leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Exercise9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }

    /**
     * 如果这个数是负数 直接返回false
     *
     * 否则 将这个数进行翻转 然后与之前的值进行比较
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }

        int temp = 0;
        int temp1 = x;
        int mid;
        while (x != 0){
            mid = x % 10;
            x = x / 10;
            if (temp > Integer.MAX_VALUE / 10 || (temp == Integer.MAX_VALUE && mid > 7)){
                return false;
            }
            temp = temp * 10 + mid;
        }
        return temp == temp1;
    }
}
