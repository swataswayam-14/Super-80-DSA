import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs = new ArrayList<>();

        boolean vis[] = new boolean[V+1];
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        vis[1] = true;

        while(!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            for(Integer it: adj.get(node)) {
                if(it != null && vis[it] == false) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<10;i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(1).add(6);
        adj.get(3).add(2);
        adj.get(4).add(2);
        adj.get(4).add(5);
        adj.get(6).add(1);
        adj.get(6).add(7);
        adj.get(6).add(9);
        adj.get(2).add(1);
        adj.get(2).add(4);
        adj.get(2).add(3);
        adj.get(5).add(4);
        adj.get(5).add(8);
        adj.get(8).add(5);
        adj.get(8).add(7);
        adj.get(9).add(6);
        adj.get(7).add(6);
        adj.get(7).add(8);

        System.out.println(bfsOfGraph(9, adj));
    }
}
