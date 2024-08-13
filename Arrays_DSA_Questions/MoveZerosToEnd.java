package Arrays_DSA_Questions;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int arr[] = {1,2,0,0,0,8,4,4,6,90,0,0,5,1};
        moveZerosBruteForce(arr);
        System.out.println(Arrays.toString(arr));
        moveZerosOptimal(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void moveZerosBruteForce(int arr[]) {
        int temp[] = new int[arr.length];

        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                temp[j] = arr[i];
                j++;
            }    
        }
        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }
    }
    static void moveZerosOptimal(int arr[]) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                j = i;
                break;
            }
        }
        for (int i = j+1; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }
}
