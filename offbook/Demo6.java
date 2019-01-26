package com.algorithm.offer.book;

import java.util.ArrayList;
import java.util.List;

/**
二叉树->二叉树的下一个节点
 */
public class Demo6 {

    public static class Tree{
        private int value;
        private Tree left;
        private Tree right;
        private Tree parent;

        public Tree(){

        }
    }

    /**
    构建一颗二叉树 节点有与左右子树和父节点有关系
     */
    public static Tree createTree(int[] array){
        Tree head = null;
        Tree p = null;
        for (int i = 0; i < array.length; i++) {
            Tree tree = new Tree();
            tree.value = array[i];
            tree.left = tree.right = tree.parent = null;
            if (head == null){
                p = head = tree;
            }else if (p.value > tree.value){
                p.left = tree;
                p.left.parent = p;
                p = p.left;
            }else {
                p.right = tree;
                p.right.parent = p;
                p = p.right;
            }
        }
        return head;
    }

    /**
     * 中序遍历
     * @param tree
     */
    public static void midPrint(Tree tree){
        if (tree != null){
            midPrint(tree.left);
            System.out.print(tree.value + ",");
            midPrint(tree.right);
        }
    }

    public static void main(String[] args) {
        int[] array = {3,2,5,8,4,7,6,9};
        Tree tree = createTree(array);
        midPrint(tree);
    }
}
