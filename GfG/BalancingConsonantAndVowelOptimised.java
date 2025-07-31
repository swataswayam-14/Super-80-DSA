import java.util.HashSet;
import java.util.Set;

public class BalancingConsonantAndVowelOptimised {
    public static void main(String[] args) {
        String arr[] = new String[]{"aeio", "aa", "bc", "ot", "cdbd"};
        System.out.println(totalBalancedStrings(arr));
    }
    public static int totalBalancedStrings(String arr[]) {
        if(arr == null || arr.length == 0) return 0;
        Set<Character> vowels = new HashSet<>();

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        //precomputing number of vowels and consonants for each string

        int[] vowelsCount = new int[arr.length];
        int[] consonantCount = new int[arr.length];

        for(int i=0;i<arr.length;i++) {
            for(char c: arr[i].toCharArray()) {
                if(vowels.contains(c)) {
                    vowelsCount[i]++;
                }
            }
            consonantCount[i] = arr[i].length() - vowelsCount[i];
        }
        int totalCount = 0;

        for(int i=0;i<arr.length;i++) {
            int cumulativeVowelCount = 0, cumulativeConsonantCount = 0;
            for(int j=i;j<arr.length;j++) {
                cumulativeVowelCount += vowelsCount[j];
                cumulativeConsonantCount += consonantCount[j];
                if(cumulativeConsonantCount == cumulativeVowelCount) {
                    totalCount++;
                }
            }
        }
        return totalCount;
    }
}
