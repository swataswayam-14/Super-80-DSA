package BinaryTree.Medium_Problems;

public class SameTree {
    boolean isSameTree(Node p, Node q) {
        if (p==null && q == null) return true;
        return (p.val == q.val) && isSameTree(p.left, q.right) && isSameTree(p.right, q.right);
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
