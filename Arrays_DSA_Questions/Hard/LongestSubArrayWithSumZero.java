package Arrays_DSA_Questions.Hard;

import java.util.HashMap;

public class LongestSubArrayWithSumZero {
    public static void main(String[] args) {
        int arr[] = new int[]{1,-1,2,-2,1,1,2,-4,5,-9,8};
        System.out.println(longestSubArrayWithZeroSumBrute(arr));
        System.out.println(longestSubArrayWithZeroSumOptimal(arr));
    }
    static int longestSubArrayWithZeroSumBrute(int arr[]) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0) {
                    max = Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }
    static int longestSubArrayWithZeroSumOptimal(int arr[]) {
        int maximum = 0;
        int sum = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                maximum = i + 1;
            } else {
                if (mpp.get(sum) != null) {
                    maximum = Math.max(maximum, i-mpp.get(sum));
                } else {
                    mpp.put(sum,i);
                }
            }
        }
        return maximum;
    }
}
