package com.test.encasement;

public class HuffToArray {

    public static void main(String[] args) {
        int nodeNum = 26;
        HuffNode[] huffNodes = new HuffNode[nodeNum * 2 - 1];
        for (int i = 0;i < nodeNum;i++){
            HuffNode huffNode = new HuffNode();
            huffNode.value = nodeNum - i;
            huffNode.ch = (char) (i + 97);
            huffNode.left = huffNode.right = huffNode.parent = -1;
            huffNode.code = null;
            huffNodes[i] = huffNode;
        }

        createHuffTree(huffNodes,nodeNum);
        codeHuffTree(huffNodes,nodeNum);
        printHuffTree(huffNodes);
    }

    public static void printHuffTree(HuffNode[] huffNodes){
        for (int i = 0;i < huffNodes.length;i++){
            System.out.println(huffNodes[i].ch + "--" + huffNodes[i].value + "--" + huffNodes[i].left + "--"
                    + huffNodes[i].right + "--" + huffNodes[i].parent + "--" + huffNodes[i].code);
        }
    }

    public static void codeHuffTree(HuffNode[] huffNodes,int n){
        StringBuffer stringBuffer = null;
        HuffNode huffNode;
        for (int i = 0;i < n;i++){
            stringBuffer = new StringBuffer();
            huffNode = huffNodes[i];
            do {
                huffNode = huffNodes[huffNode.parent];
                if (huffNode.left == i)
                    stringBuffer.append("0");
                else
                    stringBuffer.append("1");
            }while (huffNode.parent != -1);

            huffNodes[i].code = stringBuffer.reverse().toString();
        }
    }

    public static void createHuffTree(HuffNode[] huffNodes,int n){
        int k0,k1,index;
        for (int i = 0;i < n - 1;i++){
            //找到parent==-1的最小和次小的开始位置
            for (k0 = 0;k0 < n + i && huffNodes[k0].parent != -1;k0++);

            for (k1 = k0 + 1;k1 < n + i && huffNodes[k1].parent != -1;k1++);

            //找到parent==-1的最小的次小的位置
            for (index = k1;index < n + i;index++){
                if (huffNodes[index].parent == -1) {
                    if (huffNodes[index].value < huffNodes[k0].value) {
                        k1 = k0;
                        k0 = index;
                    }else if(huffNodes[index].value < huffNodes[k1].value){
                        k1 = index;
                    }
                }
            }

            //创建节点 ch='x' left=k1 rigth=k0 parent=-1
            HuffNode huffNode = new HuffNode();
            huffNode.parent = -1;
            huffNode.value = huffNodes[k1].value;
            huffNode.left = k1;
            huffNode.right = k0;
            huffNode.code = null;
            huffNodes[n + i] = huffNode;

            //找到的两个节点的父节点更新
            huffNodes[k0].parent = huffNodes[k1].parent = n + i;
        }
    }

    static class HuffNode{
        int value;
        char ch;
        int left;
        int right;
        int parent;
        String code;
    }
}
