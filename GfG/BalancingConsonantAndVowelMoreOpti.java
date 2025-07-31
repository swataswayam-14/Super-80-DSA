import java.util.HashMap;
import java.util.Map;

public class BalancingConsonantAndVowelMoreOpti {
    public static int countBalanced(String[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int[] prefixSum = new int[n+1];

        prefixSum[0] = 0;

        for(int i=0;i<n;i++) {
            int balance = getBalance(arr[i]);
            prefixSum[i+1] = prefixSum[i] + balance;
        }
        int count = 0;
        Map<Integer, Integer> sumCount = new HashMap<>();
        for(int i=0;i<=n;i++) {
            int currentSum = prefixSum[i];
            count += sumCount.getOrDefault(currentSum, 0);

            sumCount.put(currentSum, sumCount.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }

    private static int getBalance(String s) {
        int vowels = 0;
        int len = s.length();

        for(int i=0;i<len;i++) {
            char c = s.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c== 'o' || c == 'u') vowels++;
        }

        int consonants = len - vowels;
        return vowels - consonants;
    }
}
