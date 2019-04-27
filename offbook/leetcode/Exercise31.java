package com.algorithm.offer.leetcode1;

/**
 * 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class Exercise31 {

    public static void main(String[] args) {
        int[] a = {1,3,2};
        nextPermutation(a);
        for (int i : a)
            System.out.println(i);
    }

    public static void nextPermutation(int[] nums) {
        for (int i = nums.length - 2;i > -1;i--){
            if (nums[i] < nums[i + 1]){
                nums[i] = nums[i] ^ nums[i + 1];
                nums[i + 1] = nums[i] ^ nums[i + 1];
                nums[i] = nums[i] ^ nums[i + 1];
                return;
            }
        }

        int start = 0,end = nums.length - 1;
        while (start < end){
            int k = nums[start];
            nums[start] = nums[end];
            nums[end] = k;
            start++;
            end--;

        }
    }
}
