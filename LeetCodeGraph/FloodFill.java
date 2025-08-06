import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static int[][] floodFill(int [][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0) return null;

        int n = image.length;
        int m = image[0].length;

        int originalColor = image[sr][sc];
        if(originalColor == color) return image;

        boolean visited[][] = new boolean[n][m];
        visited[sr][sc] = true;
        image[sr][sc] = color;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});

        int dx[] = new int[]{0,0,-1,1};
        int dy[] = new int[]{1,-1,0,0};

        while(!q.isEmpty()) {
            int[] node = q.poll();
            for(int i=0;i<4;i++) {
                int nx = node[0] + dx[i];
                int ny = node[1] + dy[i];

                if(nx >=0 && ny >=0 && nx < n && ny < m && !visited[nx][ny] && image[nx][ny] == originalColor) {
                    q.add(new int[]{nx,ny});
                    image[nx][ny] = color;
                    visited[nx][ny] = true;
                }
            }
        }
        return image;
    }
    public static void main(String[] args) {
        int arr[][] = new int[][]{
            {1,1,1},
            {1,1,0},
            {1,0,1}
        };
        int color = 2;

        int res[][] = floodFill(arr, 1, 1, color);
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
