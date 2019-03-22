package com.algorithm.offer.app;

/**
 * 取出1-n之间的素数
 */
public class Demo1 {

    public static void main(String[] args) {
        int i = countPrimeNum(100000);
        System.out.println(i);
    }

    public static int countPrimeNum(int n){
        if (n <= 1)
            return 0;

        int cnt = 1;
        for (int i = 3;i <= n;i+=2){
            if (isPrimeNum(i))
                cnt++;
        }

        return cnt;
    }

    public static boolean isPrimeNum(int num){
        boolean result = true;
        for (int i = 3;i*i <= num;i+=2){
            if (num % i == 0){
                result = false;
                break;
            }
        }
        return result;
    }
}
