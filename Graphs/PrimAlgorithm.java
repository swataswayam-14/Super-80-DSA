package Graphs;

import java.util.*;

public class PrimAlgorithm {
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        boolean[] visited = new boolean[V];
        pq.add(new Pair(0, 0)); // Start with node 0 and weight 0
        int sum = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int wt = current.distance;
            int node = current.node;

            if (visited[node]) continue;
            visited[node] = true;
            sum += wt;

            for (ArrayList<Integer> edge : adj.get(node)) {
                int adjNode = edge.get(0);
                int edW = edge.get(1);
                if (!visited[adjNode]) {
                    pq.add(new Pair(edW, adjNode));
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        int[][] edges = {
            {0, 1, 2}, {0, 2, 1}, {1, 2, 1},
            {2, 3, 2}, {3, 4, 1}, {4, 2, 2}
        };

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];

            adj.get(u).add(new ArrayList<>(Arrays.asList(v, w)));
            adj.get(v).add(new ArrayList<>(Arrays.asList(u, w)));
        }

        int sum = PrimAlgorithm.spanningTree(V, adj);
        System.out.println("The sum of all the edge weights: " + sum);
    }

    static class Pair {
        int node;
        int distance;

        Pair(int dist, int n) {
            this.distance = dist;
            this.node = n;
        }
    }
}
