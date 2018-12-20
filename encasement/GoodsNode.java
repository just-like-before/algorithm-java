package com.algorithm.encasement;

public class GoodsNode {

    private Goods goods;
    private GoodsNode goodsNext;

    public GoodsNode(){

    }

    public GoodsNode(Goods goods, GoodsNode goodsNext) {
        this.goods = goods;
        this.goodsNext = goodsNext;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public GoodsNode getGoodsNext() {
        return goodsNext;
    }

    public void setGoodsNext(GoodsNode goodsNext) {
        this.goodsNext = goodsNext;
    }

    @Override
    public String toString() {
        return "GoodsNode{" +
                "goods=" + goods +
                ", goodsNext=" + goodsNext +
                '}';
    }
}
