package com.algorithm.sort;

/**
 * 对快排的优化
 * 挖坑填树法
 */
public class Demo8 {


    public static void main(String[] args) {
        int[] a = {14,2,5,8,4,7,6,9,0,12,1,11,15,13,23,22,25,28,24,27,26,29,20,32,
                33,35,38,34,37,36,39,30};

        quickSort(0,a.length - 1,a);
        for (int i : a){
            System.out.println(i);
        }
    }


    public static void quickSort(int left,int right,int[] array){

        if (left > right)
            return;

        //当递归时的数组的长度小于5的时候 采用直接插入排序
        if ((right - left) < 5){
            for (int i = left;i < right;i++){
                for (int j = i + 1;j > left - 1;j--){
                    if (array[j - 1] > array[j]){
                        int swap = array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = swap;
                    }
                }
            }
            return;
        }


        int i = left;
        int j = right;


        int temp = array[left];
        while (i != j){

            while (array[j] >= temp && i < j)
                j--;

            array[i] = array[j];

            while (array[i] <= temp && i < j)
                i++;

            array[j] = array[i];
        }

        array[i] = temp;

        quickSort(left,i - 1,array);
        quickSort(i + 1,right,array);
    }
}
