/*
Given the root of a BT , return its max depth
the max depth is the number of nodes along the longest path from root node down to the farthest leaf node

DFS : recursive or using stack
BFS : using a queue
 */

//Intuition 
//DFS - Recursive
//explore every path from the root to the leaves and return the maximum depth
//T.C is O(n) visiting all nodes and S.C is O(h) recursion stack (h = tree height)

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBT {
    public static int maxDepthBrute(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepthBrute(root.left);
        int right = maxDepthBrute(root.right);
        return 1 + Math.max(left, right);
    }    

    //optmised : BFS - Level Order Traversal
    // do a level order traversal using a queue and count the number of levels
    // T.C is O(n) : each node is visited once
    public static int maxDepthOptmised(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i=0;i<levelSize;i++) {
                TreeNode current = queue.poll();
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
            depth++;
        }
        return depth;
    }
}
