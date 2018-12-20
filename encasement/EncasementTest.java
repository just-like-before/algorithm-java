package com.algorithm.encasement;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EncasementTest {

    public static void main(String[] args) {

        List<Goods> goodsList = initGoods();
//        for (int i = 0; i < goodsList.size(); i++) {
//            System.out.println(goodsList.get(i).getGoodsV()+"-->"+goodsList.get(i).getGoodsN());
//        }
        BoxNode bn = encasement(goodsList);
        //printLink(bn);
        printBox(bn);
    }

    //遍历
    public  static void printLink(BoxNode root){
        BoxNode p = null;
        for(p = root;p != null;p = p.getBoxNodeNext()){
            System.out.println(p.getBoxV());
        }
    }

    public static void printBox(BoxNode root){
        GoodsNode goodsHead,gn;
        int index = 0;
        while(root != null){
            goodsHead = root.getGoodsNode();
            System.out.print("箱子编号:+\t");
            index++;
            System.out.println("------->"+index+"-----------<");
            while (goodsHead != null) {
                System.out.print(goodsHead.getGoods().getGoodsV()+"\t");
                goodsHead = goodsHead.getGoodsNext();
            }
            root = root.getBoxNodeNext();
            System.out.println();
        }
    }

    //装箱
    public static BoxNode encasement(List<Goods> goodsList){
        BoxNode bn,boxHead = null,boxTail = null;
        GoodsNode gn,goodsHead = null,goodTail;
        Goods goods;
        for (int i = 0; i < goodsList.size(); i++) {
            goods = goodsList.get(i);

            for (bn = boxHead;bn != null && bn.getBoxV() < goods.getGoodsV();bn = bn.getBoxNodeNext());

            if (bn == null) {
                bn = new BoxNode();
                bn.setBoxV(60);

                if (boxHead == null) {
                    boxTail = boxHead = bn;
                }else{
                    boxTail.setBoxNodeNext(bn);
                    boxTail = boxTail.getBoxNodeNext();
                }
            }

            for(goodTail = goodsHead,goodsHead = bn.getGoodsNode();goodsHead != null;goodTail = goodsHead,goodsHead = goodsHead.getGoodsNext());

            if (goodTail == null) {
                goodTail = new GoodsNode();
                goodTail.setGoods(goods);
                bn.setGoodsNode(goodTail);
            }else{
                goodsHead = new GoodsNode();
                goodsHead.setGoods(goods);
                goodTail.setGoodsNext(goodsHead);
            }
            bn.setBoxV(bn.getBoxV() - goods.getGoodsV());
        }
        return boxHead;
    }

    //初始化物品
    public static List<Goods> initGoods(){
        List<Goods> goodsList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Goods g = new Goods();
            g.setGoodsN(i+1);
            g.setGoodsV(50-i);
            goodsList.add(g);
        }
        return goodsList;
    }
}
