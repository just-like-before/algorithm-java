package com.algorithm.sort;

/**
 * 归并排序 两种实现 递归 迭代
 * 稳定 nlog(n)
 */
public class Demo4 {

    public static void main(String[] args) {
        int[] a = {14,2,5,8,4,7,6,9,0,12,1};
        sort(a,a.length);
        for (int i : a)
            System.out.println(i);
    }

    public static void sort(int[] a,int l){
        int[] temp = new int[a.length];
        sort1(a,0,a.length - 1,temp);

    }

    public static void sort1(int a[],int left,int right,int[] temp){
        if (left < right){
            int mid = (left + right) / 2;
            sort1(a,left,mid,temp);
            sort1(a,mid + 1,right,temp);

            merge(a,left,right,mid,temp);
        }
    }

    public static void merge(int a[],int left,int right,int mid,int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;
        while(a[i] < a[j]){
            temp[t++] = a[i++];
        }

        while (i <= mid && j <= right){
            if (a[i] < a[j])
                temp[t++] = a[i++];
            else
                temp[t++] = a[j++];
        }

        while(i <= mid){
            temp[t++] = a[i++];
        }

        while (j <= right){
            temp[t++] = a[j++];
        }

        t = 0;
        while (left <= right){
            a[left++] = temp[t++];
        }
    }
}
