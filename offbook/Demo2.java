package com.algorithm.offer.book;

//数组->数组中的查找
public class Demo2 {

    /*
    一个二维数组 数组中的数组 从左到右 递增 从上到下 递增
    输入这样的一个二维数组和一个整数 判断这个二维数组中是否有这个整数
    使用for循环
     */
    public static boolean run(int[][] array2,int key){
        int row = array2.length;
        int col = array2.length;
        for (int i = 0; i < row; i++) {
            for (int j = col - 1; j > -1; j--) {
                if (array2[i][j] > key){
                    col--;
                }else if (array2[i][j] == key){
                    return true;
                }else {
                    break;
                }
            }

        }
        return false;
    }

    //使用while循环
    public static boolean run2(int[][] array2,int key){
        int rows = array2.length;
        if (rows < 1){
            return false;
        }
        int cols = array2[rows - 1].length;
        if(rows > 0 && cols > 0){
            int row = 0;
            int col = cols - 1;
            while(row < rows && col > -1){
                if (array2[row][col] > key){
                    col--;
                }else if(array2[row][col] == key){
                    return true;
                }else {
                    row++;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] array2= {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int key = 6;
        System.out.println(run2(array2,key));
    }
}
