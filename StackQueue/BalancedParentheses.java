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

        sc.close();
    }
}
