package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Node {
    Node left;
        Node right;
        int data;

    public Node (int data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(12);
        root.left.left = new Node(8);
        root.right.left = new Node(34);
        List<Integer> preOrderTraversalArr = new ArrayList<>();
        preOrderTraversal(preOrderTraversalArr, root);
        System.out.println(preOrderTraversalArr);
    }
    public static void preOrderTraversal(List<Integer> arr, Node root) {
        if (root == null) {
            return;
        }
        arr.add(root.data);
        preOrderTraversal(arr, root.left);
        preOrderTraversal(arr, root.right);
    }
}
