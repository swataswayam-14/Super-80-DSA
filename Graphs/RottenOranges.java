package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static int orangesRotting(int grid[][]) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int count_non_empty = 0;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                }
                if(grid[i][j] != 0) {
                    count_non_empty++;
                }
            }
        }
        if(count_non_empty == 0) return 0;
        int countMin = 0, cnt = 0;
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};

        while (!queue.isEmpty()) {
            int size = queue.size();
            cnt += size;
            for(int i=0;i<size;i++) {
                int[] point = queue.poll();
                for(int j=0;j<4;j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if (x<0 || y<0 || x>=rows||y>=cols || grid[x][y] == 0 || grid[x][y] == 2) continue;
                    grid[x][y] = 2;
                    queue.offer(new int[]{x,y});
                }
            }
            if (queue.size() != 0) {
                countMin++;
            }
        }
        return count_non_empty == cnt ? countMin : -1;
    }
    public static void main(String[] args) {
        // Test Case 1: Basic case with rot spread
        int[][] grid1 = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        System.out.println("Test Case 1 Output: " + orangesRotting(cloneGrid(grid1))); // Expected: 4

        // Test Case 2: All oranges are already rotten
        int[][] grid2 = {
            {2,2,2},
            {2,2,2},
            {2,2,2}
        };
        System.out.println("Test Case 2 Output: " + orangesRotting(cloneGrid(grid2))); // Expected: 0

        // Test Case 3: Some oranges can't be reached
        int[][] grid3 = {
            {2,1,1},
            {0,1,1},
            {1,0,1}
        };
        System.out.println("Test Case 3 Output: " + orangesRotting(cloneGrid(grid3))); // Expected: -1

        // Test Case 4: No fresh oranges
        int[][] grid4 = {
            {0,2,0},
            {0,0,0},
            {0,0,2}
        };
        System.out.println("Test Case 4 Output: " + orangesRotting(cloneGrid(grid4))); // Expected: 0
    }
    public static int[][] cloneGrid(int[][] grid) {
        int[][] newGrid = new int[grid.length][];
        for(int i = 0; i < grid.length; i++) {
            newGrid[i] = grid[i].clone();
        }
        return newGrid;
    }
}

