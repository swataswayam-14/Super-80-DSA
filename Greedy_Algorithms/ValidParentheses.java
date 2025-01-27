package Greedy_Algorithms;

public class ValidParentheses {
    public static Boolean isValidBrute(String s, int index, int count) { // T.C is O(3^n) and S.C is O(n) , can be optimsied using DP to make T.C to O(n^2) and S.C to O(n^2)
        if (count < 0) {
            return false;
        }
        if (index == s.length()) {
            return count == 0;
        }
        if (s.charAt(index) == '(') {
            return isValidBrute(s, index + 1, count + 1);
        }
        if (s.charAt(index) == ')') {
            return isValidBrute(s, index+1, count-1);
        }
        return (isValidBrute(s, index+1, count+1) || isValidBrute(s, index+1, count-1)|| isValidBrute(s, index+1, count));
    }
    public static Boolean isValidOptimal (String s) {
        int min = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                min+=1;
                max+=1;
            } else if(s.charAt(i) == ')') {
                min -= 1;
                max -= 1;
            } else {
                min -= 1;
                max += 1;
            }
            if (min < 0) {
                min = 0;
            }
            if (max < 0) {
                return false;
            }
        }
        return min == 0;
    }
    public static void main(String[] args) {
        String s = "((**)*)))";
        System.out.println(isValidBrute(s, 0, 0));
        System.out.println(isValidOptimal(s));
    }
}
