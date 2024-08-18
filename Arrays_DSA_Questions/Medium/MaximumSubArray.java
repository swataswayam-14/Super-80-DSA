package Arrays_DSA_Questions.Medium;

import java.util.ArrayList;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum1 = maxSubArraySumBrute(arr);
        int maxSum2 = maxSubArraySumBetter(arr);
        int maxSum3 = maxSubArraySumOptimal(arr);
        System.out.println("The maximum subarray sum is: " + maxSum1);
        System.out.println("The maximum subarray sum is: " + maxSum2);
        System.out.println("The maximum subarray sum is: " + maxSum3);
        System.out.println("The subarray having the maximum sum is: "+printSubArrayWithMaxSum(arr));
    }
    static int maxSubArraySumBrute(int arr[]) { // T.C is O(n^3) and S.C is O(1)

        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
    static int maxSubArraySumBetter(int arr[]) { // T.C is O(n^2) and S.C is O(1)
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
    static int maxSubArraySumOptimal(int arr[]) { // T.C is O(n) and S.C is O(1)
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum < 0) {
                sum = 0;
            }
            if (sum > 0) {
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
    static ArrayList<Integer> printSubArrayWithMaxSum(int arr[]) {
        ArrayList<Integer> maxSubArray = new ArrayList<>();
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if(sum < 0) {
                maxSubArray.clear();
                sum = 0;
            } else if (sum > 0) {
                maxSum = Math.max(maxSum, sum);
                maxSubArray.add(arr[i]);
            }
        }
        return maxSubArray;
    }
}
