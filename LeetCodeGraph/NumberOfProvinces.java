import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    public static int findCircleNum(int[][] connected) {
        int V = connected.length; // number of nodes in the matrix / graph

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<V;i++) {
            for(int j=i+1;j<V;j++) {
                if(connected[i][j] == 1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean visited[] = new boolean[V];

        int count = 0;

        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                bfs(i, visited, adj);
                count++;
            }
        }
        return count;
    }
    private static void bfs(int i, boolean visited[], ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        visited[i] = true;

        q.add(i);

        while(!q.isEmpty()) {
            Integer node = q.poll();
            for(Integer it: adj.get(node)) {
                if(!visited[it]) {
                    visited[it] = true;
                    q.add(it); 
                }
            }
        }
    }
    public static void main(String[] args) {
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        System.out.println(findCircleNum(isConnected));
    }
}
