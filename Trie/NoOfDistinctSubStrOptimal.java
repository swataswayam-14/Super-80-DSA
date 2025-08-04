public class NoOfDistinctSubStrOptimal {
    public static int countDistinctSubstrings(String s) {
        Node root = new Node();
        int count = 0;

        int n = s.length();

        for(int i=0;i<n;i++) {
            Node node = root;
            for(int j=i;j<n;j++) {
                if(!node.containsKey(s.charAt(j))) {
                    node.put(s.charAt(j), new Node());
                    count++;
                }
                node = node.get(s.charAt(j));
            }
        }
        return count+1;
    }
    public static void main(String[] args) {
        String s = "swayam";
        System.out.println("Given string: " + s);
        System.out.println(countDistinctSubstrings(s));
    }
}

class Node {
    Node[] links;

    public boolean containsKey(char ch) {
        return (links[ch-'a'] != null);
    }
    public Node get(char ch) {
        return links[ch-'a'];
    }
    public void put(char ch, Node node) {
        links[ch-'a'] = node;
    }
}
