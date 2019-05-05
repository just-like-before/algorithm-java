package com.algorithm.offer.leetcode1;

import java.util.*;

/**
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * 说明：
 *
 *     所有输入均为小写字母。
 *     不考虑答案输出的顺序。
 */
public class Exercise49 {

    public static void main(String[] args) {
        String[] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strings);
        for (int i = 0;i < lists.size();i++){
            List<String> list = lists.get(i);
            for (int j = 0;j < list.size();j++){
                System.out.print(list.get(j) + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 进行数组的一次遍历 同时进行数组中每一个元素的排序
     * 在使用HashMap进行元素去重
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        HashMap<String,Integer> hashMap = new HashMap<>();
        //HashMap中应该加入的索引 当元素第二次出现 将这个元素直接加入 此索引的list集合中
        int cnt = 0;
        for (int i = 0;i < strs.length;i++){
            //转化为char[] 进行排序
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            //排序直接在封装为一个s 然后进行比较
            String s = new String(chars);
            if (hashMap.containsKey(s)){
                //之前hashMap中有这个元素 得到索引进行添加
                int index = hashMap.get(s);
                lists.get(index).add(strs[i]);
            }else {
                //没有先添加到hashMap中 然后在新建一个list 最后加入到lists中
                hashMap.put(s,cnt++);
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                lists.add(list);
            }
        }
        return lists;
    }
}
