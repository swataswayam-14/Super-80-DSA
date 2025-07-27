//Lowest Common Ancestor of a Binary Search Tree
// Given a BST and two nodes, return their Lowest Common Ancestor (LCA).

//concept : left < root < right
//tarverse based on comparison of p and q values with current node

//brute force: path tracing + comparision
/*
 * find path from root to p and root to q.
 * compare both paths node by node to find the last common node
 */

//T.C  : O(h)
//S.C : O(h) (storing paths)

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestorBrute(TreeNode root, TreeNode q, TreeNode p) {
        List<TreeNode> path1 = getPath(root, p);
        List<TreeNode> path2 = getPath(root, q);

        TreeNode lca = null;
        for(int i=0;i< Math.min(path1.size(), path2.size()); i++) {
            if(path1.get(i) == path2.get(i)) {
                lca = path1.get(i);
            } else break;
        }
        return lca;
    }
    private static List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while(node != null) {
            path.add(node);
            if(target.val < node.val) node = node.left;
            else if(target.val > node.val) node = node.right;
            else break;
        }
        return path;
    }

/*
Optimized: One-Pass BST Property
Idea:
Start at root.

If both p and q are smaller → go left.

If both p and q are larger → go right.

Else → current node is the LCA.
Time Complexity: O(h)
Space Complexity: O(1) (Iterative) or O(h) (Recursive stack)
 */
    public static TreeNode lowestCommonAncestorOptimised_i(TreeNode root, TreeNode p, TreeNode q){
        while(root != null) {
            if(p.val < root.val && q.val < root.val) root = root.left;
            else if(p.val > root.val && q.val > root.val) root = root.right;
            else return root;
        }
        return null;
    }
    public static TreeNode lowestCommonAncestorOptimised_ii(TreeNode root, TreeNode p, TreeNode q){
        if(p.val < root.val && q.val < root.val) return lowestCommonAncestorOptimised_ii(root.left, p, q);
        else if(p.val > root.val && q.val > root.val) return lowestCommonAncestorOptimised_ii(root.right, p, q);
        else return root;
    }
}
