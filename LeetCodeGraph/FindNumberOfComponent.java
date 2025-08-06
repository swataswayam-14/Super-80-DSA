import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindNumberOfComponent {
    public static int findNumberOfComponent(int V, List<List<Integer>> edges) {
        //convert the edges to an adj list

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(List<Integer> edge: edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }

        boolean[] visited = new boolean[V];

        int count = 0;
        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                dfs(i,visited, adj);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[i] = true;
        for(Integer neighbor: adj.get(i)) {
            if(!visited[neighbor]) dfs(neighbor, visited, adj);
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(
            Arrays.asList(0,1),
            Arrays.asList(1,2),
            Arrays.asList(2,3),
            Arrays.asList(4,5)
        );
        System.out.println(findNumberOfComponent(7, list));
    }
}
