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
}
