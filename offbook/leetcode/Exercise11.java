package com.algorithm.offer.leetcode;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class Exercise11 {

    public static void main(String[] args) {
        int[] a = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea1(a));
    }

    /**
     * 暴力解法 两层for训话 进行遍历
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        if (height == null || height.length < 2){
            return 0;
        }

        int max = 0;
        for (int i = 0;i < height.length - 1;i++){
            for (int j = i + 1;j < height.length;j++){
                int c = (j - i) * Math.min(height[i],height[j]);
                if (c > max){
                    max = c;
                }
            }
        }
        return max;
    }

    /**
     * 头尾指针法 进行遍历 0(n)
     * @param height
     * @return
     */
    public static int maxArea1(int[] height){
        if (height == null || height.length < 2){
            return 0;
        }

        int start = 0,end = height.length - 1;
        int max = 0;
        int mid = 0;
        while (start < end){
            mid = (end - start) * Math.min(height[start],height[end]);
            max = mid > max ? mid : max;
            //height[start] < height[end] 1 8 只有start++ 才有可能找到比之前更大的数
            if (height[start] < height[end])
                start++;
            else
                end--;
        }
        return max;
    }
}
