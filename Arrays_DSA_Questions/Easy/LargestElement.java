package Arrays_DSA_Questions.Easy;

import java.util.Arrays;

public class LargestElement {
    public static void main(String[] args) {
        int arr[] = {1,2,32,51,4,132,5,34,54,2};
        System.out.println("The largest element is: "+ sortBruteForce(arr));
        System.out.println("The largest element is: "+ sortOptimal(arr));
    }
    public static int sortBruteForce(int arr[]) { // O(nlogn)
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
    public static int sortOptimal(int arr[]) { // O(n)
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= max) {
                max = arr[i];
            }
        }
        return max;
    }
}
