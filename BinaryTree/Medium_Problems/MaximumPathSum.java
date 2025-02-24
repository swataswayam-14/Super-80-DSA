package BinaryTree.Medium_Problems;

public class MaximumPathSum {
    int maxPathSum(Node node,int maximum){
        if (node == null) {
            return 0;
        }
        int rightSum = maxPathSum(node.right, maximum);
        int leftSum = maxPathSum(node.left, maximum);

        maximum = Math.max(maximum, leftSum+ rightSum + node.val);
        return node.val + Math.max(leftSum,rightSum);
    }
}
class Node {
    Node left, right;
    int val;
    Node(int val){
        this.left = null;
        this.right = null;
        this.val = val;
    } 
}
