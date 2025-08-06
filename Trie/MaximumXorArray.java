import java.util.ArrayList;

public class MaximumXorArray {
    static int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        Trie trie = new Trie();
        for(int it:arr1) trie.insert(it);

        int max = 0;
        for(int it: arr2) max = Math.max(max, trie.getMax(it));
        return max;
    }
    static void printArr(ArrayList<Integer> arr) {
        for (int it : arr) {
            System.out.print(it + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(java.util.Arrays.asList(3, 10, 5, 25, 2));
        ArrayList<Integer> arr2 = new ArrayList<>(java.util.Arrays.asList(8, 1, 2, 12, 7));
        int n = arr1.size();
        int m = arr2.size();

        System.out.print("Arr1: ");
        printArr(arr1);
        System.out.print("Arr2: ");
        printArr(arr2);

        int result = maxXOR(n, m, arr1, arr2);
        System.out.println("Maximum XOR value: " + result);
    }
}

class Node {
    Node[] links;

    Node() {
        links = new Node[2];
    }

    boolean containKey(int bit) {
        return links[bit] != null;
    }
    Node get(int bit) {
        return links[bit];
    }
    void put(int bit, Node node) {
        links[bit] = node;
    }
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    void insert(int num) {
        Node node = root;
        for(int i=31;i>=0;i--) {
            int bit = (num >> i) & 1; //extract the ith bit of the number
            if(!node.containKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }
    int getMax(int num) {
        Node node = root;
        int maxNum = 0;

        for(int i=31;i>=0;i--) {
            int bit = (num >> i) & 1;
            if(node.containKey(1-bit)) {
                maxNum |= (1<<i);
                node = node.get(1-bit);
            } else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}
