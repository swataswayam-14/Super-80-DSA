import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule_I {
    /*
    There are a total of N tasks, labeled from 0 to N-1. Some tasks may have prerequisites, for example to do task 0 you have to first complete task 1 which is expressed as a pair [0,1]

    given the total number of tasks N and a list of prerequisite pairs P, find if it is possible to finish all tasks.
    ex: 
    N=4, P = 3
    pre = {{1,0}, {2,1}, {3,2}}

    for task 1 -> complete 0
    for task 2 -> complete 1
    for task 3 -> complete 2

    so the ordering would be : 0 -> 1 -> 2 -> 3
    output : yes

    pre = {{1,2}, {4,3}, {2,4}, {4,1}}

    1 -> 2
    4 -> 3

    2 -> 4
    4 -> 1

    this forms a cycle , hence not possible 
    output : No


    approach : Topo sort
    solve it by : 
    -> detect if the graph has a cycle : dfs way 
    -> bfs way : topo sort (kahn algo)
    */    

    public static boolean isPossible(int V, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<V;i++) {
            adj.add(new ArrayList<>());
        }

        int n = prerequisites.length;

        for(int i=0;i<n;i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] indegree = new int[V];
        for(int i=0;i<V;i++) {
            for(int it: adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<V;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()) {
            count++;
            int node = q.remove();
            for(int it: adj.get(node)) {
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
        return count == V;
    }
    public static void main(String[] args) {
        int N = 4;
        int[][] prerequisites = new int[3][2];
        prerequisites[0][0] = 1;
        prerequisites[0][1] = 0;

        prerequisites[1][0] = 2;
        prerequisites[1][1] = 1;

        prerequisites[2][0] = 3;
        prerequisites[2][1] = 2;

        System.out.println(isPossible(N, prerequisites));
    }
}
