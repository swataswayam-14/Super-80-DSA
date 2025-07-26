// You're given a list of strings. Your task is to:

// Group together all strings that are anagrams of each other.

// What is an Anagram?
// Two strings are anagrams if:

// They have the same characters, with the same frequency.

// Their sorted versions are identical.


//Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
//output : [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]

//Input: [""]
//output : [[""]]

//Input : ["a"]
//output: [["a"]]

//Intuition : 
// To group anagrams : 
// for each word, sort the characters ("eat" -> "aet")
// store original words under that key.
// at the end return all groups from the map

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static List<List<String>> groupAnagram(String[] arr) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: arr) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedKey = new String(charArray);
            if(!map.containsKey(sortedKey)) {
                map.put(sortedKey, new ArrayList<>());
            }
            map.get(sortedKey).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
