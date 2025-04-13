package SlidingWindowAndTwoPointer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithKDiffInteger {
    public int findLongestSubArrayBetter_i(int arr[] , int k) {
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            int n1 = Integer.MIN_VALUE;
            int n2 = Integer.MIN_VALUE;
            int n3 = Integer.MIN_VALUE;
            int distinctCount = 0;
            for (int j = i; j < arr.length; j++) {
                int num = arr[j];

                if (num == n1 || num == n2 || num == n3){
                    //do nothing
                } else if(n1 == Integer.MIN_VALUE) {
                    n1 = num;
                    distinctCount++;
                } else if(n2 == Integer.MIN_VALUE) {
                    n2 = num;
                    distinctCount++;
                } else if(n3 == Integer.MIN_VALUE) {
                    n3 = num;
                    distinctCount++;
                } else break;
                if(distinctCount == k) {
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength;
    }
    public int findLongestSubArrayBrute(int arr[], int k) {
        int n = arr.length;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> mpp = new HashMap<>();
            for (int j = i; j < n; j++) {
                mpp.put(arr[j], mpp.getOrDefault(arr[j], 0) + 1);
                if (mpp.size() == k) maxLength = Math.max(maxLength, j-i+1);
                if (mpp.size() > k) break;
            }
        }
        return maxLength;
    }
    public static void main(String[] args) {
        LongestSubArrayWithKDiffInteger solver = new LongestSubArrayWithKDiffInteger();
        int[] arr = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println("Longest Subarray with " + k + " distinct integers: " + solver.findLongestSubArrayBrute(arr, k));
        System.out.println("Longest Subarray with " + k + " distinct integers: " + solver.findLongestSubArrayBetter_i(arr, k));
    }
}
