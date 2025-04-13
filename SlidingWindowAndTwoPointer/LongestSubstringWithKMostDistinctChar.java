package SlidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKMostDistinctChar {
    public static int findLongest(String s, int k) {
        Map<Character, Integer> mpp = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            mpp.put((char) i, 0);
        }
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
    public static void main(String[] args) {
        String testString = "abcba";
        String tesString2 = "aabbbccdd";
        int k = 2;

        int result = findLongest(testString, k);
        System.out.println("Longest substring length with at most " + k + " distinct characters: " + result);
        System.out.println("Longest substring length with at most 2 distinct characters: " + findLongest(tesString2, k));
    }
}
