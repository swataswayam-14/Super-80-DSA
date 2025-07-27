//Binary Tree Right Side View
// Given a binary tree, return the list of nodes visible when viewed from the right side.

// level-order traversal (BFS)
//keep track of rightmost element node at each level


//Brute Force : Level-Order
//Collect all nodes per level
/*
 * perform bfs , collect all nodes at each level
 * for every level , pick the last node in the level's list
 */
//T.C : O(n) : visit all nodes
// Space : O(w) = max queue size (width of tree)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class RightSideOfBT {
    public static List<Integer> rightSideBTBrute(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(level.get(level.size() - 1));
        }
        return res;
    }

/*
Optimized: Level-order (Track Rightmost Only)
Idea:
During BFS, when processing each level:

Traverse nodes left to right

Record the last node’s value during the level

Time: O(n)
Space: O(w)
 */
    public static List<Integer> rightSideBTOptimised(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeNode rightMostNode = null;
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                rightMostNode = node;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(rightMostNode != null) {
                res.add(rightMostNode.val);
            }
        }
        return res;
    }
}
