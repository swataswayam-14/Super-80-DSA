package Arrays_DSA_Questions.Medium;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int arr[] = {1,5,6,8,10};
        int target = 15;

        System.out.println(TwoSumBrute_i_v_1(arr, target));
        System.out.println(TwoSumBrute_ii_v_1(arr, target));
        System.out.println(TwoSumBetter_v1(arr, target));
        System.out.println(TwoSumOptimal(arr, target));
        System.out.println(Arrays.toString(TwoSumBrute_i_v_2(arr, target)));
        System.out.println(Arrays.toString(TwoSumBrute_ii_v_2(arr, target)));
        System.out.println(Arrays.toString(TwoSumBetter_v2(arr, target)));
    }
    static String TwoSumBrute_i_v_1(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum = arr[i] + arr[j];
                if(sum == target) {
                    return "YES";
                }
            }
        }
        return "NO";
    }
    static String TwoSumBrute_ii_v_1(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i+1; j < arr.length; j++) {
                sum = arr[i] + arr[j];
                if(sum == target) {
                    return "YES";
                }
            }
        }
        return "NO";
    }
    //the brute takes the time complexity of O(n^2)
    static int[] TwoSumBrute_i_v_2(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum = arr[i] + arr[j];
                if(sum == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[] {-1,-1};
    }
    static int[] TwoSumBrute_ii_v_2(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i+1; j < arr.length; j++) {
                sum = arr[i] + arr[j];
                if(sum == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[] {-1,-1};
    }

    static String TwoSumBetter_v1(int arr[], int target) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            int leftSum = target - sum;
            if (mpp.containsKey(leftSum)) {
                return "YES";
            } else {
                mpp.put(sum, i);
            }
        }
        return "NO";
    }
    //the better solution takes a T.C of O(nlogn) and a space complexity of O(n)
    static int[] TwoSumBetter_v2(int arr[], int target) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            int leftSum = target - sum;
            if (mpp.containsKey(leftSum)) {
                return new int[] {i, mpp.get(leftSum)};
            } else {
                mpp.put(sum, i);
            }
        }
        return new int[]{-1,-1};
    }
    //the optimal solution takes a T.C of O(n) and a S.C of O(1)
    static String TwoSumOptimal(int arr[], int target) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return "YES";
            } else if (sum < target) {
                left++;
            } else {
                right --;
            }
        }
        return "NO";
    }
}
