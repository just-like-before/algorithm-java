package com.algorithm.recall;

/**
 * 回溯经典应用八皇后
 */
public class EightQueen {

    public static void main(String[] args) {
        eightQueen();
    }

    /**
     * 每一行都从0列开始寻找
     */
    public static void eightQueen(){
        //记录这里列是否有元素
        int[] col = new int[8];
        //记录左斜线是否有元素
        int[] left = new int[15];
        //记录右斜线出是否有元素
        int[] right = new int[15];
        //记录皇后
        int[] queen = new int[8];
        //相当于一个栈 记录皇后的位置
        int top = -1;
        //做每行遍历和回溯的记录
        int i = 0,j = 0;
        while (top != 7){
            for (;j < 8;j++){
                if (col[j] == 0 && left[i+j]== 0 && right[7-j+i] == 0){
                    //满足条件放皇后 放好之后跳出循环
                    col[j] = 1;
                    left[i+j] = 1;
                    right[7-j+i] = 1;
                    queen[++top] = j;
                    i++;
                    j = 0;
                    break;
                }
            }
            //这一行的所有列都不能放 证明前一行放的有问题 需要进行回溯 将之前存储的皇后位置进行清除
            if (j == 8){
                i--;
                j = queen[top--];
                col[j] = 0;
                left[i+j] = 0;
                right[7-j+i] = 0;
                j++;
            }
        }

        //输出放好的皇后
        for (i = 0;i < 8;i++){
            for (j = 0;j < 8;j++){
                if (queen[i] == j){
                    System.out.print(1);
                }else{
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }

}
