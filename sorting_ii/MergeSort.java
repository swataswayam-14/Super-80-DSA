package sorting_ii;

import java.util.ArrayList;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {12,54,22,76,23,11,78,42,7,4,2,57,};
        System.out.println("Before MS");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        MS(arr, arr.length, 0, arr.length-1);
        System.out.println("After MS");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void MS(int arr[], int n , int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        MS(arr, n, low, mid);
        MS(arr, n, mid+1, high);
        merge(arr, low, mid, high);
    }
    public static void merge(int arr[] , int low , int mid , int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while (left <= mid && right <= high) {
            if(arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right ++;
            }
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        for (int i = low; i <=high ; i++) {
            arr[i] = temp.get(i-low);
        }
    }
}