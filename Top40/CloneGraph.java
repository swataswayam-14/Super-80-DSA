// Clone Graph
// Problem: Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.

// Key Concepts:
// Use HashMap<Node, Node> to store original → cloned node mapping.

// Avoid cloning the same node twice.

// Traverse using DFS or BFS.

// Maintain correct adjacency relationships during traversal.



// Time & Space Complexity:
// Time: O(V + E)

// Space: O(V) (due to HashMap + recursion/queue)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node(){}
    public Node(int val) {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }
}

public class CloneGraph {
    private Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node ==null) return null;
        if(visited.containsKey(node)) {
            return visited.get(node);
        }
        Node clone = new Node(node.val);
        visited.put(node, clone);
        for(Node neihbor: node.neighbors) {
            clone.neighbors.add(cloneGraph(neihbor));
        }
        return clone;
    }
    

/*
Optimized – BFS Iterative (Queue + HashMap)
 */
    public Node cloneGraphOptimised(Node node) {
        if(node == null) return null;
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node clone = new Node(node.val);
        visited.put(node, clone);
        queue.add(node);

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            for(Node neighbor: current.neighbors) {
                if(!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                visited.get(current).neighbors.add(visited.get(neighbor));
            }
        }
        return clone;
    }
}
