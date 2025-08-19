import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule_II {
    public static int[] findOrder (int V, ArrayList<ArrayList<Integer>> prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<>());
        }

        int n = prerequisites.size();

        for(int i=0;i<n;i++) {
            adj.get(prerequisites.get(i).get(0)).add(prerequisites.get(i).get(1));
        }
        int indegree[] = new int[V];
        for(int i=0;i<V;i++) {
            for(int it: adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++) {
            if(indegree[i] == 0)q.add(i);
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.remove();
            topo.add(node);
            for(int it: adj.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        if(topo.size() == V) {
            int[] result = topo.stream().mapToInt(Integer::intValue).toArray();
            return result;
        }
        return new int[0];
    }
}
