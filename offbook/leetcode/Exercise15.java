package com.algorithm.offer.leetcode1;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Exercise15 {

    public static void main(String[] args) {
        int[] array = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum(array);
        for (int i = 0;i < list.size();i++) {
            for (int num : list.get(i))
                System.out.print(num + "\t");
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3){
            return list;
        }
        //排序
        Arrays.sort(nums);

        //第一个数大于0 或者最后一个数小于0 直接返回list
        if (nums[nums.length - 1] < 0 || nums[0] > 0){
            return list;
        }

        int j,k;
        //保证数据不重复
        HashSet<List<Integer>> hashSet = new HashSet<>();
        //外层遍历所有的数据
        for (int i = 0;i < nums.length;i++){
            //第一个数据 大于0 直接返回
            if (nums[i] > 0)
                break;

            j = i + 1;k = nums.length - 1;
            while (j < k){
                if (nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    hashSet.add(l);

                    //防止重复的数据
                    while (j < k && nums[j] == nums[j + 1])
                        j++;

                    while (j < k && nums[k] == nums[k - 1])
                        k--;

                    j++;
                    k--;
                }else if (nums[i] + nums[j] + nums[k] < 0){
                    //小 加
                    j++;
                    //大 减
                }else {
                    k--;
                }
            }
        }
        return new ArrayList<>(hashSet);
    }
}
