package com.graph.practical;

import java.util.*;

public class BFS {

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> edgeList =new ArrayList<>(
                List.of(
                        new ArrayList<>(List.of(0, 1)),
                        new ArrayList<>(List.of(0, 5)),
                        new ArrayList<>(List.of(0, 2)),
                        new ArrayList<>(List.of(2, 3)),
                        new ArrayList<>(List.of(3, 4))
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

        List<Integer> result = bfs(0,adjacency_list,6);
        System.out.println(result);
    }

    private static List<Integer> bfs(int source, Map<Integer, ArrayList<Integer>> adjacencyList, int n) {
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] vis = new boolean[n];

        q.offer(source);

        vis[source]=true;

        while(!q.isEmpty()){
            int cur = q.poll();
            result.add(cur);
            //push all it's neighbours
            for(Integer x:adjacencyList.get(cur)){
                if(!vis[x]){
                    q.offer(x);
                    vis[x]=true;
                }
            }
        }
        return result;
    }
}
