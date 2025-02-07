package BinaryTree.Medium_Problems;

public class CheckBalanced {
    //given a binary tree, return true if it is a balanced binary tree, else return false. A Binary tree is balanced if, for all nodes in the tree, the difference between left and right subtree height is not more than 1
    Boolean isBalanced (Node root) {
        if (root == null) return true;

        int leftHeight = this.getHeight(root.left);
        int rightHeight = this.getHeight(root.right);

        if (Math.abs(rightHeight - leftHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }
        return false;
    }
    int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);

        return 1 + Math.max(lh, rh);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        CheckBalanced solution = new CheckBalanced();
        if (solution.isBalanced(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
        if (solution.isBalancedOptimal(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }
    Boolean isBalancedOptimal (Node root) {
        return dfsHeight(root) != -1;
    }
    int dfsHeight (Node root) {
        if (root == null) return 0;
        int leftHeight = dfsHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
class Node {
    int data;
    Node left;
    Node right;
    Node (int val) {
        this.data = val;
        this.left = this.right = null;
    }
}


