/*
Problem Statement
You are given:

numCourses (V): total number of courses labeled 0 to V-1

prerequisites: list of pairs [a, b] meaning you must finish course b before course a.

Goal: Return true if you can finish all courses (i.e., no cycle in prerequisites).
*/

/*
Intuition
This is a cycle detection problem in a directed graph.

If there's a cycle, you cannot complete all courses.
 */


/*
Brute Force (DFS with Recursion Stack)
Try visiting each node and do a DFS.

Use a visited array and a recStack (recursion stack).

If a node is visited again in the same DFS path → cycle exists.
 */

/*
Treat courses as nodes iin directed graph
A pair [a,b] means an edge from b -> a (you must complete b before a)
To detect a cycle , do DFS and track:
 -> visited[i] : has node i been completely finished
 -> recStack[i] : is node i in the current dfs path
 -> if a node is visited again in the same dfs path -> cycle exists -> cannot finish all courses
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++) graph.add(new ArrayList<>());
        for(int[] pre: prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        //dfs for all nodes
        for(int i=0;i<numCourses;i++) {
            if(isCyclic(i, graph, visited, recStack)) return false;
        }
        return true;
    }
    private static boolean isCyclic(int node, List<List<Integer>> graph, boolean[] visited, boolean[] recStack) {
        if(recStack[node]) return true;
        if(visited[node]) return false;

        visited[node] = true;
        recStack[node] = true;

        for(int neighbor: graph.get(node)) {
            if(isCyclic(neighbor, graph, visited, recStack)) return true;
        }
        recStack[node] = false;
        return false;
    }
    public static boolean canFinishOptimised(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int [] inDegree = new int[numCourses];
        for(int i=0;i<numCourses;i++) graph.add(new ArrayList<>());
        for(int[] pre: prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }
        //get all courses which have no prerequisites
        //course with indgree = 0
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(inDegree[i] == 0) queue.offer(i);
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            for(int neighbor: graph.get(current)) {
                inDegree[neighbor] --;
                if(inDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }
        return count == numCourses;
    }
}
