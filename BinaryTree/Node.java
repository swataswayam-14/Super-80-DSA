package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
        List<Integer> inOrderTraversalArr = new ArrayList<>();
        inorderTraversal(inOrderTraversalArr, root);
        System.out.println(inOrderTraversalArr);
        List<Integer> postOrderTraversalArr = new ArrayList<>();
        postOrderTraversal(postOrderTraversalArr, root);
        System.out.println(postOrderTraversalArr);
        List<Integer> levelOrderTraversalArr = new ArrayList<>();
        levelOrderTraversal(levelOrderTraversalArr, root);
        System.out.println(levelOrderTraversalArr);
    }
    public static void preOrderTraversal(List<Integer> arr, Node root) {
        if (root == null) {
            return;
        }
        arr.add(root.data);
        preOrderTraversal(arr, root.left);
        preOrderTraversal(arr, root.right);
    }
    public static void inorderTraversal(List<Integer> arr, Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(arr, root.left);
        arr.add(root.data);
        inorderTraversal(arr, root.right);
    }
    public static void postOrderTraversal(List<Integer> arr, Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(arr, root.left);
        postOrderTraversal(arr, root.right);
        arr.add(root.data);
    }
    public static void levelOrderTraversal(List<Integer> arr, Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node el = q.remove();
                if (el.left != null) {
                    q.add(el.left);
                }
                if (el.right != null) {
                    q.add(el.right);
                }
                arr.add(el.data);
            }
        }
    }
}
