package ArrayProblems;

import java.util.Arrays;

public class MissingNumber {
    public static int missingNum(int arr[]) {
        int n = arr.length;
        if(n == 1) return -1;
        Arrays.sort(arr);
        for(int i=1;i<=n;i++) {
            if(!binarySearch(i, arr)) return i;
        }
        return -1;
    }
    private static boolean linearSearch(int target, int arr[]) {
        for(int i=0;i<arr.length;i++) {
            if(target == arr[i]) return true;
        }
        return false;
    }
    private static boolean binarySearch(int target, int arr[]) {
        int left = 0;
        int right = arr.length - 1;
    
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) return true;
            else if(arr[mid] < target) left = mid+1;
            else right = mid - 1;
        }
        return false;
    }
    public static int  missingNumOptmised(int arr[]) {
        int n = arr.length;
        int sum =(n + 1) * (n + 2) / 2;  ;
        int arraySum = 0;
        for(int num: arr) {
            sum += num;
        }
        return sum - arraySum;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,5,6};
        System.out.println(missingNum(arr));
    }
}
