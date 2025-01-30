package Graphs;

import java.util.ArrayList;

public class Concepts {
    //graph representation using adjacency matrix
    public static void main(String[] args) {
        int n = 3;
        int m = 3;

        int adj[][] = new int[n+1][n+1];

        adj[1][2] = 1;
        adj[2][1] = 1;

        adj[3][2] = 1;
        adj[2][3] = 1;

        //in general for u and v
        // adj[u][v] = 1;
        // adj[v][u] = 1;
        //for undirected graph

        ArrayList<ArrayList<Integer>> adjlist = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            adjlist.add(new ArrayList<Integer>()); // creating empty arraylist for each node
        }
        //adding edges
        adjlist.get(1).add(2);
        adjlist.get(2).add(1);

        //in general for any given vertex u and v of an undirected graph
        // adjlist.get(u).add(v);
        // adjlist.get(v).add(u);

        //printing all the edges
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < adjlist.get(i).size(); j++) {
                System.out.println(adjlist.get(i).get(j)+" ");
            }
            System.out.println();
        }

        ///for graphs having weights for each edge we can assign the weight value for in the matrix adj[u][v] = weight and tweek the datastructure of adjacency list a bit to store like this : {1: {{2,3}, {4,1}, {5,7}}}
    }
    
}
