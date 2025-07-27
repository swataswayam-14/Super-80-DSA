import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Map<Character, Character> mpp = new HashMap<>();
        mpp.put('(', ')');
        mpp.put('{', '}');
        mpp.put('[', ']');

        char[] charArray = s.toCharArray();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if(mpp.containsKey(ch)) st.push(ch);
            else if(mpp.containsValue(ch)) { 
                if(st.isEmpty()) return false;
                char c = st.pop();
                if(mpp.get(c) != ch) return false;
            }
        }
        return st.isEmpty();
    }
}
