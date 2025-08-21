import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUndirectedGraph {
    /*
    Shortest path in undirected graph

    you are given an undirected graph having unit weight, find the shortest distance from src to all the points, if path is not possible then put -1

    apply plain bfs algo

    queue data structure

    first store (0,0) since src = 0 and distance = 0 , hence we insert (0,0)

    declare a dist array of Vertices size
    fill it with infinity

    remove from the queue till its empty : 

    initially node = 0, dist = 0

    it can go to node 1 , node 3 (from adj list) -> dist = 0+1 = 1
    check distance array , if the distance is less then update it (Math.min)

    put the node = 1, dist = 1 in queue and node = 3 , dist = 1 in the queue


    node = 1 and dist = 1

    we can reach node = 0 , 2 , 3
    node = 0 , dist = 2 -> not accepted 
    node = 2, dist = 2 -> accepted -> distance array updated and put it in the queue
    node = 3 , dist = 2 -> not accepted

    if any node would have unreachable then it would have stored inf

     */

    public static void main(String[] args) {
        int[][] edges = {
            {0,1},
            {0,3},
            {3,4},
            {4,5},
            {5,6},
            {1,2},
            {2,6},
            {6,7},
            {7,8},
            {6,8}
        };
        int n = 9; // number of nodes
        int m = edges.length;    

        int res[] = shortestPath(edges, n, m , 0);
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]+" ");
        }
        System.out.println();
    }
    private static int[] shortestPath(int [][] edges, int n, int m, int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int dist[] = new int[n];
        for(int i=0;i<n;i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while(!q.isEmpty()) {
            int node = q.remove();
            for(int it: adj.get(node)) {
                if(dist[node] + 1 < dist[it]) {
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }
        for(int i=0;i<n;i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}
