import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathInUndirectedGraphDijkstra {
    //print the shortest path between source and destination
    //the source is 1 and destination is n
    //1 - indexed path
    //return the shortest distance (nodes) in a list

    //dijkstra would give me the value of the shortest path , but we need the path
    // I need to remember where I am coming from


    //Priority Queue {dist, node}
    //parent array (Where I am coming from) assign with the index value

    //dist[] arr

    /*
    src = 1
    dist = 0

    put {0,1} in the pq

    go in the adj of 1 

    dist = 0+2
    node = 2

    put {2,2}

    parent[2] = 1 // the parent of 2 is one , it came from 1

    node = 4
    dist = 0+1 = 1

    put {1,4}

    parent[4] = 1

    NOW THE ENTIRE ITERATION FOR NODE = 1 IS DONE

    then pop out another element from the pq and do the same steps 
    pq is a min-heap and it stores the min at the top

    hence this time {1,4} would be popped out

    node = 3;
    dist = 1+3 = 4

    put {4,3} in the queue


    now how to figure out the path

    start from destination 

    dest = 5

    arrived from = parent[5] = 3

    arrived from = parent[3] = 4

    arrived from = parent[4] = 1

    and 1 is taking a distance of 0 -> hence its the parent
     */
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.first - y.first);

        int dist[] = new int[n+1];
        int parent[] = new int[n+1];

        for(int i=1;i<=n;i++) {
            dist[i] = (int)1e9;
            parent[i] = i;
        }

        dist[1] = 0; //the source is 1
        pq.add(new Pair(0, 1));

        while(!pq.isEmpty()) {
            Pair it = pq.remove();
            int node = it.second;
            int dis = it.first;

            for(Pair iter: adj.get(node)) {
                int adjNode = iter.first;
                int edW = iter.second;

                if(dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair(dis+edW, adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if(dist[n] == 1e9) {
            path.add(-1);
            return path;
        }

        int node = n;
        while(parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.sort(path);
        return path;
    }
}
class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
