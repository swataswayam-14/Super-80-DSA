import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        return Arrays.equals(s1, s2);
    }
    public static boolean isAnagramOptimised(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            freq[c1-'a']++;
            freq[c2-'a']--;    
        }       
        for (int i : freq) {
            if(i!=0) return false;
        }
        return true;
    }
    public static boolean isAnagramOptimisedII(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if(!freqMap.containsKey(t.charAt(i))) return false;
            freqMap.put(t.charAt(i), freqMap.getOrDefault(t.charAt(i), 0) - 1);
            if(freqMap.get(t.charAt(i)) == 0) freqMap.remove(t.charAt(i));
        }
        
        return freqMap.isEmpty();
    }
}
