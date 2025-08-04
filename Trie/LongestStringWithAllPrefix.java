class Node {
    Node links[] = new Node[26];
    boolean flag = false;

    public Node() {

    }
    boolean containsKey(char ch) {
        return (links[ch-'a'] != null);
    }
    Node get(char ch) {
        return links[ch-'a'];
    }
    void put(char ch, Node node) {
        links[ch-'a'] = node;
    }
    void setEnd() {
        flag = true;
    }
    boolean isEnd() {
        return flag;
    }
}

class Trie {
    private Node root;

    Trie() {
        root = new Node();
    }
    public void insert(String word){
        Node node = root;
        for(int i=0;i<word.length();i++) {
            if(!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    public boolean checkIfPrefixExists(String word) {
        Node node = root;

        for(int i=0;i<word.length(); i++) {
            if(node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                if(node.isEnd() == false) return false;
            } else {
                return false;
            }
        }
        return true;
    }
    
}


public class LongestStringWithAllPrefix {
    public static String completeString(int n, String[] arr) {
        Trie trie = new Trie();
        for(int i=0;i<n;i++) {
            trie.insert(arr[i]);
        }
        String longest = "";
        for(int i=0;i<n;i++) {
            if(trie.checkIfPrefixExists(arr[i])) {
                if(arr[i].length() > longest.length()) {
                    longest = arr[i];
                } else if(arr[i].length() == longest.length() && arr[i].compareTo(longest) < 0){
                    longest = arr[i];
                }
            }
        }
        if(longest.isEmpty()) return "None";
        return longest;
    }
    public static void main(String[] args) {
        String [] arr = {"n", "ninja", "nin", "ninj", "ninga"};

        System.out.println(completeString(arr.length, arr));
    }
}
