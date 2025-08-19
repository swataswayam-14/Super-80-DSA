import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDGBFS {
    /*
    detect cycle in directed graph using bfs : kahn algorithm
    topo sort is only applicable in DAG
    if a graph has cycle : then topo sort is not possible

    try finding topo sort for the graph

    add all nodes with indegree 0 to the queue
    take out a node from the queue , reduce all the neighbor's indegree

    if the queue is empty and the topo sort has number of nodes < V , then the graph has a cycle
     */
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int indegree[] = new int[V];
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
        int count = 0;
        while(!q.isEmpty()) {
            int node = q.remove();
            count++;

            for(int it: adj.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        return count != V;
    }
}
