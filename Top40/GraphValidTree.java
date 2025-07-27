/*
Graph Valid Tree
Problem: Given n nodes labeled from 0 to n-1 and a list of edges, determine if they form a valid tree.
 */

// What is a valid tree : 
/*
 * it is connected: all nodes are reachable from any node
 * has no cycle
 */

// for n nodes , we must have exactly n-1 edges

// Key Concepts:
// Union-Find (Disjoint Set Union) for cycle detection + connectivity.

// DFS/BFS for cycle detection + visited node tracking.


// Logic:
// If edges.length != n - 1 → not a tree (either disconnected or has extra edges).

// Use Union-Find to detect if adding an edge creates a cycle.

// Ensure all nodes are connected (i.e., same component).

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {
    public boolean validTreeEfficient(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        int [] parent = new int[n];

        for(int i=0;i<n;i++) parent[i] = i;
        for(int[] edge: edges) {
            int x = find(parent, edge[0]);
            int y = find(parent, edge[1]);

            if(x==y) return false; //cycle found
            parent[x] = y; //union
        }
        return true;
    }
    private int find(int[] parent, int i) {
        if(parent[i] != i) {
            parent[i] = find(parent, parent[i]);//path compression
        }
        return parent[i];
    }

    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());

        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        if(hasCycle(graph, 0, -1, visited)) return false;

        for(boolean v: visited) {
            if(!v) return false; // not connected
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int node, int parent, boolean[] visited) {
        visited[node] = true;
        for(int neighbor: graph.get(node)) {
            if(!visited[neighbor]) {
                if(hasCycle(graph, neighbor, parent, visited)) return true;
            } else if(neighbor != parent) return true; //cycle found
        }
        return false;
    }
}
