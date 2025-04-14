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
    public int findNumberOfSubArrayBetter_i(int arr[] , int k) {
        int count = 0;
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
                    count++;
                }
            }
        }
        return count;
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
    public int findNumberOfSubArrayBrute(int arr[], int k) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> mpp = new HashMap<>();
            for (int j = i; j < n; j++) {
                mpp.put(arr[j], mpp.getOrDefault(arr[j], 0) + 1);
                if (mpp.size() == k) count++;
                if (mpp.size() > k) break;
            }
        }
        return count;
    }
    public int findNumberOfSubArrayOptimal(int arr[], int k) {
        int count = 0;
        int l=0;
        int r=0;
        Map<Integer, Integer> mpp = new HashMap<>();
        while(r<arr.length) {
            mpp.put(arr[r], mpp.getOrDefault(arr[r], 0) + 1);
            while(mpp.size() > k) {
                mpp.put(arr[l], mpp.getOrDefault(arr[l], 0) - 1);
                if (mpp.get(arr[l]) == 0) mpp.remove(arr[l]);
                l = l+1;
            }
            count = count + (r-l+1);
            r = r+1;
        }
        return count;
    }
    public static void main(String[] args) {
        LongestSubArrayWithKDiffInteger solver = new LongestSubArrayWithKDiffInteger();
        int[] arr = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println("Longest Subarray with " + k + " distinct integers: " + solver.findLongestSubArrayBrute(arr, k));
        System.out.println("Longest Subarray with " + k + " distinct integers: " + solver.findLongestSubArrayBetter_i(arr, k));
        System.out.println("The number of sub arrays having "+k+ " distinct integers: "+solver.findNumberOfSubArrayBetter_i(arr, k));
        System.out.println("The number of sub arrays having "+k+ " distinct integers: "+solver.findNumberOfSubArrayBrute(arr, k));
        System.out.println("The number of sub arrays having "+k+ " distinct integers: "+(solver.findNumberOfSubArrayOptimal(arr, k) - solver.findNumberOfSubArrayOptimal(arr, k-1)));
    }
}
