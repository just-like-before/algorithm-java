package com.algorithm.huffman;

public class HuffNode {

    private char ch;
    private int weight;
    private HuffNode left;
    private HuffNode right;

    public HuffNode(){

    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public HuffNode getLeft() {
        return left;
    }

    public void setLeft(HuffNode left) {
        this.left = left;
    }

    public HuffNode getRight() {
        return right;
    }

    public void setRight(HuffNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HuffNode{" +
                "ch=" + ch +
                ", weight=" + weight +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
