package com.linked_list.utils;


public class Util {
    public static Node buildLinkedList(char[] arr){
        Node root =null;
        Node tail = null;

        for(char ele:arr){
            Node newNode = new Node(ele,null);
            if(root==null){
                root=newNode;
                tail=newNode;
            }else{
                tail.next=newNode;
                tail=newNode;
            }
        }
        return root;
    }

    public static Node buildLinkedListWithCycle(char[] arr){
        Node root =null;
        Node tail = null;

        for(char ele:arr){
            Node newNode = new Node(ele,null);
            if(root==null){
                root=newNode;
                tail=newNode;
            }else{
                tail.next=newNode;
                tail=newNode;
            }
        }
        tail.next=root;
        return root;
    }



}
