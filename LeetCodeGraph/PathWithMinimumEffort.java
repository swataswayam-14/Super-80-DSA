import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static int minimumEffort(int heights[][]) {
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x,y) -> x.distance - y.distance);

        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                dist[i][j] = (int)(1e9);
            }
        }

        dist[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!pq.isEmpty()) {
            Tuple it = pq.remove();

            int diff = it.distance;
            int row = it.row;
            int col = it.col;

            if(row == n-1 && col == m-1) return diff;
            for(int i=0;i<4;i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if(nr >=0 && nc >=0 && nr < n && nc < m) {
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[nr][nc]),diff);
                    if(newEffort < dist[nr][nc]) {
                        dist[nr][nc] = newEffort;
                        pq.add(new Tuple(newEffort, nr, nc));
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[][] heights={{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};

        int ans = minimumEffort(heights);
        System.out.print(ans);
    }
}
/*
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows * columns, where heights[row][col] represents the height of cell (row, col), You are situated in the top-left cell (0,0) and you hope to travel to the bottom-right cell (rows-1, columns-1) , You can move up, down, left, right and you wish to find a route that requires the minimum effort

A route's effort is the maximum absolute difference in heights between two consecutive cells of the route
 */

/*
1 2 2
3 8 2
5 3 5

1->2->2->2->5 

1->2 : 1
2->2 : 0
2->2 : 0
2->5 : 3

so the max effort is 3

1->3->5->3->5

max effort = 2

1->3->8->2->5

max effort = 6

figure out the effort in all the paths and find the minimum of them

here is the answer is 2 (minimum effort)


so which algorithm comes to your brain when you hear : shortest path, minimum effort path etc 
: Its Dijkshtra


we need the dist[][] array and the priority queue (min heap) this would store the {difference, row, col}


dist[][] = inf

dist[src_row][src_col] = 0
dist[0][0] = 0

put (0,0,0) in the pq

pop out the element

(0,0) diff = 0
(0,0) -> (0,1) diff = 1

update the dist[0][1] = 1

put (1, 0, 1) in the pq

(0,0) -> (1,0) diff = 2
dist[1][0] = 2

put (2,1,0) in the pq

now the top most element in the pq would be (1,0,1)

(0,1) -> (0,2) diff = 0

but we need to update with the max of all diff
hence dist[0][2] = 1

and put (1,0,2) in the pq
...then continue...


if we find the destination , donot just return yet , put that to the queue

when you pop out the top most element and that is your destination then you stop the algorithm and return the answer as that there cannot be any better answer as the pq stores the minimum diff at the top of the queue
*/


class Tuple {
    int distance;
    int row;
    int col;

    public Tuple(int distance, int row, int col) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}