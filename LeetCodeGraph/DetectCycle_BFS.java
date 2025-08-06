import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycle_BFS {
    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj , int V) {
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                if(checkForCycle(adj, i, visited)) return true; // a graph has a cycle if any of its component has a cycle
            }
        }
        return false;
    }
    private static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int i, boolean[] visited) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i, -1});
        visited[i] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];

            for(Integer neighbor: adj.get(node)) {
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.add(new int[]{neighbor, node});

                } else if(neighbor != parent){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
            adj.get(0).add(1);
            adj.get(1).add(0);
            adj.get(1).add(2);
            adj.get(2).add(1);
            adj.get(2).add(3);
            adj.get(3).add(2);
            adj.get(3).add(4);
            adj.get(4).add(3);
            adj.get(4).add(1); 
            adj.get(1).add(4);
        System.out.println(isCycle(adj, V));
    }
}
