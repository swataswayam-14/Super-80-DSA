package ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateArrayByOne {
    public static void rotate(int arr[]) {
        List<Integer> rotatedArray = new ArrayList<>();
        rotatedArray.add(0, arr[arr.length - 1]);
        for(int i=0;i<arr.length - 1;i++) {
            rotatedArray.add(arr[i]);
        }
        int i = 0;
        for(int num: rotatedArray) {
            arr[i] = num;
            i++;
        }
        for(int num: arr) {
            System.out.print(num+" ");
        }
    }
    public static void rotateOptmised(int arr[]) {
        int n = arr.length;
        int last = arr[n-1];

        for(int i=n-1;i>0;i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = last;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5};
        rotate(arr);
    }
}
