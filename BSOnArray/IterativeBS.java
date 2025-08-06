public class IterativeBS{
    public static int findIndexUsingBS(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
    public static int findIndexBSRecursive(int arr[], int target) {
        return findIndex(0, arr.length - 1, arr, target);
    }
    private static int findIndex(int left, int right, int arr[], int target) {
        if(left > right) return -1;
        int mid = left + (right-left)/2;
        if(arr[mid] == target) return mid;
        else if(arr[mid] < target) return findIndex(mid+1, right, arr, target);
        else return findIndex(left, mid-1, arr, target);
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1,3,55,67,87,91};
        System.out.println(findIndexBSRecursive(arr, 67));
        System.out.println(findIndexUsingBS(arr, 67));
    }
}