//BT level order traversal 
//return the level by level (breadth-first) traversal of a BT

//BFS using queue
//DFS with level tracking (brute force)



/*
Brute Force: 
use recursion (DFS) and pass the current level to build level wise lists
T.C is O(n)
S.C is O(h) recursion + result list
 */


/*
Optimized: BFS Using Queue
Intuition:
Use a queue to perform a level-by-level traversal.

Time Complexity: O(n)
Space Complexity: O(w) — w is max width (breadth) of tree
*/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }
    private static void dfs(TreeNode node , int level, List<List<Integer>> result) {
        if(node == null) return;
        if(level == result.size()) result.add(new ArrayList<>());
        result.get(level).add(node.val);

        dfs(node.left, level+1, result);
        dfs(node.right, level+1, result);
    }
    public static List<List<Integer>> levelOrderOptimised(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i< size;i++) {
                TreeNode current = queue.poll();
                level.add(current.val);
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
            res.add(level);
        }
        return res;
    }
}
