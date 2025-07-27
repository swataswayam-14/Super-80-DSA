// Same Tree
// Given two binary trees, write a function to check if they are the same or not.
// Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

// Key Concepts:
// Recursive Tree Comparison

// Check values and subtrees (left and right) recursively

// Base cases: null comparisons

// Brute Force (Recursive)
// Intuition:
// Recursively compare each node of both trees.

// Time Complexity:
// O(n) — where n is the number of nodes in both trees

// Space Complexity: O(h) — due to recursion stack (h = height)




// Optimized (Iterative using BFS or DFS)
// Intuition:
// Use two queues or stacks to traverse both trees simultaneously.

// Time Complexity:
// O(n)

// Space: O(n) for the queues/stacks

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    public static boolean checkSameBrute(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.val != t2.val) return false;
        return checkSameBrute(t1.left, t2.left) && checkSameBrute(t1.right, t2.right);
    }
    public static boolean checkSameOptmised(TreeNode t1, TreeNode t2) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.add(t1);
        queue2.add(t2);

        while(!(queue1.isEmpty() && queue2.isEmpty())) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if(node1 == null && node2 == null) return true;
            if(node1 == null || node2 == null) return false;
            if(node1.val != node2.val) return false;

            queue1.add(node1.left);
            queue1.add(node1.right);

            queue2.add(node2.left);
            queue2.add(node2.right);
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
