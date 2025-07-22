package com.graph.practical;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adjacency_List {

    public static void main(String[] args){

        ArrayList<ArrayList<Integer>> edgeList =new ArrayList<>(
                List.of(
                        new ArrayList<>(List.of(1, 2)),
                        new ArrayList<>(List.of(2, 3)),
                        new ArrayList<>(List.of(3, 4)),
                        new ArrayList<>(List.of(4,2)),
                        new ArrayList<>(List.of(1,3))
                )
        );


        Map<Integer,ArrayList<Integer>> adjacency_list=new HashMap<>();

        for(List<Integer> edges : edgeList){

            //un-directed graph

            int a = edges.get(0);
            int b = edges.get(1);

            // add b to a’s adjacency list
            adjacency_list.computeIfAbsent(a, k -> new ArrayList<>())
                    .add(b);

            // add a to b’s adjacency list   (undirected graph)
            adjacency_list
                    .computeIfAbsent(b, k -> new ArrayList<>())
                    .add(a);

        }


        for(Map.Entry<Integer,ArrayList<Integer>>
                entry:adjacency_list.entrySet()){

            System.out.print("Node: "+entry.getKey()+", Neighbours: ");
            for (Integer l:entry.getValue()){
                System.out.print(l+" ");
            }
            System.out.println();

        }



    }
}
