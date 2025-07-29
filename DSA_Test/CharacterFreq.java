package DSA_Test;

import java.util.HashMap;
import java.util.Map;

public class CharacterFreq {
    public static Map<Character, Integer> findFreq(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }
        return freq;
    }
}
