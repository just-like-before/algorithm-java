package com.algorithm.offer.leetcode;

/**
 * 两个有序数组中中位数
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class Exercise4 {

    public static void main(String[] args) {
        int[] num1 = {1,3};
        int[] num2 = {2};
        System.out.println(findMedianSortedArrays(num1,num2));
    }

    /**
     * 现将两个数组合并为一个数组
     * 然后进行判断 奇偶进行比较
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] temp = mergeArray(nums1,nums2);

        double result = 0.0;

        int length = temp.length;
        int mid = length >> 1;
        //偶数
        if ((length & 1) == 0){
            result = (double)(temp[mid] + temp[mid - 1]) / 2;
        }else
            result = (double)temp[mid];

        return result;
    }

    public static int[] mergeArray(int[] nums1,int[] nums2){
        if (nums1 == null || nums2 == null){
            return null;
        }

        int n1 = nums1.length,n2 = nums2.length;
        int[] temp = new int[n1 + n2];

        int i = 0,j = 0,c = 0;
        while (i < n1 && j < n2){
            if (nums1[i] > nums2[j])
                temp[c++] = nums2[j++];
            else
                temp[c++] = nums1[i++];
        }

        while (i < n1)
            temp[c++] = nums1[i++];

        while (j < n2)
            temp[c++] = nums2[j++];

        return temp;
    }
}
