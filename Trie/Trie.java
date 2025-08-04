public class Trie {
    static class Node {
        Node[] links = new Node[26];
        boolean flag = false;

        boolean containsKey(char ch) {
            return links[ch-'a'] != null;
        }
        void put(char ch, Node node) {
            links[ch-'a'] = node;
        }
        Node get(char ch) {
            return links[ch-'a'];
        }
        void setEnd() {
            flag = true;
        }
        boolean isEnd() {
            return flag;
        }
    }

    private Node root;

    public Trie() {
        root = new Node();
    }
    public void insert(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++) {
            if(!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }
    public boolean search(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++) {
            if(!node.containsKey(word.charAt(i))) return false;
            node = node.get(word.charAt(i));
        }
        return node.isEnd();
    }
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i=0;i<prefix.length();i++) {
            if(!node.containsKey(prefix.charAt(i))) return false;
            node = node.get(prefix.charAt(i));
        }
        return true;
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("swayam");
        trie.insert("dash");
        trie.insert("japan");
        trie.insert("quant");
        trie.insert("money");

        System.out.println("Search if dash exists in the trie: " + trie.search("dash"));
        System.out.println("Check if jap is a prefix of any word: "+trie.startsWith("jap"));
        System.out.println("Search if jan is any word's prefix: " +trie.startsWith("jan"));
    }
/*
Time Complexity:

Insertion: O(N) where N is the length of the word being inserted. This is because we have to iterate over each letter of the word to find its corresponding node or create a node accordingly.

Search: O(N) where N is the length of the word being searched for. This is because in Trie search we traverse over each letter for the word from the root, checking if the current node contains a node at the index of the next letter. This process repeats until we reach the end of the word or encounter a node without the next letter.

Prefix Search: O(N) where N is the length of the prefix being searched for. Similar to searching for words, in prefix search we also iterate over each letter of the word to find its corresponding node.

Space Complexity: O(N) where N is the total number of characters across all unique words inserted into the Trie. For each character in a word, a new node may need to be created leading to space proportional to the number of characters.
 */
}
