package com.algorithm.recall;

/**
 * 给定一个数组 在给出一个目标值
 * 找出数组中元素和为 目标值的组合
 */
public class Recall1 {

    public static void main(String[] args) {
        int[] a = {1,2,5,6};
        int target = 7;
        find(a,target,"");
    }

    public static void find(int[] a,int targer,String temp){
        if (isTarget(targer,temp)) {
            System.out.println(temp);
            return;
        }

        for(int i = 0;i < a.length;i++){
            if (a[i] != -1) {
                int k = a[i];
                a[i] = -1;
                find(a, targer, temp + k);
                a[i] = k;
            }
        }
    }

    public static boolean isTarget(int target,String temp){
        if (temp == null || "".equals(temp))
            return false;

        int count = 0;
        for (int i = 0;i < temp.length();i++)
            count += Integer.valueOf(temp.charAt(i) + "");

        if (count == target)
            return true;

        return false;
    }
}
