package Arrays_DSA_Questions.Hard;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 0, -4, -5};
        int answer1 = maxProductBrute(arr);
        int answer2 = maxProductBetter(arr);
        int answer3 = maxProductOptimal(arr);
        System.out.println("The maximum product subarray is: " + answer1);
        System.out.println("The maximum product subarray is: " + answer2);
        System.out.println("The maximum product subarray is: " + answer3);
    }
    static int maxProductBrute(int arr[]) { // T.C is O(n^3) and S.C is O(1)
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int product = 1;
                for (int k = i; k <= j; k++) {
                    product *= arr[k];
                }
                max = Math.max(max, product);
            }
        }
        return max;
    }
    static int maxProductBetter(int arr[]) { // T.C is O(n^2) and S.C is O(1)
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int product = 1;
            for (int j = i; j < arr.length; j++) {
                product *= arr[j];
            }
            max = Math.max(max, product);
        }
        return max;
    }
    static int maxProductOptimal (int arr[]) { // T.C is O(n) and S.C is O(1)
        int pref = 1;
        int suff = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (pref == 0) pref = 1;
            if (suff == 0) suff = 1;
            pref *= arr[i];
            suff *= arr[arr.length - i - 1];
            max = Math.max(max, Math.max(pref, suff));
        }
        return max;
    }
}
