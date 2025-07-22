package com.linked_list;

import com.linked_list.utils.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class ReverseLinkedList {

    public static Node reverseList(Node head) {
        if(head==null) return null;
        Node prev=null;
        Node curr = head;
        Node next = null;

        while(curr.next!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        curr.next=prev;
        head=curr;
        return head;
     }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read input line
        String line = br.readLine();  // e.g., "10 20 30 40"

        // Split and parse into int array
        char[] arr = Arrays.stream(line.trim().split("\\s+"))        // Stream<String>
                .flatMapToInt(String::chars)              // Stream<Int> of characters
                .mapToObj(c -> (char) c)                  // Stream<Character>
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString()
                .toCharArray();
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
        Node curr = reverseList(root);
        while (curr!=null){
            System.out.print(curr.val+" ");
            curr=curr.next;
        }

    }
}
