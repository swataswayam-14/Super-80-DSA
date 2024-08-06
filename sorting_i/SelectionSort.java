
package sorting_i;
import java.util.*;

public class SelectionSort {
    public static void selection_sort(int arr[]) { // O(n^2) brings the minimum element to the first of the array
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
    public static void bubble_sort(int arr[]) { //O(n^2): Worst and Average, O(n): best case,  brings the largest element to the last of the array
        int n = arr.length;
        for (int i = n-1; i>=0; i--) {
            int swap = 0;
            for (int j = 0; j <= n-2; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = 1;
                }
            }
            if(swap == 0) {
                break;
            }
        }
    }
    public static void insertion_sort(int arr[]) { // O(n^2): worst case and average case , O(n) : best case, puts the element in their correct place
        int n = arr.length;
        for (int i = 0; i <= n-1; i++) {
            int j = i;
            while (j > 0 && arr[j-1] > arr[j]) {
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,34,12,78,32,67,2,1,89,56,44,22};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("After sorting");
        //selection_sort(arr);
        //bubble_sort(arr);
        insertion_sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
