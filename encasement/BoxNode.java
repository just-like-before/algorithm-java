package com.algorithm.encasement;

public class BoxNode {

    private GoodsNode goodsNode;
    private int boxV;
    private BoxNode boxNodeNext;

    public BoxNode(){

    }

    public BoxNode(GoodsNode goodsNode, int boxV) {
        this.goodsNode = goodsNode;
        this.boxV = boxV;
    }

    public GoodsNode getGoodsNode() {
        return goodsNode;
    }

    public void setGoodsNode(GoodsNode goodsNode) {
        this.goodsNode = goodsNode;
    }

    public int getBoxV() {
        return boxV;
    }

    public void setBoxV(int boxV) {
        this.boxV = boxV;
    }

    public BoxNode getBoxNodeNext() {
        return boxNodeNext;
    }

    public void setBoxNodeNext(BoxNode boxNodeNext) {
        this.boxNodeNext = boxNodeNext;
    }

    @Override
    public String toString() {
        return "BoxNode{" +
                "goodsNode=" + goodsNode +
                ", boxV=" + boxV +
                '}';
    }
}
