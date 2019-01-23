package com.algorithm.offer.book;

//字符串->字符串的替换 we are happy -> we%20are%20happy
public class Demo3 {

    /*
    时间复杂度是o(2n) 先遍历 字符串 计算 ' '空格的数目 然后计算型生成字符串的长度length=' '数目*2+元数组的长度
    然后在从后往前进行数组的拷贝
     */
    public static String run1(String string){
        int cnt = 0;
        int length = string.length();
        if (string == null || length == 0){
            return "输出有误";
        }

        for (int i = 0; i < string.length(); i++) {
            if (' ' == string.charAt(i)){
                cnt++;
            }
        }

        int newLength = cnt * 2 + length;
        char[] chars = new char[newLength];
        int p1 = length - 1;
        int p2 = newLength - 1;
        for (int i = 0; i < length; i++) {
            char ch = string.charAt(p1--);
            if (' ' != ch){
                chars[p2--] = ch;
            }else{
                chars[p2--] = '0';
                chars[p2--] = '2';
                chars[p2--] = '%';
            }
        }
        return new String(chars);
    }

    /*
    将两个递增的数组合并为一个递增的数组 和run1
     */
    public static int[] run2(int[] array1,int[] array2){
        int length1 = array1.length;
        int length2 = array2.length;

        int newLength = length1 + length2;
        int[] newArray = new int[newLength];

        int index1 = length1 - 1;
        int index2 = length2 - 1;
        for (int i = newLength - 1; i >= 0; i--) {
            if (index1 < 0){
                newArray[i] = array2[index2--];
            }else if(index2 < 0){
                newArray[i] = array1[index1--];
            }else if (array1[index1] > array2[index2]){
                newArray[i] = array1[index1--];
            }else {
                newArray[i] = array2[index2--];
            }

        }
        return newArray;
    }

    public static void main(String[] args) {
//        int[] array1 = {1,3,5,7};
//        int[] array2 = {};
//        int[] newArray = run2(array1,array2);
//        for (int i = 0; i < newArray.length; i++) {
//            System.out.println(newArray[i]);
//        }

        String string = "we are h";
        System.out.println(string.replace(" ","%20"));
    }
}
