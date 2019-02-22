package com.algorithm.sort;

/**
 * 希尔排序
 * 不稳定 nlog(n)
 * 希尔排序 是在插入排序的基数上进行加强
 */
public class Demo6 {

    public static void main(String[] args) {
        int[] a = {14,2,5,8,4,7,6,9,0,12,1,11,15,13,23,22,25,28,24,27,26,29,20,32,
                33,35,38,34,37,36,39,30};
        sort1(a);
        for (int i : a)
            System.out.println(i);

    }

    public static void sort1(int[] a){
        for (int i = 1;i < a.length;i++){
            for (int j = i;j > 0 && a[j - 1] > a[j];j--){
                int t = a[j - 1];
                a[j - 1] = a[j];
                a[j] = t;
            }
        }
    }

}
