package sorting_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
  
    public static void main(String args[]) {
        List<Integer> arr = new ArrayList<>();
        arr = Arrays.asList(new Integer[] {4, 6, 2, 5, 7, 9, 1, 3});
        int n = arr.size();
        System.out.println("Before Using quick Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
        QS(arr, 0, n-1);
        System.out.println("After quick sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }
    public static int partition(List<Integer> arr, int low , int high) {
        int pivot = arr.get(low);
        int i = low;
        int j = high;

        while(i<j) {
            while(arr.get(i) <= pivot && i <= high-1) {
                i++;
            }
            while (arr.get(j) > pivot && j >= low+1) {
                j--;
            }
            if(i<j) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j,temp);
            }
        }
        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);
        return j;
    }
    public static void QS(List<Integer> arr, int low, int high) {
        if(low<high) {
            int pIdx = partition(arr, low, high);
            QS(arr, low, pIdx - 1);
            QS(arr, pIdx+1, high);
        }
    }
}
