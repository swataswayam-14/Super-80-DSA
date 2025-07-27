// Problem Statement
// Given two strings s and t, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return "".


//Key Concepts
// Sliding Window: Expand and contract a window over s.

// Character Frequency Mapping: Track characters in t and the current window.

//intuition 
//You're scanning s and trying to find the smallest substring that contains all characters of t.
// You keep extending the right of the window to include all necessary characters, and then shrink the left to minimize the window while still keeping all characters of t.

// Use two hash maps:

// need: Frequency of characters in t.

// window: Frequency of characters in current window in s.

// Use two pointers left and right to represent window bounds.

// Expand right until all characters are covered.

// Then, move left to minimize the window while keeping it valid.

// Track the minimum window during the process.

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowString {
    public static String minWindow(String s,String t) {
        if(s == null || t == null|| s.length() < t.length()) return "";
        Map<Character, Integer> need = new HashMap<>();
        for(char c: t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1);
        Map<Character, Integer> window = new HashMap<>();

        int have = 0, needCount = need.size();
        int left = 0, minLen = Integer.MAX_VALUE;
        int start = 0;
        for(int right = 0; right < s.length();right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0)+1);
            if(need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                have++;
            }
            while(have == needCount) {
                if((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
            }
            char lChar = s.charAt(left);
            window.put(lChar, window.get(lChar) - 1);
            if (need.containsKey(lChar) && window.get(lChar).intValue() < need.get(lChar).intValue()) {
                have--;
            }
            left++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
