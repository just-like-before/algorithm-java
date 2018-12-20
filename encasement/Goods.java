package com.algorithm.encasement;

public class Goods {

    private int goodsN;
    private int goodsV;

    public Goods(){

    }

    public Goods(int goodsN, int goodsV) {
        this.goodsN = goodsN;
        this.goodsV = goodsV;
    }

    public int getGoodsN() {
        return goodsN;
    }

    public void setGoodsN(int goodsN) {
        this.goodsN = goodsN;
    }

    public int getGoodsV() {
        return goodsV;
    }

    public void setGoodsV(int goodsV) {
        this.goodsV = goodsV;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsN=" + goodsN +
                ", goodsV=" + goodsV +
                '}';
    }
}
