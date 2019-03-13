package com.algorithm.offer.book;

/**
 * 斐波那契数列
 */
public class Demo8 {

    /**
     * 递归实现
     * f(0)=0 n = 0
     * f(1)=1 n = 1
     * f(n)=f(n-1)+f(n-2) f>1 2 1;3 2;4 3;5 5;6 8;7 13;8 21
     * @param n
     * @return
     */
    public static int run1(int n){
        if (n < 1){
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return run1(n - 1) + run1(n - 2);
    }

    /**
     * 循环实现
     * 从下往上实现 将计算到的数据记录
     * @param n
     * @return
     */
    public static int run2(int n){
        int result[] = {0,1};

        if (n < 2){
            return result[n];
        }
        int f1 = 0;
        int f2 = 1;
        int f = 0;
        for (int i = 2;i <= n;i++){
            f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println(run1(8));
    }
}
