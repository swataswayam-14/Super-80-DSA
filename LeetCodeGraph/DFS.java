import java.util.ArrayList;

public class DFS {
    public static void dfs(int node, boolean vis[], ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> traversal) {
        vis[node] = true;
        traversal.add(node);

        for(Integer it: adj.get(node)) {
            if(!vis[it]) {
                dfs(it, vis, adj, traversal);
            }
        }
    }
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean vis[] = new boolean[V+1];
        vis[1] = true;
        ArrayList<Integer> traversal = new ArrayList<>();
        dfs(1, vis, adj, traversal);
        return traversal;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 9;
        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(2).add(6);
        adj.get(2).add(5);
        adj.get(3).add(1);
        adj.get(3).add(7);
        adj.get(3).add(4);
        adj.get(7).add(3);
        adj.get(7).add(8);
        adj.get(8).add(7);
        adj.get(8).add(4);

        System.out.println(dfsOfGraph(V, adj));
    }
}
