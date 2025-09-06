package DSA_Test;

import java.util.HashMap;
import java.util.Map;

public class MinimumSizeSubArrSum {
    /*
     Minimum Size Subarray Sum
    Given an array of positive integers and a target sum, return the minimum length of a subarray whose sum ≥ target.

    Concepts: Sliding Window

    Constraint: Optimize to O(n)
     */

    public static int minLengthBrute(int arr[], int target) {
        int minlength = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++) {
            int currSum = 0;
            for(int j=i;j<arr.length;j++) {
                currSum += arr[j];
                if(currSum >= target) {
                    minlength = Math.min(minlength, j-i+1);
                }
            }
        }
        return minlength;
    }
    public static int minLengthOptimised(int arr[], int target) {
        int minLength = Integer.MAX_VALUE;
        int currSum = 0;

        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);
        for(int i=0;i<arr.length;i++) {
            currSum += arr[i];
            int complement = currSum - target;

            if(sumMap.containsKey(complement)) {
                int prevIndex = sumMap.get(complement);
                int len = i - prevIndex;
                minLength = Math.min(minLength, len);
            }
            if(!sumMap.containsKey(currSum)) {
                sumMap.put(currSum, i);
            }
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
    public static int minSubArrayMostOptmised(int arr[], int target) {
        int left = 0, sum = 0, minlength = Integer.MAX_VALUE;

        for(int right = 0;right < arr.length;right++) {
            sum += arr[right];
            while(sum >= target) {
                minlength = Math.min(minlength, right - left + 1);
                sum -= arr[left++];
            }
        }
        return minlength == Integer.MAX_VALUE ? -1 : minlength;
    }

}
