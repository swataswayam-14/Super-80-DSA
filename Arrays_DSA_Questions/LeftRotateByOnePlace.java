package Arrays_DSA_Questions;

import java.util.Arrays;

public class LeftRotateByOnePlace {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        rotateLeft(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void rotateLeft(int arr[]) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;
    }
}

