package Arrays_DSA_Questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class NumberAppearOnce {
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,3,3,4,4,5,5,6};
        System.out.println(findNumberAppearingOnce(arr));
        System.out.println(getSingleElementBruteForce(arr));
        System.out.println(getSingleElementBetter_i(arr));
        System.out.println(getSingleElementOptimal(arr));
    }
    static int findNumberAppearingOnce(int arr[]) { // this works when the elements are sorted in ascending order and difference between the successive bigger and smaller number is 1
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        int lastIndex = arr[arr.length - 1];
        int sumArr = (lastIndex * (lastIndex + 1));
        int missingNumber = sumArr - sum;
        return missingNumber;
    }
    static int getSingleElementBruteForce(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) { //T.C is O(n^2) and S.C is O(1)
            int num = arr[i];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(arr[j] == num) {
                    count ++;
                }
            }
            if (count == 1) {
                return num;
            }
        }
        return -1;
    }
    static int getSingleElementBetter_i(int arr[]) {// T.C is O(3n) and space complexity is O(max)
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        int freq[] = new int[max+1];
        for (int i = 0; i < n; i++) {
            freq[arr[i]] ++;
        }
        for (int i = 0; i < max+1; i++) {
            if (freq[i] == 1) {
                return i;
            }
        }
        return -1;
    }
    static int getSingleElementBetter_ii(int arr[]) { //T.C is O(nlogm) + O(n/2 + 1) and S.C is O(n/2 + 1) for map data structure, here m is the size of the map that is (n/2) + 1
        int n = arr.length; 
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i=0;i<n;i++) {
            int value = mpp.getOrDefault(arr[i], 0); // (get the frequency of the ith index , if not present then return 0)
            mpp.put(arr[i], value+1); //(key, frequency)
        }
        for(Map.Entry<Integer, Integer> it: mpp.entrySet()) {
            if (it.getValue() == 1) {
                return it.getKey();
            }
        }
        return -1;
    }
    static int getSingleElementOptimal(int arr[]) { //T.C is O(n) and S.C is O(1)
        int n = arr.length;
        int xorr = 0;
        for (int i = 0; i < n; i++) {
            xorr = xorr ^ arr[i];
        }
        return xorr;
    }
}
