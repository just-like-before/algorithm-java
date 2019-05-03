package com.algorithm.offer.leetcode1;

/**
 * 搜素插入的位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class Exercise35 {

    public static void main(String[] args) {
        int[] a = {1,3,5,6};
        System.out.println(searchInsert(a,0));
    }

    /**
     * 先进行二分插入 然后在是需要插入
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int start = 0,end = nums.length - 1;
        int mid = 0;
        while (start <= end){
            mid = start + end >> 1;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        //走到这里证明没有找到 需要进行判断
        //1 nums[mid] > target target需要放在前面
        //2 否则需要放在后面
        return nums[mid] > target?mid : mid + 1;
    }
}
