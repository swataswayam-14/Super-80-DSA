package DSA_Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem Statement
// Given two strings s and p, return all starting indices of p's anagrams in s.
// Anagram: A word formed by rearranging the letters of another (same characters and frequency, order doesn't matter).

//Find all substrings of s that are anagrams of p, and return their starting indices.



//sliding window of size = length of p
// freq array of size 26 (lowercase a-z)
//compare if freq of chars in current window matches that of p

//1. freq array of size 26 for both strings
//2. populate character in p
//3. Iterate over s with a sliding window of size p.length()
//      -> for every character i in s : 
            /*
             * add it to sCount
             * remove the character that moves out of the window (if i >= p.length())
             * compare sCount with pCount
             * if equal -> found an anagram -> add starting index
             */
public class FindAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length() < p.length()) return result;

        s = s.toLowerCase();
        p = p.toLowerCase();

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i=0 ;i<p.length(); i++) {
            pCount[p.charAt(i) - 'a'] ++;
        }

        for(int i=0;i<s.length();i++) {
            sCount[s.charAt(i) - 'a'] ++;
            if(i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }
            if(Arrays.equals(pCount, sCount)) {
                result.add(i-p.length() + 1);
            }
        }
        return result;
    }
}
