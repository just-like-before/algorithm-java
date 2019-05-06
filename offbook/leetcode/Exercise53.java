package com.algorithm.offer.leetcode2;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Exercise53 {

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE,sum = 0;
        for (int i = 0;i < nums.length;i++){
            sum += nums[i];
            max = Math.max(sum,max);
            if (sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}
