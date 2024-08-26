package Arrays_DSA_Questions.Hard;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int arr1[] = {1,2,78,400,512};
        int arr2[] = {6,7,87,90, 976};
        merge(arr1, arr2);
        System.out.println(Arrays.toString(arr1)+" "+Arrays.toString(arr2));
    }
    static void merge(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;

        int left = 0;
        int right = 0;

        int arr3[] = new int[n+m];
        int index = 0;

        while (left < n && right < m) {
            if (arr1[left] <= arr2[right]) {
                arr3[index] = arr1[left];
                left++;
            } else {
                arr3[index] = arr2[right];
                right++;
            }
            index++;
        }
        while (left < n) {
            arr3[index] = arr1[left];
            left++;
            index++;
        }
        while (right < m) {
            arr3[index] = arr2[right];
            right++;
            index++;
        }
        for (int i = 0; i < n+m; i++) {
            if (i<n) {
                arr1[i] = arr3[i];
            }
            else {
                arr2[i-n] = arr3[i];
            }
        }
    }
}
