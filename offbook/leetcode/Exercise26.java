package com.algorithm.offer.leetcode1;

/**
 * 删除排序数组中的重复元素
 *
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Exercise26 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        System.out.println(removeDuplicates(nums));
        for (int i : nums){
            System.out.println(i);
        }
    }

    /**
     * 使用插入排序思想 n1表示当前重复的元素 n2去找去后面第一个比他大的元素
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int n1 = 1;
        int n2 = 1;
        //n1 < nums.length 表示表示执行完了 用来限定这个数组中没有重复的元素1 2 3 4
        while (n1 < nums.length){
            //插入排序的思想
            if (nums[n1] <= nums[n1 - 1]){

                //当n1跑了很多步了 n2=1 || n2<n1 情况 1 2 3 4 5 5 这是n1到5了n2在2 需要进行特殊的处理
                if (n2 < n1){
                    n2 = n1;
                }
                //这是当前n2的值 要找这个值后面第一个比他大的值
                int num2 = nums[n2];
                //防止数组越界
                while (n2 < nums.length && num2 == nums[n2])
                    n2++;

                //n2跑到数组尾部直接返回 0 0 0 0 n1在第二个0 n2在尾部直接返回n1
                if (n2 == nums.length){
                    return n1;
                }
                nums[n1] = nums[n2];
            }
            n1++;
        }
        return n1;
    }
}
