package Arrays_DSA_Questions;

import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicated {
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,3,3,4,4,5,5,6,7,7,7,9};
        System.out.println(Arrays.toString(removeDuplicatesArr(arr)));
        System.out.println(removeDuplicatesBruteForce(arr));
        System.out.println(removeDuplicatesOptimal(arr));
    }
    static int[] removeDuplicatesArr(int arr[]) {
        int newArr[] = new int[arr.length];
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]){
                continue;
            }
            newArr[j] = arr[i-1];
            newArr[j+1] = arr[i];
            j++;
        }
        return newArr;
    }
    static int removeDuplicatesBruteForce(int[] arr) { //T.C is O(nlogn + n) and S.C is O(n)
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int j = 0;
        for (int x: set) {
            arr[j] = x;
            j++;
        }
        return set.size();
    }
    static int removeDuplicatesOptimal(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }
}
