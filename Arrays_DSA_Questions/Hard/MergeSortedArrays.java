package Arrays_DSA_Questions.Hard;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int arr1[] = {1,2,78,400,512};
        int arr2[] = {6,7,87,90, 976};
        //mergeBrute(arr1, arr2);
        //mergeOptimal(arr1, arr2);
        mergeOptimalGapMethod(arr1, arr2);
        System.out.println(Arrays.toString(arr1)+" "+Arrays.toString(arr2));
    }
    static void mergeBrute(int arr1[], int arr2[]) {
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
    static void mergeOptimal(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;

        int left = n-1;
        int right = 0;

        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                int temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left --;
                right ++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
    static void mergeOptimalGapMethod(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;

        int len = n+m;

        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                } else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                } else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1) {
                break;
            }
            gap = (gap / 2) + (gap%2);
        }
    }
    private static void swapIfGreater(int arr1[], int arr2[], int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }
}
