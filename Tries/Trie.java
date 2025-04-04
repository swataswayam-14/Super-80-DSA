package Tries;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
    private static final String RESET = "\u001B[0m";
    private static final String BLACK = "\u001B[30m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String WHITE = "\u001B[37m";
    private static final String BOLD = "\u001B[1m";
    

    private static final int MENU_BOX_WIDTH = 40;
    private static final int WELCOME_BOX_WIDTH = 40;
    private static final int GOODBYE_BOX_WIDTH = 40;

    public static void main(String[] args) throws InterruptedException {
        Trie trie = new Trie(); 
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        clearScreen();
        showWelcomeAnimation();

        while (!exit) {
            displayMenu();
            System.out.print(BOLD + CYAN + "\nEnter your choice: " + RESET);

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print(YELLOW + "\nEnter the word to insert: " + RESET);
                        String wordToInsert = scanner.nextLine().toLowerCase();
                        trie.insert(wordToInsert);
                        animateSuccess("Word '" + wordToInsert + "' inserted successfully!");
                        break;

                    case 2:
                        System.out.print(YELLOW + "\nEnter the word to search: " + RESET);
                        String wordToSearch = scanner.nextLine().toLowerCase();
                        boolean isFound = trie.search(wordToSearch);
                        if (isFound) {
                            typeWithColor("Word '" + wordToSearch + "' exists in the Trie.", GREEN);
                        } else {
                            typeWithColor("Word '" + wordToSearch + "' does not exist in the Trie.", RED);
                        }
                        break;

                    case 3:
                        System.out.print(YELLOW + "\nEnter the prefix to check: " + RESET);
                        String prefixToCheck = scanner.nextLine().toLowerCase();
                        boolean hasPrefix = trie.startsWith(prefixToCheck);
                        if (hasPrefix) {
                            typeWithColor("There are words in the Trie that start with '" + prefixToCheck + "'.", GREEN);
                        } else {
                            typeWithColor("No words in the Trie start with '" + prefixToCheck + "'.", RED);
                        }
                        break;

                    case 4:
                        System.out.print(YELLOW + "\nEnter the prefix to display words: " + RESET);
                        String prefixForWords = scanner.nextLine().toLowerCase();
                        var wordsWithPrefix = trie.getWordsWithPrefix(prefixForWords);
                        if (!wordsWithPrefix.isEmpty()) {
                            typeWithColor("Words with prefix '" + prefixForWords + "':", CYAN);
                            animateList(wordsWithPrefix);
                        } else {
                            typeWithColor("No words found with prefix '" + prefixForWords + "'.", RED);
                        }
                        break;

                    case 5:
                        int totalWords = trie.countWords();
                        System.out.println();
                        animateCounter(totalWords);
                        break;

                    case 6:
                        System.out.print(YELLOW + "\nEnter the word to delete: " + RESET);
                        String wordToDelete = scanner.nextLine().toLowerCase();
                        boolean isDeleted = trie.delete(wordToDelete);
                        if (isDeleted) {
                            animateDelete(wordToDelete);
                        } else {
                            typeWithColor("Word '" + wordToDelete + "' not found in the Trie.", RED);
                        }
                        break;

                    case 7:
                        animateClear();
                        trie.clear();
                        break;

                    case 8:
                        exit = true;
                        animateExit();
                        break;

                    default:
                        System.out.println(RED + "\nInvalid choice! Please try again." + RESET);
                        TimeUnit.MILLISECONDS.sleep(1000);
                }
            } catch (Exception e) {
                System.out.println(RED + "\nInvalid input! Please enter a number." + RESET);
                scanner.nextLine(); // Clear the invalid input
                TimeUnit.MILLISECONDS.sleep(1000);
            }
            
            if (!exit) {
                System.out.print(PURPLE + "\nPress Enter to continue..." + RESET);
                scanner.nextLine();
                clearScreen();
            }
        }

        scanner.close();
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    private static void showWelcomeAnimation() throws InterruptedException {
        String[] frames = {
            "T", "TR", "TRI", "TRIE", "TRIE C", "TRIE CL", "TRIE CLI"
        };
        
        for (String frame : frames) {
            clearScreen();
            System.out.println();
            String topBottom = createLine("╔", "═", "╗", WELCOME_BOX_WIDTH);
            String empty = createLine("║", " ", "║", WELCOME_BOX_WIDTH);
            
            System.out.println(BOLD + CYAN + topBottom + RESET);
            System.out.println(BOLD + CYAN + empty + RESET);
            
            String welcome = "Welcome to the";
            String welcomeLine = createCenteredLine("║", welcome, "║", WELCOME_BOX_WIDTH);
            System.out.println(BOLD + CYAN + welcomeLine + RESET);
            
            String frameLine = createCenteredLine("║", frame, "║", WELCOME_BOX_WIDTH);
            System.out.println(BOLD + CYAN + "║" + PURPLE + frameLine.substring(1, frameLine.length() - 1) + CYAN + "║" + RESET);
            
            System.out.println(BOLD + CYAN + empty + RESET);
            System.out.println(BOLD + CYAN + createLine("╚", "═", "╝", WELCOME_BOX_WIDTH) + RESET);
            
            TimeUnit.MILLISECONDS.sleep(200);
        }
        
        TimeUnit.MILLISECONDS.sleep(1000);
    }
    
    private static String createLine(String start, String middle, String end, int width) {
        StringBuilder sb = new StringBuilder();
        sb.append(start);
        for (int i = 0; i < width - 2; i++) {
            sb.append(middle);
        }
        sb.append(end);
        return sb.toString();
    }
    
    private static String createCenteredLine(String start, String text, String end, int width) {
        StringBuilder sb = new StringBuilder();
        sb.append(start);
        
        int textSpace = width - 2;
        int padding = (textSpace - text.length()) / 2;
        
        for (int i = 0; i < padding; i++) {
            sb.append(" ");
        }
        
        sb.append(text);
        
        int remainingSpace = width - 2 - padding - text.length();
        for (int i = 0; i < remainingSpace; i++) {
            sb.append(" ");
        }
        
        sb.append(end);
        return sb.toString();
    }
    
    private static void displayMenu() throws InterruptedException {
        String[] menuItems = {
            "Choose an option:",
            "1. Insert a word",
            "2. Search for a word",
            "3. Check if a prefix exists",
            "4. Display all words with a prefix",
            "5. Count total words in the Trie",
            "6. Delete a word",
            "7. Clear the Trie",
            "8. Exit"
        };
        
        String topLine = createLine("╔", "═", "╗", MENU_BOX_WIDTH);
        String middleLine = createLine("╠", "═", "╣", MENU_BOX_WIDTH);
        String bottomLine = createLine("╚", "═", "╝", MENU_BOX_WIDTH);
        
        System.out.println(BOLD + BLUE + "\n" + topLine + RESET);
        
        for (int i = 0; i < menuItems.length; i++) {
            if (i == 0) {
                String titleLine = createCenteredLine("║", menuItems[i], "║", MENU_BOX_WIDTH);
                System.out.println(BOLD + BLUE + "║" + BOLD + YELLOW + titleLine.substring(1, titleLine.length() - 1) + BLUE + "║" + RESET);
                System.out.println(BOLD + BLUE + middleLine + RESET);
            } else {
                String coloredText;
                switch (i) {
                    case 1: coloredText = GREEN + menuItems[i]; break;
                    case 2: coloredText = CYAN + menuItems[i]; break;
                    case 3: coloredText = YELLOW + menuItems[i]; break;
                    case 4: coloredText = PURPLE + menuItems[i]; break;
                    case 5: coloredText = GREEN + menuItems[i]; break;
                    case 6: coloredText = RED + menuItems[i]; break;
                    case 7: coloredText = YELLOW + menuItems[i]; break;
                    case 8: coloredText = RED + menuItems[i]; break;
                    default: coloredText = WHITE + menuItems[i];
                }
                
                StringBuilder menuLine = new StringBuilder();
                menuLine.append(BOLD + BLUE + "║ " + RESET);
                menuLine.append(coloredText + RESET);
                
                int padding = MENU_BOX_WIDTH - 3 - menuItems[i].length();
                for (int j = 0; j < padding; j++) {
                    menuLine.append(" ");
                }
                
                menuLine.append(BOLD + BLUE + "║" + RESET);
                System.out.println(menuLine);
            }
        }
        
        System.out.println(BOLD + BLUE + bottomLine + RESET);
    }
    
    private static void typeWithColor(String text, String color) throws InterruptedException {
        System.out.println();
        for (char c : text.toCharArray()) {
            System.out.print(color + c + RESET);
            TimeUnit.MILLISECONDS.sleep(30);
        }
        System.out.println();
    }
    
    private static void animateSuccess(String message) throws InterruptedException {
        System.out.println();
        String animation = "✓ ";
        for (char c : animation.toCharArray()) {
            System.out.print(BOLD + GREEN + c + RESET);
            TimeUnit.MILLISECONDS.sleep(300);
        }
        
        for (char c : message.toCharArray()) {
            System.out.print(GREEN + c + RESET);
            TimeUnit.MILLISECONDS.sleep(30);
        }
        System.out.println();
    }
    
    private static void animateList(Iterable<String> items) throws InterruptedException {
        int count = 0;
        for (String item : items) {
            count++;
            System.out.print(PURPLE + "  " + count + ". " + RESET);
            TimeUnit.MILLISECONDS.sleep(300);
            for (char c : item.toCharArray()) {
                System.out.print(CYAN + c + RESET);
                TimeUnit.MILLISECONDS.sleep(20);
            }
            System.out.println();
        }
    }
    
    private static void animateCounter(int count) throws InterruptedException {
        String message = "Counting words in the Trie: ";
        typeWithColor(message, YELLOW);
        
        for (int i = 0; i <= count; i++) {
            System.out.print("\r" + BOLD + GREEN + message + i + RESET);
            if (i < count) {
                TimeUnit.MILLISECONDS.sleep(1000 / Math.max(1, count));
            }
        }
        System.out.println("\n");
    }
    
    private static void animateDelete(String word) throws InterruptedException {
        System.out.println();
        System.out.print(RED + "Deleting: " + RESET);
        for (char c : word.toCharArray()) {
            System.out.print(YELLOW + c + RESET);
            TimeUnit.MILLISECONDS.sleep(50);
        }
        
        TimeUnit.MILLISECONDS.sleep(300);
        for (int i = 0; i < word.length(); i++) {
            System.out.print("\b \b");
            TimeUnit.MILLISECONDS.sleep(50);
        }
        
        typeWithColor("Word '" + word + "' deleted successfully!", GREEN);
    }
    
    private static void animateClear() throws InterruptedException {
        System.out.println();
        String message = "Clearing the Trie";
        System.out.print(YELLOW + message);
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(".");
                TimeUnit.MILLISECONDS.sleep(300);
            }
            System.out.print("\b\b\b   \b\b\b");
            TimeUnit.MILLISECONDS.sleep(300);
        }
        
        typeWithColor("\nThe Trie has been cleared!", GREEN);
    }
    
    private static void animateExit() throws InterruptedException {
        clearScreen();
        String[] frames = {
            "Thank you for using the Trie CLI!",
            "Thank you for using the Trie CLI! G",
            "Thank you for using the Trie CLI! Go",
            "Thank you for using the Trie CLI! Goo",
            "Thank you for using the Trie CLI! Good",
            "Thank you for using the Trie CLI! Goodb",
            "Thank you for using the Trie CLI! Goodbye",
            "Thank you for using the Trie CLI! Goodbye!",
        };
        
        for (String frame : frames) {
            clearScreen();
            System.out.println();
            
            String topBottom = createLine("╔", "═", "╗", GOODBYE_BOX_WIDTH);
            String empty = createLine("║", " ", "║", GOODBYE_BOX_WIDTH);
            
            System.out.println(BOLD + CYAN + topBottom + RESET);
            System.out.println(BOLD + CYAN + empty + RESET);
            

            if (frame.length() > GOODBYE_BOX_WIDTH - 4) {
                int splitPoint = Math.min(GOODBYE_BOX_WIDTH - 4, frame.lastIndexOf(" ", GOODBYE_BOX_WIDTH - 4));
                String line1 = frame.substring(0, splitPoint);
                String line2 = frame.substring(splitPoint + 1);
                
                String line1Text = createCenteredLine("║", line1, "║", GOODBYE_BOX_WIDTH);
                System.out.println(BOLD + CYAN + "║" + PURPLE + line1Text.substring(1, line1Text.length() - 1) + CYAN + "║" + RESET);
                
                String line2Text = createCenteredLine("║", line2, "║", GOODBYE_BOX_WIDTH);
                System.out.println(BOLD + CYAN + "║" + PURPLE + line2Text.substring(1, line2Text.length() - 1) + CYAN + "║" + RESET);
            } else {
                String frameLine = createCenteredLine("║", frame, "║", GOODBYE_BOX_WIDTH);
                System.out.println(BOLD + CYAN + "║" + PURPLE + frameLine.substring(1, frameLine.length() - 1) + CYAN + "║" + RESET);
            }
            
            System.out.println(BOLD + CYAN + empty + RESET);
            System.out.println(BOLD + CYAN + createLine("╚", "═", "╝", GOODBYE_BOX_WIDTH) + RESET);
            
            TimeUnit.MILLISECONDS.sleep(200);
        }
        
        TimeUnit.MILLISECONDS.sleep(1000);
    }
}