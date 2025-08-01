import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraysWithKSum {
    public static int cntSubArraysBrute(int arr[], int k) {

        int count = 0;

        for(int i=0;i<arr.length;i++) {
            int sum = 0;
            for(int j=i; j<arr.length;j++) {
                sum += arr[j];
                if(sum == k) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int cntSubArraysOptmised(int arr[], int k) {
        Map<Integer, Integer> prefixSumFreq = new HashMap<>();
        prefixSumFreq.put(0, 1); // sum 0 appears once

        int count = 0;
        int sum = 0;

        for(int num: arr) {
            sum += num;
            if(prefixSumFreq.containsKey(sum - k)) {
                count += prefixSumFreq.get(sum - k);
            }
            prefixSumFreq.put(sum, prefixSumFreq.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = new int[] {9, 4, 20, 3, 10, 5};
        int k = 33;
        System.out.println(cntSubArraysBrute(arr, k));
        System.out.println(cntSubArraysOptmised(arr, k));
    }
}
