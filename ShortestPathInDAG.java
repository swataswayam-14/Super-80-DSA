import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPathInDAG {
    private void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int vis[], Stack<Integer> st) {
        vis[node] = 1;
        for (int i=0;i<adj.get(node).size();i++) {
            int v = adj.get(node).get(i).first;
            if (vis[v] == 0) {
                topoSort(v, adj, vis, st);
            }
        }
        st.add(node);
    }
    public int[] shortestPath(int N, int M, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i=0;i<N;i++) {
            ArrayList<Pair> temp = new ArrayList<Pair>();
            adj.add(temp);
        }
        for (int i=0;i<M;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        int vis[] = new int[N];
        Stack<Integer> st = new Stack<>();
        for (int i=0;i<N;i++) {
            if (vis[i] == 0) {
                topoSort(i, adj, vis, st);
            }
        }
        int dist[] = new int[N];
        for(int i=0;i<N;i++) {
            dist[i] = (int)1e9;
        }
        dist[0] = 0;
        while(!st.isEmpty()) {
            int node = st.peek();
            st.pop();

            for (int i=0;i<adj.get(node).size();i++) {
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;

                if (dist[node]+wt <dist[v]) {
                    dist[v] = dist[node]+wt;
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        testShortestPathInDAG();
    }

    public static void testShortestPathInDAG() {
        ShortestPathInDAG sp = new ShortestPathInDAG();

        // Test Case 1: Basic DAG
        int[][] edges1 = {{0, 1, 1}, {0, 2, 4}, {1, 2, 2}, {1, 3, 6}, {2, 3, 3}};
        int N1 = 4, M1 = 5;
        int[] expected1 = {0, 1, 3, 6};
        assert Arrays.equals(sp.shortestPath(N1, M1, edges1), expected1) : "Test Case 1 Failed";
        
        // Test Case 2: Disconnected Nodes
        int[][] edges2 = {{0, 1, 2}, {1, 2, 3}, {3, 4, 1}};
        int N2 = 5, M2 = 3;
        int[] expected2 = {0, 2, 5, (int) 1e9, (int) 1e9}; // Nodes 3 and 4 are unreachable
        assert Arrays.equals(sp.shortestPath(N2, M2, edges2), expected2) : "Test Case 2 Failed";
        
        // Test Case 3: Single Node
        int[][] edges3 = {};
        int N3 = 1, M3 = 0;
        int[] expected3 = {0};
        assert Arrays.equals(sp.shortestPath(N3, M3, edges3), expected3) : "Test Case 3 Failed";
        
        // Test Case 4: Larger DAG
        int[][] edges4 = {{0, 1, 2}, {0, 4, 1}, {1, 2, 3}, {2, 3, 6}, {4, 2, 2}, {4, 5, 4}, {5, 3, 1}};
        int N4 = 6, M4 = 7;
        int[] expected4 = {0, 2, 3, 7, 1, 5};
        assert Arrays.equals(sp.shortestPath(N4, M4, edges4), expected4) : "Test Case 4 Failed";
        
        System.out.println("All test cases passed!");
    }
}

class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

