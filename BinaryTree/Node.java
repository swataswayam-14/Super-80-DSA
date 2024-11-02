package BinaryTree;

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
    }
}
