package com.algorithm.sort;

import java.util.LinkedList;

/**
 * 快速排序的非递归实现
 * 使用栈 记录每一二分排序的左右的数组索引
 */
public class Demo7 {

    private static LinkedList<Integer> linkedList = new LinkedList<>();

    public static void main(String[] args) {
        int[] a = {14,2,5,8,4,7,6,9,0,12,1,11,15,13,23,22,25,28,24,27,26,29,20,32,
                33,35,38,34,37,36,39,30};

        quickSort(a);
        for (int i : a){
            System.out.println(i);
        }
    }

    public static void quickSort(int[] array){
        int left = 0;
        int right = array.length - 1;

        linkedList.push(left);
        linkedList.push(right);

        while (!linkedList.isEmpty()){

            right = linkedList.pop();
            left = linkedList.pop();

            int index = partition(left,right,array);

            if ((index - 1) > left){
                linkedList.push(left);
                linkedList.push(index - 1);
            }

            if ((index + 1) < right){
                linkedList.push(index + 1);
                linkedList.push(right);
            }
        }
    }

    public static int partition(int left,int right,int[] array){
        int temp = array[left];
        while (left != right){

            while (array[right] >= temp && right > left)
                right--;

            array[left] = array[right];

            while (array[left] <= temp && right > left)
                left++;

            array[right] = array[left];
        }

        array[left] = temp;
        return left;
    }
}
