package Tries;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trie {
    private static class TrieNode {
        private final TrieNode[] children;
        private boolean isEndOfWord;
        public TrieNode() {
            this.children = new TrieNode[26];
            this.isEndOfWord = false;
        }
    }
    private final TrieNode root;
    private int wordCount;

    public Trie(){
        root = new TrieNode();
        wordCount = 0;
    }
    public void insert(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null or empty");
        }
        TrieNode current = root;
        for (char ch: word.toCharArray()) {
            if (ch<'a' || ch >'z') {
                throw new IllegalArgumentException("Only lowercase english letters are supported: "+ch);
            }
            int index = ch-'a';
            if(current.children[index]==null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        if (!current.isEndOfWord) {
            current.isEndOfWord = true;
            wordCount++;
        }
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode current = root;
        for(char ch: prefix.toCharArray()){
            if (ch<'a' || ch>'z') return null;
            int index = ch-'a';
            if (current.children[index] == null) return null;
            current = current.children[index];
        }
        return current;
        
    }
    public boolean search(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Word cannot be null");
        }
        if (word.isEmpty()) {
            return root.isEndOfWord;
        }
        TrieNode node = searchPrefix(word);
        return node!= null && node.isEndOfWord;
    }
    public boolean isWordPresent(String word) {
        return search(word);
    }
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix cannot be null");
        }
        
        if (prefix.isEmpty()) {
            return wordCount > 0;
        }
        
        return searchPrefix(prefix) != null;
    }
        public boolean delete(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Word cannot be null");
        }
        
        if (word.isEmpty()) {
            if (root.isEndOfWord) {
                root.isEndOfWord = false;
                wordCount--;
                return true;
            }
            return false;
        }
        
        return delete(root, word, 0);
    }
    
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord) {
                return false; 
            }
            
            current.isEndOfWord = false;
            wordCount--;
            
  
            return hasNoChildren(current);
        }
        
        char ch = word.charAt(index);
        int childIndex = ch - 'a';
        
        if (current.children[childIndex] == null) {
            return false; 
        }
        
        boolean shouldDeleteChild = delete(current.children[childIndex], word, index + 1);
        
        if (shouldDeleteChild) {
            current.children[childIndex] = null;
            return !current.isEndOfWord && hasNoChildren(current);
        }
        
        return false;
    }
    private boolean hasNoChildren(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) {
                return false;
            }
        }
        return true;
    }
    public List<String> getWordsWithPrefix(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix cannot be null");
        }
        
        List<String> words = new ArrayList<>();
        TrieNode prefixNode = searchPrefix(prefix);
        
        if (prefixNode != null) {
            findWords(prefixNode, new StringBuilder(prefix), words);
        }
        
        return words;
    }
    private void findWords(TrieNode node, StringBuilder prefix, List<String> words) {
        if (node.isEndOfWord) {
            words.add(prefix.toString());
        }
        
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                char ch = (char) (i + 'a');
                prefix.append(ch);
                findWords(node.children[i], prefix, words);
                prefix.deleteCharAt(prefix.length() - 1); 
            }
        }
    }
    public int countWords() {
        return wordCount;
    }
    public boolean isEmpty() {
        return wordCount == 0;
    }
    public void clear() {
        clearNode(root);
        wordCount = 0;
    }
    private void clearNode(TrieNode node) {
        node.isEndOfWord = false;
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                clearNode(node.children[i]);
                node.children[i] = null;
            }
        }
    }
    public static void main(String[] args) {
        Trie trie = new Trie(); // Initialize the Trie
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("=====================================");
        System.out.println("      Welcome to the Trie CLI!       ");
        System.out.println("=====================================");
        
        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Insert a word");
            System.out.println("2. Search for a word");
            System.out.println("3. Check if a prefix exists");
            System.out.println("4. Display all words with a prefix");
            System.out.println("5. Count total words in the Trie");
            System.out.println("6. Delete a word");
            System.out.println("7. Clear the Trie");
            System.out.println("8. Exit");
            System.out.print("\nEnter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    System.out.print("\nEnter the word to insert: ");
                    String wordToInsert = scanner.nextLine().toLowerCase();
                    trie.insert(wordToInsert);
                    System.out.println("Word '" + wordToInsert + "' inserted successfully!");
                    break;
                    
                case 2:
                    System.out.print("\nEnter the word to search: ");
                    String wordToSearch = scanner.nextLine().toLowerCase();
                    boolean isFound = trie.search(wordToSearch);
                    if (isFound) {
                        System.out.println("Word '" + wordToSearch + "' exists in the Trie.");
                    } else {
                        System.out.println("Word '" + wordToSearch + "' does not exist in the Trie.");
                    }
                    break;
                    
                case 3:
                    System.out.print("\nEnter the prefix to check: ");
                    String prefixToCheck = scanner.nextLine().toLowerCase();
                    boolean hasPrefix = trie.startsWith(prefixToCheck);
                    if (hasPrefix) {
                        System.out.println("There are words in the Trie that start with '" + prefixToCheck + "'.");
                    } else {
                        System.out.println("No words in the Trie start with '" + prefixToCheck + "'.");
                    }
                    break;
                    
                case 4:
                    System.out.print("\nEnter the prefix to display words: ");
                    String prefixForWords = scanner.nextLine().toLowerCase();
                    var wordsWithPrefix = trie.getWordsWithPrefix(prefixForWords);
                    if (!wordsWithPrefix.isEmpty()) {
                        System.out.println("Words with prefix '" + prefixForWords + "': " + wordsWithPrefix);
                    } else {
                        System.out.println("No words found with prefix '" + prefixForWords + "'.");
                    }
                    break;
                    
                case 5:
                    int totalWords = trie.countWords();
                    System.out.println("\nTotal words in the Trie: " + totalWords);
                    break;
                    
                case 6:
                    System.out.print("\nEnter the word to delete: ");
                    String wordToDelete = scanner.nextLine().toLowerCase();
                    boolean isDeleted = trie.delete(wordToDelete);
                    if (isDeleted) {
                        System.out.println("Word '" + wordToDelete + "' deleted successfully!");
                    } else {
                        System.out.println("Word '" + wordToDelete + "' not found in the Trie.");
                    }
                    break;
                    
                case 7:
                    trie.clear();
                    System.out.println("\nThe Trie has been cleared!");
                    break;
                    
                case 8:
                    exit = true;
                    System.out.println("\nThank you for using the Trie CLI! Goodbye!");
                    break;
                    
                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}
