package DSA_Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CheckForBalancedParanthesis {
    public static boolean isValid(String s) {
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put('(', ')');
        mapping.put('{', '}');
        mapping.put('[', ']');

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(mapping.containsKey(ch)) st.push(ch);
            else if(mapping.containsValue(ch)) {
                if(st.isEmpty() || mapping.get(st.pop()) != ch) return false;
            } else {
                return false;
            }
        }
        return st.isEmpty();
    }
}
