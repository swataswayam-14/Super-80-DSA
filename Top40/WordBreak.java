// Problem: Word Break
// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.


//concepts : 
// -> substring generation
// -> recursive backtracking(brute force)
// -> dynamic programming (optimised)

//brute force : 
//try every possible prefix and recursively check if the suffix can be broken into dictionary words. This creates a decision tree of all valid segementations

//T.C : O(2^n)


// Optimized Approach (Dynamic Programming)
// Intuition:
// Use a boolean dp[i] to represent whether the substring s[0...i-1] can be segmented using dictionary words.

// For every i, check all substrings s[j...i-1] and see if dp[j] is true and s[j...i] is in the dictionary.

// Time Complexity:
// O(n²) substring generation × O(1) lookups with HashSet → O(n²)

// Space: O(n) for the DP array

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        return backtrack(s,wordDict,0);
    }
    private static boolean backtrack(String s, List<String> wordDict, int start) {
        if(start == s.length()) return true;
        for(int end = start+1; end <= s.length(); end++) {
            String sub = s.substring(start, end);
            if(wordDict.contains(sub) && backtrack(s, wordDict, end)) return true;
        }
        return false;
    }
    public static boolean wordBreakOptimised(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i=1;i<=s.length();i++) {
            for(int j=0;j<i;j++) {
                if(dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
