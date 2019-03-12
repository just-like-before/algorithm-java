package com.algorithm.recall;

import com.algorithm.tree.Test1;
import com.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
* 二叉树叶子节点到很节点的路径
*/
public class ReCall3 {

    public static void main(String[] args) {
        int[] a = {30,2,5,8,6,1,4,12,98,45,100,0};
        //int[] a = {30,2,98};
        TreeNode treeNode = Test1.createTree(a);
        int target = 6;
        List<Integer> list = new ArrayList<>();
        //print(treeNode);
        printToRoot(treeNode,list,target);
    }

    public static void print(TreeNode treeNode){
        if (treeNode != null){
            System.out.println(treeNode.getValue());
            print(treeNode.getLeft());
            print(treeNode.getRight());
        }
    }

    /**
     * 使用list集合作为一个逻辑上的栈
     * @param treeNode
     * @param list
     * @param target
     */
    public static void printToRoot(TreeNode treeNode, List<Integer> list,int target){
        if (treeNode != null){
            //将遍历的二叉树的节点值加入使用list集合创建的逻辑栈
            list.add(treeNode.getValue());
            if (treeNode.getValue() == target){
                for (int i = list.size() - 1;i > -1;i--)
                    System.out.println(list.get(i));
            }

            printToRoot(treeNode.getLeft(),list,target);

            /**
             * 进行回溯删除加入list集合中 不需要的二叉树的值
             *
             * 当走到这里的时候 说明是要进行对叶子节点的判断
             * 对叶子节点进行判断 叶子节点的左右为null 所以直接出栈
             * 但是这时不能删除叶子节点 只能等到回溯到叶子节点的父节点的时候在进行删除
             * 然后就会进行 父节点的右遍历
             */
            if (list.size() > 0 && treeNode.getLeft() != null)
                list.remove(list.size() - 1);

            printToRoot(treeNode.getRight(),list,target);
            if (list.size() > 0 && treeNode.getRight() != null)
                list.remove(list.size() - 1);
        }
    }
}
