package com.algorithm.sort;

/**
 * 选择排序
 * 稳定
 * 先循环一圈 选择最小的放在a[0]
 * 在跑一圈 选择次小放在a[0]
 */
public class Demo2 {

    public static void main(String[] args) {
        int[] a = {9,2,5,8,4,7,6,1};
        run2(a);
    }

    public static void run1(int[] a){
        int lenght = a.length;
        for (int i = 0;i < lenght - 1;i++){
            for (int j = i + 1;j < lenght;j++){
                if (a[i] > a[j]){
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }

        for(int i : a){
            System.out.println(i);
        }
    }

    public static void run2(int[] a){
        int length = a.length;
        for (int i = 1;i < length;i++){
            for(int j = 0;j < i;j++){
                if (a[i] < a[j]){
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }

        for(int i : a){
            System.out.println(i);
        }
    }
}
