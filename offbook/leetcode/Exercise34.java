package com.algorithm.offer.leetcode1;

/**
 * 在排序数组中查找目标元素第一个和最后一个其实位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class Exercise34 {

    public static void main(String[] args) {
        int[] a = {5,7,7,8,8,10};
        int[] res = searchRange(a,9);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    /**
     * 先进行二分查找 看数组中是否存在 target
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int start = 0,end = nums.length - 1;
        int mid = 0;
        while (start <= end){
            mid = start + end >> 1;
            if (nums[mid] == target){
                break;
            }else if (nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }


        int[] result = {-1,-1};
        //当没有找到的时候 最后一次判断之前 走的是第二个或者第三个分支
        // start end 与mid的值不相同 需要进行改写
        start = mid;
        end = mid;

        //证明找到了元素 然后在进行遍历 找出这个元素的起始位置
        if (nums[start] == target){
            while (start > -1 && nums[start] == target){
                start--;
            }

            while (end < nums.length && nums[end] == target){
                end++;
            }

            //将起始位置 存到数组中
            result[0] = start + 1;
            result[1] = end - 1;
        }
        //没有找到 不走if 直接返回 原数组
        return result;
    }

}
