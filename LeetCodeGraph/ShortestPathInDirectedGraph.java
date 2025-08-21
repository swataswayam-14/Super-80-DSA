import java.util.ArrayList;
import java.util.Stack;

public class ShortestPathInDirectedGraph {
    /*
    Given a directed acyclic graph, find the shortest path from the source (0) to all the vertex

    adj list 

    node1 -> {node2, distance_node1->node2}
    node3 -> {node4, distance_node_3->node4}, {node5, distance_node_3->node5}

    Pair {
        int node;
        int distance;
    }

    step 1 : Do a topo sort in the graph (bfs or dfs way) , find it

    dfs method : vis[] , stack ds which store the topo sort

    for(i->n) {
        if(!vis[i]) dfs(i)
    }

    dfs(0) -> dfs(1) -> dfs(3) , for 3 there is no one
    when dfs call is over , put it in the stack

    once the for loop is completed , the stack contains the topo sort

    step 2: take the nodes out of stack (one by one) and relax the edges

    for relaxing we need a dist[] array with everything marked as infinity

    go to source node and dist[source] = 0 // mark it first

    take out from stack

    node = 6, dist = 0 (find the distance from the dist array)
    find adjacent nodes of 6 
    -> node 5, dist = 0+3 = 3     node 4, dist = 0+2 = 2
    then update the dist[node5] and dist[node4] with Math.min with previous dist[i]

    the dist[] array is the answer
     */
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {
            {0,1,2},
            {0,4,1},
            {4,5,4},
            {4,2,2},
            {1,2,3},
            {2,3,6},
            {5,3,1}
        };
        int m = edges.length;
        int res[] = shortestPath(n, m, edges);
        for(int i=0;i<n;i++) {
            System.out.print(res[i] +" ");
        }
        System.out.println();
    }
    public static int[] shortestPath(int N, int M, int[][]edges) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<N;i++) {
            ArrayList<Pair> temp = new ArrayList<>();
            adj.add(temp);
        }
        for(int i=0;i<M;i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new Pair(v, wt));
        }

        int vis[] = new int[N];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<N;i++) {
            if(vis[i] == 0) {
                topoSort(i, adj, vis, st);
            }
        }

        int dist[] = new int[N];
        for(int i=0;i<N;i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        while(!st.isEmpty()) {
            int node = st.pop();

            for(int i=0;i<adj.get(node).size();i++) {
                int v = adj.get(node).get(i).first;
                int wt = adj.get(node).get(i).second;

                if(dist[node] + wt < dist[v]) {
                    dist[v] = dist[node] + wt;
                }
            }
        }
        for(int i=0;i<N;i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }
    private static void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int vis[], Stack<Integer> st) {
        vis[node] = 1;
        for(int i=0;i<adj.get(node).size();i++) {
            int neighbor = adj.get(node).get(i).first;
            if(vis[neighbor] == 0) {
                topoSort(neighbor, adj, vis, st);
            }
        }
        st.add(node);
    }
}
class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

