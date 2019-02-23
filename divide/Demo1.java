package com.algorithm.divide;

/**
 *二分法查找
 */
public class Demo1 {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        int target = 0;
        run(a,0,a.length - 1,target);
    }

    public static void run(int[] a,int left,int right,int target){
        if (left > right) {
            System.out.println("这个数组中没有这个元素");
            return;
        }

        int mid = (left + right) / 2;

        if (a[mid] == target) {
            System.out.println(target + "在数组的下标索引是" + mid);
            return;
        }
        if (a[mid] < target)
            run(a,mid + 1,right,target);
        if (a[mid] > target)
            run(a,left,mid - 1,target);
    }
}
