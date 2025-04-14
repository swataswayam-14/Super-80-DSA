package SlidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKMostDistinctChar {
    public static int findLongest(String s, int k) {
        Map<Character, Integer> mpp = new HashMap<>();
        int len = 0;
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            mpp.clear();
            len = 0;
            for (int j = i; j < s.length(); j++) {
                char ch = s.charAt(j);   
                mpp.put(ch, mpp.getOrDefault(ch, 0)+ 1);
                len++;
                if(mpp.size() <= k) maxlen = Math.max(maxlen, len);
                else break;
            }
        }
        return maxlen;
    }
    public static int findLongestOptimal(String s, int k) {
        int l = 0, r = 0;
        int maxLen = 0;
        Map<Character, Integer> mpp = new HashMap<>();
    
        while (r < s.length()) {
            char ch = s.charAt(r);
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
    
            while (mpp.size() > k) {
                char c = s.charAt(l);
                mpp.put(c, mpp.get(c) - 1);
                if (mpp.get(c) == 0) {
                    mpp.remove(c);
                }
                l++;
            }
    
            if (mpp.size() <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
    
            r++;
        }
    
        return maxLen;
    }    
    public static int findLongestMostOptimal(String s, int k) {
        int l = 0, r = 0;
        int maxLen = 0;
        Map<Character, Integer> mpp = new HashMap<>();
    
        while (r < s.length()) {
            char ch = s.charAt(r);
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
    
            if(mpp.size() > k) {
                char c = s.charAt(l);
                mpp.put(c, mpp.get(c) - 1);
                if (mpp.get(c) == 0) {
                    mpp.remove(c);
                }
                l++;
            }
    
            if (mpp.size() <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
    
            r++;
        }
    
        return maxLen;
    }    
    public static void main(String[] args) {
        String testString = "abcba";
        String tesString2 = "aabbbccdd";
        int k = 2;

        int result = findLongest(testString, k);
        System.out.println("Longest substring length with at most " + k + " distinct characters: " + result);
        System.out.println("Longest substring length with at most 2 distinct characters: " + findLongest(tesString2, k));
        System.out.println("Longest substring length with at most 2 distinct characters: " + findLongestOptimal(tesString2, k));
        System.out.println("Longest substring length with at most 2 distinct characters: " + findLongestMostOptimal(tesString2, k));
    }
}
