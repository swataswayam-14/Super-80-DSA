package DSA_Test;

public class CheckForPalindrome {
    public static boolean isPalindrome(int n) { 
        int temp = n;
        int rev = 0;
        while(n != 0) {
            int lastDigit = n%10;
            rev = rev*10 + lastDigit;
            n = n/10;
        }
        return rev == temp;
    }
    
}
