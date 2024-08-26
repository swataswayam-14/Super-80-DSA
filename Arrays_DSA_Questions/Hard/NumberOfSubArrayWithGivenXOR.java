package Arrays_DSA_Questions.Hard;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubArrayWithGivenXOR {
    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4};
        int k = 6;
        int ans1 = countNumberOfSubArraysBrute(a, k);
        int ans2 = countNumberOfSubArraysBetter(a, k);
        int ans3 = countNumberOfSubArraysOptimal(a, k);
        System.out.println("The number of subarrays with XOR k is: " + ans1);
        System.out.println("The number of subarrays with XOR k is: " + ans2);
        System.out.println("The number of subarrays with XOR k is: " + ans3);
    }
    static int countNumberOfSubArraysBrute(int arr[], int xor) { // T.C is O(n^3) and S.C is O(1)
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int xorr = 0;
                for (int k = i; k<=j; k++) {
                    xorr = xorr ^ arr[k];
                }
                if (xorr == xor) {
                    count++;
                }
            }
        }
        return count;
    }
    static int countNumberOfSubArraysBetter(int arr[], int xor) { // T.C is O(n^2) and S.C is O(1)
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int xorr = 0;
            for (int j = i; j < arr.length; j++) {
                xorr = xorr ^ arr[j];
                if (xorr == xor) {
                    count++;
                }
            }
        }
        return count;
    }
    static int countNumberOfSubArraysOptimal(int arr[], int xor) { // T.C is O(nlogn) and S.C is O(1)
        int count = 0;
        int xr = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(xr, 1);

        for (int i = 0; i < arr.length; i++) {
            xr = xr ^ arr[i];

            int x = xr ^ xor;
            if (mpp.containsKey(x)) {
                count += mpp.get(x);
            }
            if (mpp.containsKey(xr)) {
                mpp.put(xr,mpp.get(xr)+1);
            } else {
                mpp.put(xr, 1);
            }
        }
        return count;
    }
}
