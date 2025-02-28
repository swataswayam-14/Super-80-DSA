package BinaryTree.Hard;

import java.util.ArrayList;

class Node {
    Node right, left;
    int val;

    Node(int val) {
        this.val = val;
        this.right = this.left = null;
    }
}

public class RootToNode {
    boolean getPath(Node root, ArrayList<Integer> arr, int x) {
        if (root == null) return false;
        arr.add(root.val);
        if (root.val == x) return true;

        if (getPath(root.left, arr, x) || getPath(root.right, arr, x)) return true;
        arr.remove(arr.size() - 1);
        return false;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        RootToNode finder = new RootToNode();
        ArrayList<Integer> path = new ArrayList<>();
        int target = 5;
        
        if (finder.getPath(root, path, target)) {
            System.out.println("Path to node " + target + ": " + path);
        } else {
            System.out.println("Node " + target + " not found in the tree.");
        }
    }
}
