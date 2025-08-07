import java.util.LinkedList;
import java.util.Queue;

public class NearestZero {
    public static int[][] updateMatrix(int [][] mat) {
        //for every 1 , we perform bfs to find the shortest distance to a 0

        int m = mat.length;
        int n = mat[0].length;

        int res[][] = new int[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 0) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = bfs(mat, i, j, m, n);
                }
            }
        }
        return res;
    }
    private static int bfs(int[][] mat, int row, int col, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});

        visited[row][col] = true;

        int dist = 0;

        int[][] directions = {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
        };

        while (!q.isEmpty()) {
            int size = q.size();
            dist++;

            for(int i=0;i<size;i++) {
                int curr[] = q.poll();
                for(int [] dir: directions) {
                    int newRow = curr[0] + dir[0];
                    int newCol = curr[1] + dir[1];

                    if(newRow >= 0 && newCol >= 0 && newRow < m && newCol < n) {
                        if(mat[newRow][newCol] == 0) return dist;
                        q.add(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }
        }
        return -1;
    }
    //the T.C is O((m*n) * (m*n)) because for each cell with 1, we may traverse the whole matrix to find the closest 0
}
