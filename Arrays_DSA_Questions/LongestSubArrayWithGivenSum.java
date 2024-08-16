package Arrays_DSA_Questions;

import java.util.HashMap;

public class LongestSubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] a = {2, 3, 5, 1, 9};
        long k = 10;
        int len = getLongestSubarrayBrute_i(a, k);
        System.out.println("The length of the longest subarray is: " + len);
        System.out.println("The length of the longest subarray is: " + getLongestSubarrayBrute_ii(a, k));
        System.out.println("The length of the longest subarray is: " + getLongestSubarrayBetter(a, k));
        System.out.println("The length of the longest subarray is: " + getLongestSubarrayOptimal(a, k));
    }
    static int getLongestSubarrayBrute_i(int []arr, long k) {
        int n = arr.length;
        int len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long s = 0;
                for (int l = i; l <= j; l++) {
                    s += arr[l];
                }
                if (s == k){
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }
    static int getLongestSubarrayBrute_ii(int arr[], long k) {
        int len = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if(sum == k) {
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len;
    }
    static int getLongestSubarrayBetter(int []arr, long k) {
        int n = arr.length;
        HashMap<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if(sum == k) {
                maxLen = Math.max(maxLen, i+1);
            }
            long rem = sum - k;
            if(preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            if(!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }
        return maxLen;
    }
    static int getLongestSubarrayOptimal(int arr[], long k) {
        int n = arr.length;
        int left = 0, right = 0;
        long sum = arr[0];
        int maxLen = 0;
        while(right < n) {
            while(left<=right && sum > k) {
                sum -= arr[left];
                left++;
            }
            if(sum == k) {
                maxLen = Math.max(maxLen, right-left+1);
            }
            right ++;
            if(right < n) sum += arr[right];
        }
        return maxLen;
    }
} 
