package com.algorithm.offer.leetcode1;

import java.util.ArrayList;
import java.util.List;

public class Exercise17 {

    public static void main(String[] args) {
        letterCombinations("23").forEach(System.out::println);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return list;
        }
        String[] strs = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        //得到目标字符数组
        String[] target = new String[digits.length()];
        for (int i = 0;i < digits.length();i++){
            target[i] = strs[Integer.parseInt(digits.substring(i,i+1)) - 1];
        }

        recall(target,new StringBuffer(),list,0);
        return list;
    }

    /**
     * 进行回溯
     * @param digits
     * @param stringBuffer
     * @param list
     * @param cnt
     */
    public static void recall(String[] digits,StringBuffer stringBuffer,List<String> list,int cnt){
        //两个加入集合中
        if (stringBuffer.length() == digits.length){
            list.add(stringBuffer.toString());
            return;
        }

        for (int i = 0;i < digits[cnt].length();i++){
            stringBuffer.append(digits[cnt++].charAt(i));
            recall(digits,stringBuffer,list,cnt);
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            cnt--;
        }
    }
}
