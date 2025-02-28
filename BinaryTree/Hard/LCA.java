package BinaryTree.Hard;

import java.util.ArrayList;

public class LCA {
    public static boolean getPath(Node root, ArrayList<Integer> arr, int x) {
        if (root == null) return false;
        arr.add(root.val);
        if (root.val == x) return true;

        if (getPath(root.left, arr, x) || getPath(root.right, arr, x)) return true;
        arr.remove(arr.size() - 1);
        return false;
    }
    public static int findLCA (Node root, int n1, int n2) {
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();

        if (!getPath(root, path1, n1) || !getPath(root, path2, n2)) return -1;

        int i=0;
        while (i<path1.size() && i< path2.size()) {
            if (!path1.get(i).equals(path2.get(i))) break;
            i++;
        }
        return path1.get(i-1);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int n1 = 4, n2 = 5;
        int lca = findLCA(root, n1, n2);
        System.out.println("Lowest Common Ancestor of " + n1 + " and " + n2 + " is: " + lca);
        Node lcaOptimal = findLCAOptimal(root, n1, n2);
        System.out.println("Lowest Common Ancestor of " + n1 + " and " + n2 + " is: " + lcaOptimal.val);
    }

    public static Node findLCAOptimal(Node root, int n1, int n2) {
        if (root == null || root.val == n1 || root.val == n2) return root;
        Node left = findLCAOptimal(root.left, n1, n2);
        Node right = findLCAOptimal(root.right, n1, n2);
        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }
}
