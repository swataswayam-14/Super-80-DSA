package Arrays_DSA_Questions.Medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans = majorityElementBrute(arr);
        int ans2 = majorityElementBetter(arr);
        int ans3 = majorityElementOptimal(arr);
        System.out.println("The majority element is: " + ans);
        System.out.println("The majority element is: " + ans2);
        System.out.println("The majority element is: " + ans3);
    }
    static int majorityElementBrute(int arr[]) { //T.C: O(n^2) and S.C is O(1)
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if(count > n/2) {
                return arr[i];
            }
        }
        return -1;
    }
    static int majorityElementBetter(int arr[]) { //T.C is O(nlogn) and S.C is O(n)
        int n = arr.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(arr[i], 0);
            mpp.put(arr[i], value+1);
        }
        for(Map.Entry<Integer, Integer> it: mpp.entrySet()) {
            if (it.getValue() > n/2) {
                return it.getKey();
            }
        }
        return -1;
    }
    static int majorityElementOptimal(int arr[]) { //T.C is O(2n) and S.C is O(1)
        int n = arr.length;
        int count = 0;
        int majorityElement = 0;

        for (int i = 0; i < n; i++) {
            if (count == 0) {
                count = 1;
                majorityElement = arr[i];
            } else if(majorityElement == arr[i]) {
                count ++;
            } else count--;
        }
        int countIfMajority = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == majorityElement) {
                countIfMajority++;
            }
        }
        if (countIfMajority > n/2) {
            return majorityElement;
        }
        return -1;
    }
}
