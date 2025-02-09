package BinaryTree.Medium_Problems;

public class Diameter_of_BT {
    int diameter = 0;
    int findHeightBrute(Node root) {
        if (root == null) {
            return 0;
        }
        int lh = findHeightBrute(root.left);
        int rh = findHeightBrute(root.right);
        diameter = Math.max(diameter, lh + rh);

        return 1 + Math.max(lh, rh);
    }
    int findDiameterBrute(Node root) {
        findHeightBrute(root);
        return diameter;
    }

    int findDiameterOptimal(Node root) {
        int [] diameter = new int[1];
        heightOptimal(root, diameter);
        return diameter[0];
    }
    int heightOptimal(Node node, int[] diameter) {
        if (node == null) return 0;
        int lh = heightOptimal(node.left, diameter);
        int rh = heightOptimal(node.right, diameter);

        diameter[0] = Math.max(diameter[0], lh+rh);

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

        Diameter_of_BT solution = new Diameter_of_BT();
        System.out.println("The diameter of the BT : "+ solution.findDiameterBrute(root));
        System.out.println("The diameter of the BT : "+ solution.findDiameterOptimal(root));
    }
}
class Node {
    Node left;
    Node right;
    int data;

    Node (int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}