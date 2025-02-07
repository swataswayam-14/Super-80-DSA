package BinaryTree.Medium_Problems;

import java.util.LinkedList;
import java.util.Queue;

public class Height_of_BT {
    //given the root of a binary tree, return the height of the tree. The height of the tree is equal to the number of nodes on the longest path from root to leaf
    int maxDepth( Node root ) {
        if (root == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        int level = 0;

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node front = q.poll();
                if (front.left != null) q.add(front.left);
                if (front.right != null) q.add(front.right);
            }
            level++;
        }
        return level;
    }
    int maxDepthBrute(Node root) {
        if (root == null) {
            return 0;
        }
        int rightHeight = maxDepthBrute(root.right);
        int leftHeight = maxDepthBrute(root.left);
        return 1 + Math.max(rightHeight, leftHeight);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        Height_of_BT solution = new Height_of_BT();
        int depth = solution.maxDepth(root);
        System.out.println("Maximum depth of the binary tree: " + depth);
        int depthBrute = solution.maxDepthBrute(root);
        System.out.println("Maximum depth of the binary tree: " + depthBrute);
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        this.data = val;
        this.left = this.right = null;
    }
}
