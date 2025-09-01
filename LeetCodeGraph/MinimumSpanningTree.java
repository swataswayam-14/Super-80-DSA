import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinimumSpanningTree {
    static class Pair {
        int node, weight;
        Pair(int node , int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //adjacency list: graph[u] = list of (v, weight) 
        // u is connected to v with a weight 

        List<List<Pair>> graph = new ArrayList<>();

        for(int i=0;i<=n;i++) graph.add(new ArrayList<>());

        for(int i=0;i<m;i++) { // in the input there would be given m number of edges
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w)); // undirected
        }
        //prims algorithm
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight)); //min heap

        pq.add(new Pair(1, 0));
        int mstWeight = 0;

        while(!pq.isEmpty()) {
            Pair curr = pq.remove();
            if(visited[curr.node]) continue;

            visited[curr.node] = true;
            mstWeight += curr.weight;

            for(Pair neighbor: graph.get(curr.node)) {
                if(!visited[neighbor.node]) {
                    pq.add(new Pair(neighbor.node, neighbor.weight));
                }
            }
        }
        System.out.println(mstWeight);
    }
}

/*
A tree in which we have N nodes and N-1 edges and all nodes are reachable from each other.


there can be multiple spanning tree (just a tree in which all nodes are connected) , we have to pick the spanning tree whose sum of edge weights in minimal


Prims Algorithm : helps us to find the MST

-> Priority Queue
-> Visited Array

pq (wt, node, parent) (min heap)

visited[] -> unvisited for all (mark 0)

pq -> (0,0,-1)

while(!pq.isEmpty()) 

0,0,-1 -> first node is 0 vis[0] = 1

adjacent nodes of 0 is 1 , 2
put (2,1,0) in pq

put (1,2,0) in pq 

(1,2,0)

put (0,2) in the mst empty arraylist and sum = 0 + 1 (edge weight) = 1

vis[2] = 1 
 */
