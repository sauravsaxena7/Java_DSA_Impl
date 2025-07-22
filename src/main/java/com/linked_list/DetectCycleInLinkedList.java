package com.linked_list;

import com.linked_list.utils.Node;
import com.linked_list.utils.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DetectCycleInLinkedList {

    public static  boolean hasCycle(Node head) {
        if(head==null||head.next==null){
            return false;
        }
        Node slow=head;
        Node fast =head;

        slow=slow.next;
        fast=fast.next;

        while(fast!=null){
            if(fast.next==null) return false;
            if(slow==fast.next){
                return true;
            }
            slow=slow.next;
            fast=fast.next.next;
        }

        return false;

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



        Node curr = Util.buildLinkedListWithCycle(arr);
        Node root = Util.buildLinkedList(arr);

        System.out.println("isCycleDetect curr::: "+hasCycle(curr));
        System.out.println("isCycleDetect root::: "+hasCycle(root));

    }
}
