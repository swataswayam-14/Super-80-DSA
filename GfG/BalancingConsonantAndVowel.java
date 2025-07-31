import java.util.HashSet;
import java.util.Set;

public class BalancingConsonantAndVowel {
    public static void main(String[] args) {
        String arr[] = new String[]{"aeio", "aa", "bc", "ot", "cdbd"};
        System.out.println(countBalanced(arr));
    }

    public static int countBalanced(String[] arr){
        if(arr == null || arr.length == 0) {
            return 0;
        }
        int totalCount = 0;
        for(int i=0;i<arr.length;i++) {
            String str = "";
            for(int j=i;j<arr.length;j++) {
                str += arr[j];
                if(checkBalanced(str)) totalCount++;
            }
        }
        return totalCount;
    }

    private static boolean checkBalanced(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int countOfVowels = 0;
        for(int i=0;i<s.length();i++) {
            if(set.contains(s.charAt(i))) countOfVowels++;
        }

        return countOfVowels == s.length() - countOfVowels;
    }
}
