import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Eventual_Safe_States {
    /*
    A directed graph of V vertices and E edges is given in the form of an adjacency list adj, Each node of the graph is labelled with a distinct integer in the range of 0 to V-1.

    A node is a terminal node if there are no outgoing edges. A node is a safe node if every possible path starting from that node leads to a terminal node

    You have to return an array containing all the safe nodes of the graph, the answer should be in sorted order.


    approach : 

    -> all the terminal nodes are safe nodes , if we count the outdegree of each node and the one that is having an outdegree of 0 is a terminal node

    steps : 
    -> reverse all the edges (from the terminal node)
    -> get all the nodes with indegree 0 
    -> do a removal of edges on adjacent nodes

    -> any one with a indegree 0 is a terminal node (as it is a reversed graph)

    Once the queue is empty, then return the safeNodes list in sorted order , the part of the graph which had unsafe nodes are never executed
     */
    public static List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<List<Integer>> adjRev = new ArrayList<>();
        for(int i=0;i<V;i++) {
            adjRev.add(new ArrayList<>());
        }
        int indegree[] = new int[V];

        for(int i=0;i<V;i++) {
            for(int it: adj.get(i)) {
                adjRev.get(it).add(i);
            }
        }
        for(int i=0;i<V;i++) {
            for(int it: adjRev.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();

        for(int i=0;i<V;i++) {
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int node = q.remove();
            safeNodes.add(node);
            for(int it: adjRev.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0)q.add(it);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
    public static void main(String[] args) {
        int V = 12;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(2).add(4);
        adj.get(3).add(4);
        adj.get(3).add(5);
        adj.get(4).add(6);
        adj.get(5).add(6);
        adj.get(6).add(7);
        adj.get(8).add(1);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        adj.get(11).add(9);

        List<Integer> safeNodes = eventualSafeNodes(V, adj);

        for (int node : safeNodes) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }
}
