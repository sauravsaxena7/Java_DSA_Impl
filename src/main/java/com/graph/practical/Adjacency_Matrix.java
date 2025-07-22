package com.graph.practical;

import java.util.ArrayList;
import java.util.List;

public class Adjacency_Matrix {


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

        int[][] adjacency_matrix = new int[edgeList.size()][edgeList.size()];

        for(int i=0;i<edgeList.size();i++){

            //un-directed graph

            int a = edgeList.get(i).get(0);
            int b = edgeList.get(i).get(1);

            adjacency_matrix[a][b]=1;
            adjacency_matrix[b][a]=1;

        }

        for (int i=0;i<edgeList.size();i++){
            System.out.print("Node: "+i+", Neighbours: ");
            for (int j=0;j<edgeList.size();j++){
                if(adjacency_matrix[i][j]==1) System.out.print(j+" ");
            }
            System.out.println();
        }

        for (int i=0;i<edgeList.size();i++){
            for (int j=0;j<edgeList.size();j++){
                System.out.print(adjacency_matrix[i][j]+" ");
            }
            System.out.println();
        }


    }
}
