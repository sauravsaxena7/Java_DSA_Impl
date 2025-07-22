package com.linked_list;

import com.linked_list.utils.Node;
import com.linked_list.utils.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 876. Middle of the Linked List
 Given the head of a singly linked list, return the middle node of the linked list.

 If there are two middle nodes, return the second middle node.


 Example 1:


 Input: head = [1,2,3,4,5]
 Output: [3,4,5]
 Explanation: The middle node of the list is node 3.
 Example 2:


 Input: head = [1,2,3,4,5,6]
 Output: [4,5,6]
 Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.


 Constraints:

 The number of nodes in the list is in the range [1, 100].
 1 <= Node.val <= 100

 */



public class Find_Middle_Of_The_Linked_List {

    public static Node middleNode(Node head) {
        int count;
        int length = 0;
        Node curr=head;
        while (curr!=null){
            length=length+1;
            curr=curr.next;
        }

        count = (length/2)+1;
        System.out.println("count::: "+count);

        int i=0;
        while(head!=null){
            i++;
            //System.out.print(i+", ");
            if(i==count){
                return head;
            }
            head=head.next;
        }

        return null;
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


        Node curr = Util.buildLinkedList(arr);
        curr=middleNode(curr);
        while (curr!=null){
            System.out.print(curr.val+" ");
            curr=curr.next;
        }

    }
}
