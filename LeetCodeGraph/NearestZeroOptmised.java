import java.util.LinkedList;
import java.util.Queue;

public class NearestZeroOptmised {
    //instead of starting bfs from every 1, we reverse our thinking

    /*
    Reverse Intuition : 

    instead of: 
        -> for every 1, find the nearest 0
    
    we do: 
        -> from every 0 find the nearest 1 and label its distance
    
    this is multisource bfs: 
        -> treat all 0s as starting point
        -> expand outwards in bfs
        -> the first time you reach a 1, you are at the shortest distance to a 0
     */

     /*
    Implemenation : 
        -> initialise : 
            -> a queue to do bfs
            -> a matrix to store distances
            -> add cells with 0s to the queue (distance = 0)
            -> mark all 1s as unvisited (or initially set to -1)
        -> BFS : 
            -> while the queue is not empty: 
                -> take out the front cell (i,j) and get its current distance
                -> check all neighbors (up, down, left, right)
                -> if neighbor is unvisited (-1) then: 
                    -> set its distance = current distance + 1
                    -> add it to the queue
      */
    
    
    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[]{i,j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        bfs(q, mat, m, n);
        return mat;
    }
    private static void bfs(Queue<int[]> q, int[][] mat, int m, int n) {

        int directions[][] = new int[][] {
            {1,0},
            {-1,0},
            {0,-1},
            {0,1}
        };

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            for(int[] dir: directions) {
                int nR = dir[0] + pos[0];
                int nC = dir[1] + pos[1];

                if(nR >= 0 && nC >= 0 && nR < m && nC < n) {
                    if(mat[nR][nC] > mat[pos[0]][pos[1]]) {
                        mat[nR][nC] = mat[pos[0]][pos[1]] + 1;
                        q.add(new int[]{nR,nC});
                    }
                }
            }
        }
    }
}
