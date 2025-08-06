import java.util.ArrayList;

public class DetectCycle {
    public static boolean isCyclic(ArrayList<ArrayList<Integer>> graph, int V) {
        boolean visited[] = new boolean[V];
        boolean[] recStack = new boolean[V];

        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                if(dfs(i, graph, visited, recStack)) return true;
            }
        }
        return false;
    }
    private static boolean dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] recStack) {

        visited[node] = true;
        recStack[node] = true;

        for(Integer neighbor: graph.get(node)) {
            if(!visited[neighbor]) {
                if(dfs(neighbor, graph, visited, recStack)) return true;
            } else if(recStack[neighbor]) return true;
        }
        recStack[node] = false;
        return false;
    }
   
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int V = 3;
        for(int i=0;i<V;i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(1).add(0);
        graph.get(1).add(2);
        graph.get(2).add(1);
        graph.get(0).add(2);
        graph.get(2).add(0);
        System.out.println(isCyclic(graph, V));
    }
}
