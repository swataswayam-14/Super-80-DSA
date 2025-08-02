package ArrayProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MissingAndRepeating {
    public static int[] findMissingAndRepeating(int arr[]) {

        int res[] = new int[]{-1,-1};
        if(arr == null || arr.length == 0) {
            return res;
        }
        int n = arr.length;
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i=0;i<n;i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> el : freq.entrySet()) {
            if(el.getValue() == 2) res[0] = el.getKey();
        }
        for(int i=1;i<=n;i++) {
            if(!freq.containsKey(i)) {
                res[1] = i;
            }
        }
        return res;
    }
    public static int[] findMissingAndRepeatingOptimised(int arr[]) {
        if(arr == null || arr.length == 0) {
            return new int[]{-1,-1};
        }
        int result [] = new int[2];

        //[1,2,2,3]
        /*
         * val = 1
         * arr[0] = -1
         * 
         * i=1
         * val = 2
         * arr[1]!< 0
         * arr[1] = -2
         * 
         * i=2
         * val = arr[2]
         * val = 2
         * arr[1] = -2
         * arr[1] < 0
         * hence val is repeating
         * 
         * 
         * i=3
         * val = arr[3]
         * val = 3
         * arr[2] = 2
         * arr[2] = -2
         */

        int n = arr.length;
        for(int i=0;i<n;i++) {
            int val = Math.abs(arr[i]);
            if(arr[val-1] < 0) {
                result[0] = val;
            } else {
                arr[val - 1] = -arr[val-1];
            }
        }
        for(int i=0;i<n;i++) {
            if(arr[i] > 0) result[1] = i+1;
        }
        return result;
    }

     public static int[] findMissingAndRepeatingOptimised_ii(int[] arr) {
        int n = arr.length;
        boolean[] vis = new boolean[n + 1];

        int repeating = -1, missing = -1;

        for (int i = 0; i < n; i++) {
            int el = arr[i];
            // check range safety
            if (el >= 1 && el <= n) {
                if (vis[el]) {
                    repeating = el; 
                } else {
                    vis[el] = true;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                missing = i;
                break;
            }
        }

        return new int[]{repeating, missing};
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,2,3};
        int res[] = new int[2];
        int res1[] = new int[2]; 
        int res2[] = new int[2];
        res = findMissingAndRepeating(arr);
        System.out.println(res[0] +" " + res[1]);
        res1 = findMissingAndRepeatingOptimised(arr);
        System.out.println(res1[0] +" " + res1[1]);
        res2 = findMissingAndRepeatingOptimised_ii(arr);
        System.out.println(res2[0] +" " + res2[1]);
    }
}
