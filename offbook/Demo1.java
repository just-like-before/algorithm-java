package com.algorithm.offer.book;

//数组->数组找出重复的元素
public class Demo1 {

    /*
    在一个长度为n的数组里 所有的数字都是从0~n-1。数组中的某些数字是重复的
    但是不知道有哪些数字是重复的 而又不知道这些数字重复了多少次 找出数组中任意重复的数字
    如n=7 {2,3,1,0,2,5,3} 2 3
    方法一 创建一个数组 将原数组中数据的值与新数组的坐标相对应
    时间复杂度o(2n) 创建一个数组时所有的初始化值为0 所以先将数组的值初始化为-1
     */
    public static String run1(int[] array) {
        int length = array.length;
        int[] array2 = new int[length];
        for (int i = 0;i < length;i++){
            array2[i] = -1;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i :
                array) {
            if (i > 6 || i < 0){
                return "输入有误";
            }

            if (i != array2[i]){
                array2[i] = i;
            }else{
                stringBuffer.append(i+",");
            }

        }
        System.out.println(stringBuffer);
        return stringBuffer.substring(0,stringBuffer.length() - 1);
    }

    //降低空间复杂度 不去创建额外的数组
    //当数组中的数据不等于他的索引时 这个只是重复的
    /*
    思路 遍历数组 如果数组中的元素的值与他的索引不想对相应 就将这个元素 存放到与他的值相对应的索引进行交换
    这是如果他的值与索引相对应 并且他的索引不等于他的值 则这个数是重复的
    2,3,4,5,6,2,3->[4],3,[2],5,6,2,3......->2,3,2,4,5,6,3 输出2

     */
    public static void run2(int[] array){
        for (int i = 0; i < array.length; i++) {
            int cnt = array[i];
            if (cnt > array.length - 1 || cnt < 0){
                System.out.println("输出有误");
            }

            if(cnt != array[cnt]){
                int t = array[cnt];
                array[cnt] = cnt;
                array[i] = t;
                i--;
            }else if(i != cnt){
                System.out.println(cnt+"重复");
            }
        }
    }

    public static void main(String[] args) {

        int[] array = {2,3,4,5,6,2,3};
        run2(array);
        int[] array1 = {2,3,4,5,6,2,3};
        assert "2,3".equals(run1(array1)):"array1错误";
        System.out.println("array1-->OK");

        int[] array2 = {2,3,4,5,6,7,8};
        assert "".equals(run1(array2)):"array2错误";
        System.out.println("array2-->OK");

        int[] array3 = {0,0,0,0,0,0,0};
        assert "0".equals(run1(array3)):"array3错误";
        System.out.println("array3-->OK");
    }
}
