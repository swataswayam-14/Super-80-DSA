package Arrays_DSA_Questions.Medium;

public class CountSubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int k = 6;
        int cnt = countSubArrayBrute(arr, k);
        System.out.println("The number of subarrays is: " + cnt);
        int cnt1 = countSubArrayBetter(arr, k);
        System.out.println("The number of subarrays is: " + cnt1);
    }
    static int countSubArrayBrute(int arr[], int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int j2 = i; j2 < j; j2++) {
                    sum += arr[j2];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
    static int countSubArrayBetter(int arr[], int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
            }
            if (sum == k) {
                count++;
            }
        }
        return count;
    }
}
