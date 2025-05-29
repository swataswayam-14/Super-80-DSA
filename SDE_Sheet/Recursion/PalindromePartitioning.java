package SDE_Sheet.Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        func(0,s,path,res);
        return res;
    }
    void func(int index, String s, List<String>path, List<List<String>> res) {
        if (index == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=index; i<s.length();i++) {
            if (isPalidrome(s, index, i)) {
                path.add(s.substring(index, i+1));
                func(i+1, s, path, res);
                path.remove(path.size()-1);
            }
        }
    }
    boolean isPalidrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        PalindromePartitioning solver = new PalindromePartitioning();

        // Test case 1: Basic palindrome test
        String input1 = "aab";
        System.out.println("Palindrome partitions for 'aab':");
        printPartitions(solver.partition(input1));

        // Test case 2: Single character
        String input2 = "a";
        System.out.println("\nPalindrome partitions for 'a':");
        printPartitions(solver.partition(input2));

        // Test case 3: All characters the same
        String input3 = "aaa";
        System.out.println("\nPalindrome partitions for 'aaa':");
        printPartitions(solver.partition(input3));

        // Test case 4: Mixed case
        String input4 = "racecar";
        System.out.println("\nPalindrome partitions for 'racecar':");
        printPartitions(solver.partition(input4));

        // Test case 5: No palindrome except single letters
        String input5 = "abc";
        System.out.println("\nPalindrome partitions for 'abc':");
        printPartitions(solver.partition(input5));
    }

    private static void printPartitions(List<List<String>> partitions) {
        for (List<String> part : partitions) {
            System.out.println(part);
        }
    }
}