package Arrays_DSA_Questions.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class SortArrayOfZeroesAndOnes {
    public static void main(String[] args) {
        int arr[] = {1,1,0,0,2,1,0,0,1,1,2,0,1};
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(new Integer[] {0, 2, 1, 2, 0, 1}));
        System.out.println(Arrays.toString(sortBrute(arr)));
        sortOptimal(arr2);
        System.out.println(arr2);
        ArrayList<Integer> arr3 = new ArrayList<>(Arrays.asList(new Integer[] {0, 2, 1, 2, 0, 1}));
        sortBetter(arr3);
        System.out.println(arr3);
    }
    static int[] sortBrute(int arr[]) { //The T.C is O(nlogn)
        Arrays.sort(arr);
        return arr;
    }
    static int[] sortBetter(int arr[]) {
        return arr;
    }
    static void sortOptimal (ArrayList<Integer> arr) { //[1,1,0,0,2,1,0,0,1,1,1,2,0]
        //T.C is O(n) and S.C is O(1)
        int low = 0, mid = 0, high = arr.size() - 1;
        while (mid <= high) {
            if (arr.get(mid) == 0) {
                int temp = arr.get(low);
                arr.set(low, arr.get(mid));
                arr.set(mid, temp);

                low++;
                mid++;
            } else if (arr.get(mid) == 1) {
                mid ++;
            } else {
                int temp = arr.get(mid);
                arr.set(mid, arr.get(high));
                arr.set(high, temp);

                high --;
            }
        }
    }
    static void sortBetter(ArrayList<Integer> arr) {
        int n = arr.size();
        int ctn_0 = 0;
        int ctn_1 = 0;
        int ctn_2 = 0;
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == 0){
                ctn_0++;
            } else if (arr.get(i) == 1) {
                ctn_1++;
            } else {
                ctn_2++;
            }
        }
        for (int i = 0; i < ctn_0; i++) {
            arr.set(i, 0);
        }
        for (int i = ctn_0; i < ctn_0 + ctn_1; i++) {
            arr.set(i, 1);
        }
        for (int i = ctn_0+ ctn_1; i < n; i++) {
            arr.set(i,2);
        }
    }
}
