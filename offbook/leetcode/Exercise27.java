package com.algorithm.offer.leetcode1;

/**
 * 移除元素
 *
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 *
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 *
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * 注意这五个元素可为任意顺序。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Exercise27 {

    public static void main(String[] args) {
        int[] a = {2};
        System.out.println(removeElement(a,1));
        for (int i : a){
            System.out.println(i);
        }
    }

    /**
     * 使用双向指针法 一个指针从前往后找是val的元素
     * 一个指针从后往前找不是val的元素 然后两个指针进行交换
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0){
            return 0;
        }


        int start = 0,end = nums.length - 1;
        while (start < end){

            //只有start <= end 时进行查找 等于的这也条件可以是 start跑到数组的尾部
            while (start <= end && nums[start] != val) {
                start++;
            }

            while (start <= end && nums[end] == val){
                end--;
            }

            if (start < end){
                nums[start] = nums[start] + nums[end];
                nums[end] = nums[start] - nums[end];
                nums[start] = nums[start] - nums[end];
                start++;
                end--;
            }
        }

        //用于处理数组中没有 val的情况 2 3 找 4
        if (start == nums.length){
            return start;
        }

        //最后的结果中有val的情况 大概有两种
        // 1 nums[start] = val 证明是在是val的第一个元素是结束 直接返回val 3 2 2 3 找 2
        // 2 nums[start] != val 证明是在val的前一个元素出结束 返回start+2 3 2 2 3 找 3
        return nums[start] == val?start:start + 1;
    }
}
