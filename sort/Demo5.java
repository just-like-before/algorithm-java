package com.algorithm.sort;

/**
 * 快速排序
 */
public class Demo5 {

    public static void main(String[] args) {
        int[] a = {14,2,5,8,4,7,6,9,0,12,1};
        quickSore(a,0,a.length - 1);
        for (int i : a){
            System.out.println(i);
        }
    }

    public static void quickSore(int[] a,int left,int right){
        int start = left;
        int end = right;

        if (left > right)
            return;

        int key = a[left];

        while (end != start){

            while (a[start] <= key && start < end){
                start++;
            }

            while (a[end] >= key && start < end){
                end--;
            }

            if (start < end){
                int t = a[end];
                a[end] = a[start];
                a[start] = t;
            }
        }

        a[left] = a[start];
        a[start] = key;
        quickSore(a,left,start - 1);
        quickSore(a,start + 1,right);

    }
}
