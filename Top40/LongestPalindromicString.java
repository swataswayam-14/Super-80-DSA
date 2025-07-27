public class LongestPalindromicString {
    //Given a string s, return the longest palindromic substring in s.
    public static String findLongestPalindromic(String s) {
        String res = s.substring(0,1);
        int maxlen = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                String subStr = s.substring(i, j+1);
                if(checkPalindrome(subStr) && maxlen < j-i) {
                    res = subStr;
                    maxlen = j-i;
                }
            }
        }
        return res;
    }
    private static boolean checkPalindrome(String s) {
        int start = 0;
        int end = s.length() -1;
        while(start <= end) {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end --;
        }
        return true;
    }
}
