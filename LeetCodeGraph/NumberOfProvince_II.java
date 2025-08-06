import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvince_II {
    public static int findCircleNum(int [][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        int count = 0;
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                bfs(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }
    private static void bfs(int i, int[][] isConnected, boolean[] visited) {
        visited[i] = true;
        Queue<Integer> q = new LinkedList<>();

        q.add(i);

        while (!q.isEmpty()) {
            int node = q.poll();
            for(int j=0;j<isConnected.length;j++) {
                if(isConnected[node][j] == 1 && !visited[j]){
                    visited[j] = true;
                    q.add(j);
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
