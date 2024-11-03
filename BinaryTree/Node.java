package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
        List<Integer> preOrderTraversalArrIterative = new ArrayList<>();
        iterativePreOrderTraversal(root, preOrderTraversalArrIterative);
        System.out.println(preOrderTraversalArrIterative);
        iterativeInorderTraversal(root);
        iterativePostOrderTraversal(root);
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
    public static void iterativePreOrderTraversal(Node root, List<Integer> lst) {
        if (root == null) {
            return;
        }
    
        Stack<Node> st = new Stack<>();
        st.push(root);
    
        while (!st.isEmpty()) {
            root = st.pop();
            lst.add(root.data);  
    
            if (root.right != null) {
                st.push(root.right);
            }
            if (root.left != null) {
                st.push(root.left);
            }
        }
    }
    
    public static void iterativeInorderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.data + " "); 
            current = current.right;
        }
    }
    public static void iterativePostOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
    
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        
        stack1.push(root);
    
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);
    
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }
    
}
