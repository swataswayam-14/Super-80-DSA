package StackQueue;

import java.util.Stack;

public class InfixToPostFix {
    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;    
            case '*':
            case '/':
                return 2; 
            case '^':
                return 3;  
        }
        return -1; 
    }
    static String infixToPostFix(String exp) {
        String result = "";
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                result += c;
            }
            else if (c == '('){
                st.push(c);
            }
            else if (c == ')') {
                while (!st.isEmpty() &&
                  st.peek() != '(')
                  result += st.pop();
        
                st.pop();
              } else 
              {
                while (!st.isEmpty() && Prec(c) <=
                  Prec(st.peek())) {
        
                  result += st.pop();
                }
                st.push(c);
              }
        
            }
            while (!st.isEmpty()) {
                if (st.peek() == '(')
                  return "Invalid Expression";
                result += st.pop();
              }
            return result;
        }
        public static void main(String[] args) {
            String exp = "(p+q)*(m-n)";
            System.out.println("Infix expression: " + exp);
            System.out.println("Prefix expression: " + infixToPostFix(exp));
        }
}

