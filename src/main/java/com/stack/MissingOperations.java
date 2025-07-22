package com.stack;

import com.stack.utils.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**

 Write a function find Missing Operationindex (ops: List[str]), missingOp: str, currentTop: int) int that
 returns the 0-based index at which a missing stack operation should be inserted into a sequence of

 Operations.

 Parameters:
 ⚫n: Number of elements in the ops list
 ops: List of strings, each representing a stack operation ("PUSH x" or "POP").
 missingOp: String, the operation ("PUSH x" or "POP") that is missing from ops.
 currentTop: Integer, the value that should be on top of the stack after all operations

 Notes:
 • The missingOp will be a string formatted as "PUSH x" (where x is an integer) or "POP"

 The function should return an integer representing the index where the missing operation inserted.
 • It is guaranteed that there is at least one valid insertion index.

 • If multiple indices can lead to the correct outcome, return the lowest index.

 • A POP operation is not permitted when the stack is empty.

 Use an array/list to simulate stack behavior. Add and remove elements only from the

 Example 1
 Input:
 n = 5
 ops = PUSH 1, PUSH 2, PUSH 3, POP, POP


 INPUT:
 2
 PUSH1,PUSH2,PUSH3,POP,POP
 PUSH4
 output should be 2

 */



public class MissingOperations {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read input line
        String line = br.readLine().trim();  // e.g., "10 20 30 40"

        int topItem = Integer.parseInt(line);

        // Split and parse into int array
        line= br.readLine();
        String [] operations = line.trim().split(",");


        line = br.readLine().trim();
        String missingOps= line.trim();

        System.out.println("operations:::  "+ Arrays.toString(operations));

        System.out.println("Operation at index:: "+findMissingOperations(operations,missingOps,topItem));

    }

    private static int findMissingOperations(String[] operations, String missingOps, int topItem) throws Exception {
        Stack<String> stack = new Stack<>(-1);

        //calculate size of push operations referring size of stack
        int size=0;
        if(missingOps.startsWith("PUSH")) size=1;
        for(String ops:operations){
            if(ops.startsWith("PUSH")){
                ++size;
            }
        }

        System.out.println("Calculated Stack size::: "+size);

        //operation flow as per given operation
        //to find how many operation needed to achieve top element
        String topItemWithOps ="PUSH"  + topItem;

        String[] newStackItem = new String[size];
        int topItemIndex = -1;
        for(int i=0;i<operations.length;i++){
            if(operations[i].startsWith("PUSH")){
                stack.push(newStackItem,operations[i],size);
            }else {
                stack.pop(newStackItem);
            }
            if(operations[i].equals(topItemWithOps)){
                topItemIndex=i;
            }
        }

        int indexAtOperation=Math.abs(stack.getTop()-topItemIndex);
        System.out.println("required operation at index+1 is:: "+indexAtOperation);

        stack = new Stack<>(-1);
        newStackItem = new String[size];

        int i=0,j=0;
        while(indexAtOperation>0 && j<operations.length){
            if((indexAtOperation+1)==i){
                if(missingOps.startsWith("PUSH")){
                    stack.push(newStackItem,missingOps,size);
                }else {
                    stack.pop(newStackItem);
                }
            }else {
                if(operations[j].startsWith("PUSH")){
                    stack.push(newStackItem,operations[j],size);
                }else {
                    stack.pop(newStackItem);
                }
                j++;
            }
            i++;
            System.out.println("j::: "+j+" "+Arrays.toString(newStackItem));

        }

        if(operations[stack.getTop()].equals(topItemWithOps)){
            return indexAtOperation+1;
        }

        return -1;


    }
}
