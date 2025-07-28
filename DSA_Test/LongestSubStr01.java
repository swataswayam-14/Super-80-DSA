package DSA_Test;

import java.util.HashMap;
import java.util.Map;

// Longest Substring with Equal Number of 0s and 1s
// Given a binary string, return the length of the longest contiguous substring with equal number of 0s and 1s.

// Concepts: Prefix Sum + HashMap

// Hint: Treat 0 as -1 and find longest subarray with sum = 0.


//brute force : find all the subarrays , count the number of 0s and 1s , if they are equal update the maxlength according to the subarray length if its greater

public class LongestSubStr01 {
    public static int longestString(String s) {
        int[] arr = new int[s.length()];
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            arr[i] = c == '0' ? 0 : 1;
        }
        int maxlen = 0;
        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++) {
                if(valid(arr,i,j)) {
                    maxlen = Math.max(maxlen, j-i+1);
                }
            }
        }
        return maxlen;
    }
    public static boolean valid(int arr[], int start, int end) {
        int countOfOne = 0;
        int countOfZero = 0;
        while(start <= end) {
            if(arr[start] == 0) countOfZero++;
            else if(arr[start] == 1) countOfOne++;
            start++;
        }
        return countOfOne == countOfZero;
    }
    //better solution : treating 0 as -1 and finding the maxlength of the array which has 0 sum
    //steps : 
    /*
    1. convert the string to character to integer array  , make 0 as -1 and 1 as 1
    2. find each sub array and there sum , if (sum == 0) check the length , if its > maxlength then update the maxlength
     */
    public static int longestStringBetter(String s) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[i] = c == '0' ? -1 : 1;
        }
        int maxlen = 0;
        for(int i=0;i<arr.length;i++) {
            int sum = 0;
            for(int j=i;j<arr.length;j++) {
                sum += arr[j];
                if(sum == 0) {
                    maxlen = Math.max(maxlen, j-i+1);
                }
            }
        }
        return maxlen;
    }
/*
Optmised Approach: 
-> prefix sum : loop through the string maintaining a sum that adds +1 for '1' and -1 for '0'.
-> hashmap : store the first index where each prefix sum was seen
Reason : 
 -> if the same prefix sum occurs again later, it means the elements in between have sum = 0
 -> so we found an array with equal 0s and 1s
 */
    public static int longestStringOptmised(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxlen = 0;
        int sum = 0;

        map.put(0,-1);

        for(int i=0;i<s.length();i++) {
            sum += s.charAt(i) == '0' ? -1 : 1;
            if(map.containsKey(sum)) {
                int prevIndex = map.get(sum);
                maxlen = Math.max(maxlen, i-prevIndex);
            } else {
                map.put(sum, i);
            }
        }
        return maxlen;
    }
}
