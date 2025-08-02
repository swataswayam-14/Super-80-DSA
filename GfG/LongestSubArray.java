import java.util.HashMap;
import java.util.Map;

public class LongestSubArray {
    /*
    Given an array arr[] and an integer k, the task is to find the length of longest subarray in which the count of elements greater than k is more than the count of elements less than or equal to k.
     */
    
    //transforming the problem into : prefix sum and subarrays with positive sum
    /*
    For each element in arr , map it to : 
    -> +1 if arr[i] > k
    -> -1 if arr[i] <= k

    Now the problem becomes : find the longest subarray whose prefix sum is positive
    -> Longest subarray with sum > 0

     */
    public static int longestSubArray(int arr[], int k) {
        int n = arr.length;
        int mapped[] = new int[n];

        for(int i=0;i<n;i++) {
            if(arr[i] > k) {
                mapped[i] = 1;
            } else {
                mapped[i] = -1;
            }
        }

        int prefixSum = 0;
        int maxLength = 0;
        Map<Integer, Integer> firstOccurence = new HashMap<>();

        //prefix sum = 0 at index = -1
        firstOccurence.put(0, -1);
        for(int i=0;i<n;i++) {
            prefixSum += mapped[i];
            if(prefixSum > 0) {
                maxLength = i+1;
            } else {
                if(firstOccurence.containsKey(prefixSum - 1)) {
                    maxLength = Math.max(maxLength, i - firstOccurence.get(prefixSum - 1));
                }
            }
            firstOccurence.putIfAbsent(prefixSum, i);
        }
        return maxLength;
    }
}
