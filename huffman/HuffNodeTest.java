package com.algorithm.huffman;

import java.util.*;

public class HuffNodeTest {

    public static void main(String[] args) {
        int i = 20;
        List<HuffNode> list = initForest(i);
        HuffNode hn = createHuffTree(list);
        printHuffTree(hn);
    }

    public static void printHuffTree(HuffNode root){
        if (root != null) {
            printHuffTree(root.getLeft());
            System.out.println(root.getCh()+"----->"+root.getWeight());
            printHuffTree(root.getRight());
        }
    }

    //初始化森林OK
    public static List<HuffNode> initForest(int i){
        List<HuffNode> list = new LinkedList<>();
        for(int j = 0;j < i;j++){
            HuffNode hn = new HuffNode();
            hn.setCh((char)(j+97));
            hn.setWeight(j+1);
            list.add(hn);
        }
        return list;
    }

    //创建二叉树
    public static HuffNode createHuffTree(List<HuffNode> list){
        int n = list.size();
        int k1,k2;
        HuffNode hn = null;
        for (int i = 0; i < n - 1; i++) {
            //找到最小和次小的第一个位置 其中这两个索引对应的节点不是空
            for(k1 = 0;k1 < n && list.get(k1) == null;k1++);
            for(k2 = k1 + 1;k2 < n && list.get(k2) == null;k2++);

            for(int j = k2;j < n;j++){
                if (list.get(j) != null){
                    if(list.get(j).getWeight() < list.get(k1).getWeight()){
                        k2 = k1;
                        k1 = j;
                    }else if(list.get(j).getWeight() < list.get(k2).getWeight()){
                        k2 = j;
                    }
                }
            }

            hn = new HuffNode();
            hn.setWeight(list.get(k1).getWeight());
            hn.setCh('x');
            hn.setLeft(list.get(k2));
            hn.setRight(list.get(k1));

            list.set(k1,hn);
            list.set(k2,null);
        }
        return hn;
    }
}
