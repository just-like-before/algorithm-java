package com.algorithm.offer.book;

import java.util.Arrays;

//二叉树-> 重建二叉树
public class Demo5 {

    //二叉树的结构
    public static class Tree{
        private int value;
        private Tree left;
        private Tree right;

        public Tree(){

        }
    }

    /*
    输入二叉树前序遍历和中序遍历的结果 重建二叉树
    输出它的后续遍历结果 假设前序遍历和中序遍历没有重复的值
    思路 前序遍历的第一个节点是二叉树的根 然后在中序以根为节点 分别找出它的左右子树
    这个左子树也可以看做是一个二叉树 对这个二叉树 进行递归 传入它的前中序的遍历
    重复上面的过程 采用递归实现
     */
    public static Tree run1(int[] array1,int[] array2){
        int length1 = array1.length;
        int length2 = array2.length;
        if (length1 == 0 || length2 == 0 || length1 != length2){
            return null;
        }

        int root = array1[0];
        Tree tree = new Tree();
        tree.value = root;
        tree.left = tree.right = null;

        for (int i = 0; i < length2; i++) {
            if (root == array2[i]){
                tree.left = run1(
                        Arrays.copyOfRange(array1,1,i + 1),Arrays.copyOfRange(array2,0,i));
                tree.right = run1(
                        Arrays.copyOfRange(array1,i + 1,length1),Arrays.copyOfRange(array2,i + 1,length2));

            }
        }
        return tree;
    }

    //前序遍历
    public static void proPrint(Tree tree){
        if (tree != null){
            System.out.println(tree.value);
            proPrint(tree.left);
            proPrint(tree.right);
        }
    }

    public static void main(String[] args) {
        int[] array1 = {1,2,4,7,3,5,6,8};
        int[] array2 = {4,7,2,1,5,3,6,8};
        Tree tree = run1(array1,array2);
        proPrint(tree);
    }
}
