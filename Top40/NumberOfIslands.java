import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

//     Iterate through every cell.

// On finding '1', increment island count.

// Start DFS and mark all connected '1's as '0' (or visited).

    public static int numOfIslands(int arr[][]) {
        if(arr == null || arr.length == 0) return -1;
        int rows = arr.length;
        int cols = arr[0].length;

        int noOfIslands = 0;

        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(arr[i][j] == 1) {
                    noOfIslands++;
                    dfs(arr, i, j);
                }
            }
        }
        return noOfIslands;
    }
    private static void dfs(int arr[][], int i, int j) {
        int rows = arr.length;
        int cols = arr[0].length;

        if(i< 0 || j< 0 || i >= rows || j >= cols) return;

        arr[i][j] = 0;
        dfs(arr, i+1, j); /// down
        dfs(arr, i-1, j); // up
        dfs(arr, i, j+1); // right
        dfs(arr, i, j-1); // left
    }

    //bfs intuition : 
    //Instead of using recursion (DFS), we use a queue to explore each cell’s 4 neighbors level by level.
    //When we find a '1', we add it to the queue, mark it as visited (change to '0'), and keep expanding until the entire island is covered.
    public static int numOfIslandsBfs(int arr[][]) {
        if(arr == null || arr.length == 0) return -1;
        int rows = arr.length;
        int cols = arr[0].length;

        int noOfIslands = 0;

        int dir[][] = new int[][]{
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        for(int i=0;i< rows;i++) {
            for(int j=0;j<cols;j++) {
                if(arr[i][j] == 1) {

                    noOfIslands++;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    arr[i][j] = 0;

                    while(!q.isEmpty()) {
                        int[] cell = q.poll();
                        int x = cell[0];
                        int y = cell[1];
                        for(int[] d: dir) {
                            int newX = x + d[0];
                            int newY = y + d[1];

                            if(newX >= 0 && newX < rows && newY >= 0 || newY < cols && arr[newX][newY] == 1) {
                                q.add(new int[]{newX, newY});
                                arr[newX][newY] = 0;
                            }
                        }
                    }
                }
            }
        }
        return noOfIslands;
    }
}
