package ArraysAndHashing;
public class KadanesAlgo {
    //brute force -> T.C :  O(n cube) and S.C: O(1)
    public static int maxSubarraySumbruteforce(int [] arr, int n) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k < j; k++) {
                    sum += arr[k];
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }
    public static int maxSubarraySumOptimal(int [] arr , int n) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
    public static long maxSubarraySumMostOptimal(int[] arr, int n) {
        long max = Long.MIN_VALUE;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if(sum > max) {
                max = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int [] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int n = arr.length;
        long maxSum = maxSubarraySumMostOptimal(arr, n);
        System.out.println("The maximum sub array sum is: "+maxSum);
    }
}
