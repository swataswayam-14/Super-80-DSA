import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInBinaryMaze {
    /*
    given a n*m matrix grid where each element can either be 0 or 1, You need to find the shortest distance between a given source cell to a destination cell, the path can only be created out of a cell it its value is 1.


    grid[][] = {{1,1,1,1},
                {1,1,0,1},
                {1,1,1,1},
                {1,1,0,0},
                {1,0,0,1}
                }
    source = {0,1}
    destination = {2,2}

    output = 3

    can move in 4 direction




    solving it by dijkstra

    - pq {dist, {row, col}}
    -2d array dist[][] - mark 0 on src and inf in others

    put {src, (0,1)} in the pq : (0,0,1)

    pop out the top element from pq

    traverse in all 4 direction

    put {1,0,2}
    put {1,1,1}
    put {1,0,0}

    here we traversed all the neighbour of the src node and reached every one with a distance of 1 (hence we don't need a priority queue for this), as pq is only if we need the min dist at the top of the queue but here all are same
     */
    public static int shortestPath(int[][] grid, int[] source, int[] destination) {
        if(source[0] == destination[0] && source[1] == destination[1]) return 0;

        Queue<Tuple> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        int dist[][] = new int[n][m];

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                dist[i][j] = (int)(1e9);
            }
        }

        dist[source[0]][source[1]] = 0;
        q.add(new Tuple(0, source[0] , source[1]));

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!q.isEmpty()) {
            Tuple it = q.remove();

            int dis = it.first;
            int r = it.second;
            int c = it.third;

            for(int i=0;i<4;i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];

                if(newr >= 0 && newr < n && newc >= 0 && newc < m && grid[newr][newc] == 1 && dis + 1 < dist[newr][newc]) {
                    dist[newr][newc] = 1 + dis;
                }

                if(newr == destination[0] && newc == destination[1]) return dis+1;

                q.add(new Tuple(1+dis, newr, newc));
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] source={0,1};
        int[] destination={2,2};
        
        int[][] grid={{1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}};

        int res = shortestPath(grid, source, destination);
        
        System.out.print(res);
        System.out.println();
    }
}
class Tuple {
    int first, second, third;
    Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
