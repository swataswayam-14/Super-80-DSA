import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnAlgorithm {
    /*
    topological sort using BFS

    indegree[]: number of incoming edges to a node

    if the indegree[i] is 0 then that node can be placed at first as there are no one before that node (which has a edge to it)

     -> insert all nodes with indegree 0 into the queue
     -> pop a node out of the queue
     -> remove the edges to the neighbor nodes of the node , by reducing the indegree[neighbor] value by 1
     -> after reducing the indegree[neighbor] check if it reached 0 
     ? No?? -> still some edges are connected to those nodes
     -> take out another element from the queue
     -> check neighbors by reducing indegree , if 0 put it in queue
     */
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        for(int i=0;i<V;i++) {
            for(int it: adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        int topo[] = new int[V];
        int i=0;

        while(!q.isEmpty()) {
            int node = q.remove();
            topo[i] = node;
            i++;
            for(int it: adj.get(node)) {
                indegree[it] --;
                if(indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return topo;
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
