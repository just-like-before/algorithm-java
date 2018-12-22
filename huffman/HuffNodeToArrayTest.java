package com.algorithm.huffman;

public class HuffNodeToArrayTest {

    public static void main(String[] args) {
        int i = 20;
        int cnt = 2 * i - 1;
        HuffN[] huffNS = new HuffN[cnt];
        for (int j = 0; j < cnt; j++) {
            HuffN hn = new HuffN();
            huffNS[j] = hn;
        }
        huffNS = initHuffArray(huffNS,i);
        huffNS = fillHuffArray(huffNS,i);
        System.out.println("值\t"+"权值\t"+"左子女\t"+"右子女\t"+"双亲\t");
        for (int j = 0; j < huffNS.length; j++) {
            System.out.println(huffNS[j].getCh()+"\t"+huffNS[j].getWeight()+"\t"+huffNS[j].getLeft()+"\t"+huffNS[j].getRight()
            +"\t"+huffNS[j].getParent());
        }
    }

    public static HuffN[] initHuffArray(HuffN[] huffNS,int i){
        for (int j = 0;j < i;j++){
            HuffN hn = new HuffN();
            hn.setCh((char)(j+97));
            hn.setWeight(j+1);
            hn.setParent(-1);
            hn.setCode(null);
            hn.setLeft(-1);
            hn.setRight(-1);
            huffNS[j] = hn;
        }
        return huffNS;
    }

    public static HuffN[] fillHuffArray(HuffN[] huffNS,int i){
        int cnt = i - 1;
        int k1,k2;
        for (int j = 0; j < cnt; j++) {
            int c = i + j;
            for (k1 = 0;k1 < c && huffNS[k1].getParent() != -1;k1++);
            for (k2 = k1 + 1;k2 < c && huffNS[k2].getParent() != -1;k2++);

            int k;
            for (k = k2;k < c;k++){
                if(huffNS[k].getParent() == -1){
                    if (huffNS[k].getWeight() < huffNS[k1].getWeight()) {
                        k2 = k1;
                        k1 = k;
                    } else if (huffNS[k].getWeight() < huffNS[k2].getWeight()) {
                        k2 = k;
                    }
                }
            }

            HuffN hn = new HuffN();
            hn.setCode(null);
            hn.setCh('x');
            hn.setWeight(huffNS[k2].getWeight());
            hn.setLeft(k1);
            hn.setRight(k2);
            hn.setParent(-1);

            huffNS[k1].setParent(k);
            huffNS[k2].setParent(k);

            huffNS[k] = hn;
        }
        return huffNS;
    }
}
