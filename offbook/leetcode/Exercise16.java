package com.algorithm.offer.leetcode1;

import java.util.Arrays;

/**
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class Exercise16 {

    public static void main(String[] args) {
        int[] array = {0,0,0};
        System.out.println(threeSumClosest(array,1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3){
            return target;
        }
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int sum;
        int left,right;
        for (int i = 0;i < nums.length - 2;i++){
            left = i + 1;
            right = nums.length - 1;
            while (left < right){

                sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(result - target) > Math.abs(sum - target)){
                    result = sum;
                }

                if (sum < target){
                    left++;
                }else if (sum > target){
                    right--;
                }else {
                    return sum;
                }
            }
        }

        return result;
    }
}
