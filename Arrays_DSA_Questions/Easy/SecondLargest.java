package Arrays_DSA_Questions.Easy;

import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int arr[] = {1,2,44,5,12,56,56,78,78,78,21,5};
        System.out.println("The second largest element in the array is " + getSecondLargestBruteForce(arr));
        getSecondLargestSmallestBetter(arr);
        getSecondLargestSmallestOptimal(arr);
    }
    public static int getSecondLargestBruteForce(int arr[]) {
        Arrays.sort(arr);
        int second_largest = Integer.MIN_VALUE;
        int max = arr[arr.length - 1]; 
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if (arr[i] != max && second_largest <= arr[i]) {
                second_largest = arr[i];
            }
        }
        return second_largest;
    }
    public static void getSecondLargestSmallestBetter(int arr[]) {
        int small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            small = Math.min(small, arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            large = Math.max(large, arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < second_small && arr[i] != small) {
                second_small = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > second_large && arr[i] != large) {
                second_large = arr[i];
            }
        }
        System.out.println("The second largest element is " + second_large);
        System.out.println("The second smallest element is " + second_small);
    }
    public static void getSecondLargestSmallestOptimal(int arr[]) {
        System.out.println("The second largest element is " + second_large(arr, arr.length));
        System.out.println("The second smallest element is " + second_small(arr, arr.length));
    }
    static int second_small(int arr[], int n) {
        if (n<2) {
            return -1;
        }
        int second_small = Integer.MAX_VALUE;
        int small = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(arr[i] < small) {
                second_small = small;
                small = arr[i];
            }else if(arr[i] < second_small && arr[i] != small) {
                second_small = arr[i];
            }
        }
        return second_small;
    }
    static int second_large(int arr[], int n){
        if (n<2) {
            return -1;
        }
        int second_large = Integer.MIN_VALUE;
        int large = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(arr[i] > large) {
                second_large = large;
                large = arr[i];
            }else if(arr[i] > second_large && arr[i] != large) {
                second_large = arr[i];
            }
        }
        return second_large;
    }
}
