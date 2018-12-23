package com.algorithm.link;

public class Test {

    public static void main(String[] args) {
        int[] array = {3,2,5,8,4,7,6,9};
        Node root;
        //root = createLinkToTail(array);
        root = createLinkToHead(array);
        printLink(root);
    }

    //创建
    public static Node createLinkToTail(int[] array){
        Node head = null,tail = null,p;
        for (int i = 0; i < array.length; i++) {
            p = new Node(array[i]);
            if(head == null){
                tail = head = p;
            }else{
                tail.setNext(p);
                tail = tail.getNext();
            }
        }
        return head;
    }

    //遍历
    public  static void printLink(Node root){
        Node p = null;
        for(p = root;p != null;p = p.getNext()){
            System.out.println(p.getValue());
        }
    }

    //创建 方式二
    public static Node createLinkToHead(int[] array){
        Node p = null;
        Node head = null;
        for(int i = 0;i < array.length;i++){
            p = new Node();
            p.setValue(array[i]);
            p.setNext(head);
            head = p;
        }
        return head;
    }
}
