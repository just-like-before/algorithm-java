package com.algorithm.offer.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Z字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Exercise6 {

    public static void main(String[] args) {
        System.out.println(convert("LEE",4));
    }

    public static String convert(String s, int numRows) {
        if (s == null || s.length() < 1){
            return "";
        }

        if (numRows == 1){
            return s;
        }
        //控制方向--控制cnt-- 或cnt++
        boolean bool = false;
        int cnt = 0;
        List<StringBuffer> list = new ArrayList<>();
        for (int j = 0;j < numRows;j++){
            list.add(new StringBuffer());
        }
        for (int i = 0;i < s.length();i++){

            list.get(cnt).append(s.charAt(i));

            if (cnt == 0 || cnt == numRows - 1)
                bool = !bool;

            cnt += bool ? 1:-1;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0;i < list.size();i++)
            stringBuffer.append(list.get(i));
        return stringBuffer.toString();
    }
}
