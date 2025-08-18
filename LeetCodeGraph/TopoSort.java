import java.util.ArrayList;
import java.util.Stack;

public class TopoSort {
    /*
    Linear ordering of vertices such that if there is an edge between u and v, u appears before v in that ordering

    Only exists DAG (Directed Acyclic graph)

    why directed : obivous ( one should appear before other) if u->v
    Acyclic : 1-> 2-> 3 -> 1 
    then : 1 2 3 (3 should be before 1 as 3 has an edge to 1) cyclic dependency

    call dfs for unvisited nodes , if a node doesnot have any adjacent nodes not visited then put that into the stack
    once all dfs calls are over then take out the elements from the stack then you get one of the linear ordering you get , that is a topological sort
     */
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        Stack<Integer> st = new Stack<Integer>();

        for(int i=0;i<V;i++) {
            if(vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }
        int ans[] = new int[V];
        int i=0;

        while(!st.isEmpty()) {
            ans[i++] = st.pop();
        }
        return ans;
    }
    private static void dfs(int node, int vis[], Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for(int it: adj.get(node)) {
            if(vis[it] == 0) {
                dfs(it, vis, st, adj);
            }
        }
        st.push(node);
    }
    public static void main(String[] args) {
       int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] ans = topoSort(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }
}
