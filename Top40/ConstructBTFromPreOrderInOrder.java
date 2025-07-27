/* 
Construct Binary Tree from Preorder and Inorder
Given preorder and inorder traversal of a binary tree, construct the binary tree.

Key Concepts:
Preorder: Root → Left → Right

Inorder: Left → Root → Right

Use recursion to build the tree

Use HashMap to quickly find index in inorder (optimized)



Brute Force: Recursive without HashMap
Idea:
First element in preorder is the root.

Find that root in inorder using a linear search.

Recursively split inorder into left/right subtrees.

Recurse for left and right children using new subarrays.

Time: O(n^2) — each find() in inorder takes O(n)
Space: O(n) — recursion + array copies
 */

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromPreOrderInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, 0, inorder.length - 1);
    }
    private TreeNode build(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if(preStart >= preorder.length || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        //linear search for root in inorder
        int inIndex = inStart;
        while(inIndex <= inEnd && inorder[inIndex] != root.val) inIndex++;

        int leftTreeSize = inIndex - inStart;

        root.left = build(preorder, inorder, preStart+1, inStart, inIndex - 1);
        root.right = build(preorder, inorder, preStart+1+leftTreeSize, inIndex + 1, inEnd);
        return root;
    }
/*
Optimized: Recursive with HashMap for Inorder Indexing
Idea:
Same as above but use a HashMap to store inorder indices for O(1) lookup.

Maintain a global preIndex to track root position in preorder array.

Time: O(n)
Space: O(n) — recursion + HashMap
*/
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    private int preIndex = 0;

    public TreeNode buildTreeOptimised(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return helper(preorder, 0, inorder.length-1);
    }
    private TreeNode helper(int [] preorder, int inStart, int inEnd) {
        if(inStart > inEnd) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = inorderIndexMap.get(rootVal);

        root.left = helper(preorder, inStart, inIndex - 1);
        root.right = helper(preorder, inIndex + 1, inEnd);

        return root;
    }
}
