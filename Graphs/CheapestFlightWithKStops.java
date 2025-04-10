package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightWithKStops {
    public static int cheapestFlight(int n, int flights[][], int src, int dst, int K) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        //creating the adjacency list to depict airports and flights in the form of a graph
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i=0;i<m;i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));

        int dist[] = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int)(1e9);
        }
        dist[src] = 0;

        while(!q.isEmpty()) {
            Tuple it = q.peek();
            q.remove();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            if(stops > K) continue;
            for(Pair iter: adj.get(node)){
                int adjNode = iter.first;
                int edW = iter.second;

                if(cost+edW < dist[adjNode] && stops <= K) {
                    dist[adjNode] = cost+edW;
                    q.add(new Tuple(stops+1, adjNode, cost+edW));
                }
            }
        }
        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];
    }
    public static void main(String[] args) {
       
        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

        int ans = cheapestFlight(n,flights,src,dst,K);
        
        System.out.print(ans);
        System.out.println();
    }
}

class Pair{
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Tuple {
    int first, second, third;
    Tuple(int ft, int st, int th) {
        this.first = ft;
        this.second = st;
        this.third = th;
    }
}
