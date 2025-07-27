//intuition : 
//to preserve structure
//use preorder traversal : root -> left -> right
//mark nulls explicitly using a special symboll (e.g : "null" or "#")


//serialise using preorder traversal , adding "null" for empty children
//deserialise by reducing using a queue of tokens (values and "null"s)

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}


public class SerializeDeserializeBT {
    //serialization (Tree -> String)
    public static String serialise(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialiseHelper(root, sb);
        return sb.toString();
    }
    private static void serialiseHelper(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("null,");
            return;
        }
        sb.append(node.val).append(",");
        serialiseHelper(node.left, sb);
        serialiseHelper(node.right, sb);
    }
    public static TreeNode deserialise(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialiseHelper(nodes);
    }
    private static TreeNode deserialiseHelper(Queue<String> nodes) {
        String val = nodes.poll();
        if(val.equals("null")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserialiseHelper(nodes);
        node.right = deserialiseHelper(nodes);
        return node;
    }
}
