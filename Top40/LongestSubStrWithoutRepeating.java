// Problem Understanding
// You're given a string s.
// Your task:

// Find the length of the longest substring without repeating characters.

// Important:
// Substring = contiguous characters.

// Characters must be unique within the substring.

//sliding window idea : 
// move right pointer one char at a time
// if s[right] is not in current window -> expand
// if it is already seen -> shrink the window from left

// hashmap <Character, Integer> can be used to store the last index where each character appeared.

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrWithoutRepeating {
    public static int findLongestBrute(String s) {
        int maxlen = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++) {
            for (int j=i;j<s.length();j++) {
                if(hasUnique(s, i, j)) {
                    maxlen = Math.max(maxlen, j-i+1);
                }
            }
        }
        return maxlen;
    }
    private static boolean hasUnique(String s, int start, int end) {
        boolean seen[] = new boolean[256];
        for (int i = start; i <= end; i++) {
            char c = s.charAt(i);
            if(seen[c]) return false;
            seen[c] = true;
        }
        return true;
    }
    public static int findLongestOptimal(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int maxLen = 0;
        int left = 0; // start of the window
        for(int right = 0; right < s.length(); right ++) {
            char currentChar = s.charAt(right);
            if(lastSeen.containsKey(currentChar) && lastSeen.get(currentChar) >= left) left = lastSeen.get(currentChar) + 1;
            // in the if condition it is checked that if previously this element has been found and if this element is inside the window 
            //if yes -> then update the left pointer to shrink the window from the left just enough to remove the duplicate.
            lastSeen.put(currentChar, right);
            maxLen = Math.max(maxLen, right-left + 1);
        }
        return maxLen;
    }
}
