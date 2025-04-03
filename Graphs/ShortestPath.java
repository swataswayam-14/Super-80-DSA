package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {
    public int[] shortestPath(int[][] edges, int n, int m, int src) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int dist[] = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = (int)1e9;
        }
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            for(int it: adj.get(node)) {
                if (dist[node] + 1 < dist[it]){
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }
        for(int i=0;i<n;i++) {
            if (dist[i] == 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }
     public static void main(String[] args) {
        testShortestPath();
    }

    public static void testShortestPath() {
        ShortestPath sp = new ShortestPath();

        // Test Case 1
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int n1 = 5, m1 = 4, src1 = 0;
        int[] expected1 = {0, 1, 2, 3, 4};
        assert Arrays.equals(sp.shortestPath(edges1, n1, m1, src1), expected1) : "Test Case 1 Failed";

        // Test Case 2: Disconnected Graph
        int[][] edges2 = {{0, 1}, {1, 2}, {3, 4}};
        int n2 = 5, m2 = 3, src2 = 0;
        int[] expected2 = {0, 1, 2, -1, -1};
        assert Arrays.equals(sp.shortestPath(edges2, n2, m2, src2), expected2) : "Test Case 2 Failed";

        // Test Case 3: Single Node
        int[][] edges3 = {};
        int n3 = 1, m3 = 0, src3 = 0;
        int[] expected3 = {0};
        assert Arrays.equals(sp.shortestPath(edges3, n3, m3, src3), expected3) : "Test Case 3 Failed";

        // Test Case 4: Cycle Graph
        int[][] edges4 = {{0, 1}, {1, 2}, {2, 3}, {3, 0}};
        int n4 = 4, m4 = 4, src4 = 0;
        int[] expected4 = {0, 1, 2, 1};
        assert Arrays.equals(sp.shortestPath(edges4, n4, m4, src4), expected4) : "Test Case 4 Failed";

        System.out.println("All test cases passed!");
    }
}
