package com.algorithm.tree;

import java.util.LinkedList;

public class Test1 {

    public static void main(String[] args) {
        int[] array = {3,2,5,8,6,7,10,12,98,45,65,32};
        TreeNode root = createTree(array);
        printTree(root);
    }

    //创建 查找树
    public static TreeNode createTree(int[] array){
        TreeNode head = null;
        TreeNode tp,tt = null;
        for (int i = 0; i < array.length; i++) {
            TreeNode tn = new TreeNode();
            tn.setValue(array[i]);
            tp = head;
            while (tp != null){
                tt = tp;
                if(tp.getValue() > tn.getValue()){
                    tp = tp.getLeft();
                }else{
                    tp = tp.getRight();
                }

            }
            if(head == null){
                head = tn;
            }else {
                if (tt.getValue() > tn.getValue()) {
                    tt.setLeft(tn);
                } else {
                    tt.setRight(tn);
                }
            }
        }
        return head;
    }

    //递归遍历树 中序遍历
    public static void printTree(TreeNode root){
        if(root != null){
            printTree(root.getLeft());
            System.out.println(root.getValue());
            printTree(root.getRight());
        }
    }
}
