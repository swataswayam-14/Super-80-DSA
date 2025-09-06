public class SubArraySumThreshold {
/* You are given an array arr[] of size n and integers k and threshold.
Return true if there exists a contiguous subarray of size k whose sum is greater than or equal to threshold, else return false. */   
    public static boolean isExists(int arr[], int k, int threshold){
        if(arr.length < k) {
            return false;
        }
        int sum = 0;
        for(int i=0;i<k;i++) {
            sum += arr[i];
        }
        if(sum >= threshold) return true;

        for(int i=k;i<arr.length;i++) {
            sum = sum + arr[i] - arr[i-k];
            if(sum >= threshold) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 5};
        System.out.println(isExists(arr, 2, 7));
    }
}
