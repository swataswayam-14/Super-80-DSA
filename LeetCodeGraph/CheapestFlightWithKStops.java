import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightWithKStops {
    static class Pair {
    int first;
    int second;

    Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static class Tuple {
        int first, second , third;
        Tuple(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    /*
    There are n cities and m edges connected by some number of flights. You are given an array flights where flight[i] = [from i, to i, price i] indicates that there is a flight from city from i to city to i with price i


    You are also given 3 integers src, dst and k return the cheapest price from src to dst with at most k stops. If there is no such route return -1
     */
    /*
    src = 0
    dest = 2
    k = 2

    {dist, node, stops} : priority queue

    dist[] = inf (for all nodes)

    step 1 : create graph from edges
    step 2 : mark the dist[src] = 0


    put (0,0,0) in the pq

    then iterate the queue , pop out elements , update dist and insert it in the queue 

    it will not give the correct result as it will not take into account the stops,  and it will not allow a higher distance update if a node has been updated with a lower distance with more stops

    we are storing everything interms of distance , hence it will not work as we need to take account of the stops as well



    //CORRECT ANSWER: 

    src = 0
    dest = 2
    k = 2


    {stops,node, dist} in the priority queue
    we donot need a pq as the stops are increasing by +1
     */
    public static int cheapestFlight(int n, int flights[][], int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>(); // node1 -> node2, cost

        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }

        int m = flights.length;
        for(int i=0;i<m;i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();

        q.add(new Tuple(0, src,0));

        int[] dist = new int[n];

        for(int i=0;i<n;i++) {
            dist[i] = (int)1e9;
        }
        dist[src] = 0;

        while (!q.isEmpty()) {
            Tuple it = q.remove();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            if(stops > k) continue;

            for(Pair iter: adj.get(node)) {
                int adjNode = iter.first;
                int edW = iter.second;

                if(cost + edW < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edW;
                    q.add(new Tuple(stops+1, adjNode, cost + edW));
                }
            }
        }

        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];
    }
    public static void main(String[] args) {
        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

        int ans = cheapestFlight(n,flights,src,dst,K);
        
        System.out.print(ans);
        System.out.println();
    }
}
