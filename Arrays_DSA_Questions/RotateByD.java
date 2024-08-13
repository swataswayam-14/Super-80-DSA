package Arrays_DSA_Questions;

import java.util.Arrays;

public class RotateByD {
    public static void main(String args[]) {
        int n = 7;
        int[] arr = {1,2,3,4,5,6,7};
        int k = 2;
        RotateRightBruteForce(arr, n, k);
        System.out.println("After Rotating the elements to right ");
        for (int i = 0; i < n; i++) {
          System.out.print(arr[i] + " ");
        }
        System.out.println();
        RotateLeftBruteForce(arr, n, k);
        System.out.println("After Rotating the elements to left ");
        for (int i = 0; i < n; i++) {
          System.out.print(arr[i] + " ");
        }
        System.out.println();
        rotateRightOptimal(arr, n, k);
        System.out.println(Arrays.toString(arr));
        rotateLeftOptimal(arr, n, k);
        System.out.println(Arrays.toString(arr));
    }
    static void RotateRightBruteForce(int[] arr, int n, int k){ // O(n) TC and O(k) SC
        if (n == 0) {
            return;
        }
        k = k%n;
        int[] temp = new int[k];
        for (int i = n-k; i<n; i++) {
            temp[i-n+k] = arr[i];
        }
        for(int i=n-k-1; i>=0; i--) {
            arr[i+k] = arr[i];
        }
        for(int i=0; i<k; i++) {
            arr[i] = temp[i];
        }
    }
    static void RotateLeftBruteForce(int[] arr, int n, int k) {
        if (n==0) {
            return;
        }
        k = k%n;
        int[] temp = new int[k];
        for (int i=0; i<k; i++) {
            temp[i] = arr[i];
        }
        for(int i=0; i<n-k;i++) {
            arr[i] = arr[i+k];
        }
        for(int i = n-k; i<n; i++) {
            arr[i]= temp[i-n+k];
        }
    }
    static void rotateRightOptimal(int arr[], int n , int k){
        Reverse(arr, 0, n-k-1);
        Reverse(arr, n-k, n-1);
        Reverse(arr, 0, n-1);
    }
    static void rotateLeftOptimal(int arr[], int n , int k){
        Reverse(arr, 0, k-1);
        Reverse(arr, k, n-1);
        Reverse(arr, 0, n-1);
    }
    static void Reverse(int[] arr, int start, int end) {
        while(start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}