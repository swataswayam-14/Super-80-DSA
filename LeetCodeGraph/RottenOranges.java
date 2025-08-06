import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static int findMinimumTime(int [][] grid) {
        int n = grid.length;
        int m = grid[0].length;  
        boolean visited[][] = new boolean[n][m];  

        int minute = -1;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {  
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int dir[][] = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
        };

        while(!q.isEmpty()) {
            int size = q.size();
            minute++;
            for(int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int x = cell[0], y = cell[1];

                for(int[] d : dir) {
                    int nx = x + d[0];
                    int ny = y + d[1];

                    if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && grid[nx][ny] == 1) {  
                        grid[nx][ny] = 2;
                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {  
                if(grid[i][j] == 1) return -1;
            }
        }

        return minute == -1 ? 0 : minute; 
    }

    public static void main(String[] args) {
        int arr[][] = new int[][]{
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        System.out.println(findMinimumTime(arr)); 

        System.out.println(findMinimumTime(new int[][]{{0, 1}}));
        System.out.println(findMinimumTime(new int[][]{{0, 2}})); 
    }
}
