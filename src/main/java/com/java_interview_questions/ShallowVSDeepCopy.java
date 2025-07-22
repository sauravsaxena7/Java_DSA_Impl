package com.java_interview_questions;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car{
    String name;
    ArrayList<String> colors;

    public Car(String name, ArrayList<String> colors){
        this.name=name;
        this.colors=colors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", colors=" + colors +
                '}';
    }
}

public class ShallowVSDeepCopy {
//    public static void main(String[] args){
//        ArrayList<String> hondaColors = new ArrayList<>();
//        hondaColors.add("blue");
//        hondaColors.add("yellow");
//
//        //now making objects of car;
//        Car honda = new Car("HONDA",hondaColors);
//
//
//        System.out.println("before shallow copy of honda object " +
//                "with no hindrance in object honda::: "+ honda);
//
//        System.out.println("shallow copy operation");
//        Car hondaShallowCopy = honda;
//        hondaShallowCopy.name="HONDA_UPDATED";
//        hondaShallowCopy.colors.add("red");
//        hondaShallowCopy.colors.add("green");
//
//        System.out.println("After shallow copy of honda object " +
//                "with hindrance in object honda::: "+ honda);
//
//        System.out.println("Deep copy operations");
//        Car deepCopyOfHonda = new
//                Car(honda.name,new ArrayList<>(honda.colors));
//
//        //updating deep copy honda
//        deepCopyOfHonda.name="HONDA_DEEP_COPY";
//        deepCopyOfHonda.colors.add("SUN DEEP COPY COLOR");
//
//        System.out.println("After deep copy of honda is deepCopyOfHonda::: "+deepCopyOfHonda);
//        System.out.println("After deep copy of honda is honda::: "+honda);
//
//
//
//
//
//
//
//    }


    // Candidate function
    public static int findMissingOperationIndex(List<String> ops, String missingOp, int currentTop) {
        // Write your code here


        int push=0;
        int pop=0;
        for(String op:ops){
            if(op.startsWith("PUSH")){
                push=push+1;
            }else{
                pop=pop+1;
            }
        }



        int index=0,cal=-1;
        for(String op:ops){

        }


        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input from stdin
        int n = Integer.parseInt(scanner.nextLine());
        List<String> ops = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ops.add(scanner.nextLine());
        }
        String missingOp = scanner.nextLine();
        int currentTop = Integer.parseInt(scanner.nextLine());

        // Call the candidate function
        int result = findMissingOperationIndex(ops, missingOp, currentTop);

        // Print result
        System.out.println(result);
    }
}
