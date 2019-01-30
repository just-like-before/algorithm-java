package com.algorithm.sort;

/**
 * 插入排序
 *
 * 先是数组中a[0] 是一段
 * 然后a[0]与a[1] 比较 a[0]>a[1] 交换
 * a[0]与a[2]比较 a[1]与a[2]比较
 * 稳定 o(n*n)
 */
public class Demo3 {

    public static void main(String[] args) {
        int[] a = {9,2,5,8,4,7,6,1};
        run1(a);
    }

    public static void run1(int[] a){
        int length = a.length;
        for (int i = 1;i < length;i++){
            for (int j = 0;j < i && a[j] > a[i];j++){
                //&& a[j] > a[i] 当有这个判断的时候会避免 不必要的循环
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }

        for (int i : a){
            System.out.println(i);
        }
    }

    public static void run2(int[] a){
        int length = a.length;
        for (int i = 1;i < length;i++){
            for (int j = i;j > 0;j--){
                if (a[j - 1] > a[j]){
                    int t = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = t;
                }
            }
        }

        for (int i : a){
            System.out.println(i);
        }
    }
}
