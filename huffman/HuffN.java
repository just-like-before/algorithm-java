package com.algorithm.huffman;

public class HuffN {

    private int weight;
    private char ch;
    private int parent;
    private int left;
    private int right;
    private String code;

    public HuffN(){

    }

    public HuffN(int weight, char ch, int parent, int left, int right, String code) {
        this.weight = weight;
        this.ch = ch;
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.code = code;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "HuffN{" +
                "weight=" + weight +
                ", ch=" + ch +
                ", parent=" + parent +
                ", left=" + left +
                ", right=" + right +
                ", code='" + code + '\'' +
                '}';
    }
}
