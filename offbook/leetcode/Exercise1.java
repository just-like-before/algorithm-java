package com.algorithm.offer.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Exercise1 {

    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int[] result = twoSum2(array,9);
        System.out.println(result[0] + "--" + result[1]);
    }

    /**
     * 一次遍历哈希表也可以解决这个问题
     * 一边将元素放入哈希表 一边进行比较 看之前是否有与他相同的值
     */
    public static int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 1){
            return null;
        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            int twoNum = target - nums[i];
            if (map.containsKey(twoNum)) {
                return new int[]{map.get(twoNum),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    /**
     * 使用hashMap key=num[i] value=i;
     * 第一次遍历将数组中的数字全部放入HashMap中
     * 第二次遍历判断HashMap 是否存在 targer-num[i]
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2){
            return null;
        }

       HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0;i < nums.length;i++){
            hashMap.put(nums[i],i);
        }

        for (int i = 0;i < nums.length;i++){
            int twoNum = target - nums[i];
            int c = 0;
            if (hashMap.containsKey(twoNum) && (c = hashMap.get(twoNum) )!= i){
                int[] array = new int[2];
                array[0] = i;
                array[1] = c;
                return array;
            }
        }
        return null;
    }

    /**
     * 双层循环
     * 第一层遍历
     * 第二层判断
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length < 2){
            return null;
        }

        for (int i = 0;i < nums.length;i++){
            int twoNum = target - nums[i];
            for (int j = i + 1;j < nums.length;j++){
                if (nums[j] == twoNum){
                    int[] array = new int[2];
                    array[0] = i;
                    array[1] = j;
                    return array;
                }
            }
        }
        return null;
    }
}
