package com.algorithm.sort;

/**
 * 冒泡排序
 * 稳定
 * 两两交换 让最后一个数最大
 * 第一个数与第二个数比较 a[0]>a[1] 交换
 * 第二个数与第三个数比较 a[1]>a[2] 交换 这样最后一个数就最大了
 *
 * 外圈length-1 次
 * 内圈length - i 次
 */
public class Demo1 {

    public static void main(String[] args) {
        int[] a = {3,2,5,8,4,7,6,1};
        run1(a);
    }

    public static void run1(int[] a){
        int length = a.length;
        for (int i = 0;i < length - 1;i++){
            for (int j = 0;j < length - i - 1;j++){
                if (a[j] > a[j + 1]){
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }

        for (int i : a){
            System.out.println(i);
        }
    }
}
