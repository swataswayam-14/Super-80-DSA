// brute force : 
// find inorder and check if its strictly increasing

import java.util.ArrayList;
import java.util.List;

public class CheckValidBST {
    public static boolean isValidBSTBrute(TreeNode root) {
        if(root == null) return true;
        List<Integer> inorderTraversal = new ArrayList<>();
        inorder(inorderTraversal, root);
        for(int i=1;i< inorderTraversal.size(); i++) {
            if(inorderTraversal.get(i) < inorderTraversal.get(i-1)) return false;
        }
        return true;
    }
    public static void inorder(List<Integer> inorderTraversal, TreeNode node) {
        if(node == null) return;
        inorder(inorderTraversal, node.left);
        inorderTraversal.add(node.val);
        inorder(inorderTraversal, node.right);
    }
    /*
    Optimized: Min-Max Range Validation (DFS)
    Idea:
    Use recursion to ensure:

    left < root < right

    Maintain min and max constraints on each subtree

    Time Complexity: O(n)
    Space Complexity: O(h) (recursive call stack)
     */
    public static boolean isValidBSTOptmised(TreeNode root) {
        return validate(root, null, null);
    }
    private static boolean validate(TreeNode node, Integer min, Integer max) {
        if(node == null) return true;
        if((min != null && node.val <= min) || (max != null && node.val >= max)) return false;

        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
        // the first one : max = node.val , that is the node's value can be maximum of the parent node's value , when we go left
        // the second one : min = node.val , that is the node's value can be minimum equal to parent node's value , when we go right
    }
}
