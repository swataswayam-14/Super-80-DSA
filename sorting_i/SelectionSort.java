
package sorting_i;
import java.util.*;

public class SelectionSort {
    public static void selection_sort(int arr[]) { // O(n^2)
        int n = arr.length;
        for (int i = 0; i <= n-2; i++) {
            int mini = i;
            for (int j = i; j <= n-1; j++){
                if(arr[j] < arr[mini]) {
                    mini = j;
                }
            }
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,34,12,78,32,67,2,1,89,56,44,22};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("After sorting");
        selection_sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
