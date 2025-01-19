package StackQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        java.util.Stack<String> stack = new java.util.Stack<>();
        Map<String, String> matchingBraces = new HashMap<>();
        matchingBraces.put("}", "{");
        matchingBraces.put(")", "(");
        matchingBraces.put("]", "[");

        System.out.print("Enter a comma-separated string of parentheses: ");
        String inputStr = sc.nextLine().replace(" ", ""); 

        String[] strArray = inputStr.split(",");
        boolean isValidString = isValid(inputStr);

        for (String brace : strArray) {
            if (matchingBraces.containsValue(brace)) {
                stack.push(brace);
            } 
            else if (matchingBraces.containsKey(brace)) {
                if (stack.isEmpty() || !stack.pop().equals(matchingBraces.get(brace))) {
                    System.out.println("The input string is NOT a valid parentheses sequence.");
                    return;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("The input string is a VALID parentheses sequence.");
        } else {
            System.out.println("The input string is NOT a valid parentheses sequence.");
        }
        if (isValidString){
            System.out.println("The input string is a VALID parentheses sequence.");
        } else {
            System.out.println("The input string is NOT a valid parentheses sequence.");
        }

        sc.close();
    }
    public static boolean isValid(String s) {
        java.util.Stack<Character> st = new java.util.Stack<>();
        String[] elements = s.replace(" ", "").split(",");
        for (String it : elements) {
            char ch = it.charAt(0); 
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            else {
                if (st.isEmpty()) return false; 
                char top = st.pop();
                if (!((ch == ')' && top == '(') || 
                      (ch == '}' && top == '{') || 
                      (ch == ']' && top == '['))) {
                    return false; 
                }
            }
        }
        return st.isEmpty();
    }
}
