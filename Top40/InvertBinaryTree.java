//invert BT : left child becomes right child and vice versa at every node
//recursive post-order or pre-order swapping
//BFS level-order traversal using a queue


//Brute Force
// Use recursion to traverse the tree and swap left and right children at each node
// T.C : O(n)
// S.C : O(h) - call stack height : worst case O(n) if skewed tree



// Optimized (Iterative with BFS)
// Intuition:
// Use a queue to do level-order traversal and swap children for every node.

// Time Complexity: O(n)
// Space Complexity: O(n) — queue in worst case

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static TreeNode invertTreeBrute(TreeNode root) {
        if(root == null) return null;
        //swap left and right
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTreeBrute(root.left);
        invertTreeBrute(root.right);

        return root;
    }
    public static TreeNode invertTreeOptimised(TreeNode root) {

        if(root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
        }
        return root;
    }
}
