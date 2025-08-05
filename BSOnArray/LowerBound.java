public class LowerBound {
    //[1,2,2,3] target = 2 , ans = 1 as arr[1] = 2 is >= 2
    //[1,5,9,15] target = 7, ans = 3 as arr[3] = 9 is >= 7

    public static int findLowerBound(int arr[], int target) {
        int n = arr.length;
        return findLowerBoundIndex(0, n-1, arr, target);
    }
    private static int findLowerBoundIndex(int left, int right, int arr[] ,int target) {
        if(left > right) return arr.length;

        int mid = left + (right - left) / 2;

        if(arr[mid] >= target) {
            int lb = findLowerBoundIndex(left, mid - 1, arr, target);
            return Math.min(mid, lb);
        } else {
            return findLowerBoundIndex(mid+1, right, arr, target);
        }      
    }
    public static int findLowerBoundIterative(int arr[], int target) {
        int left = 0;
        int right = arr.length - 1;

        int lb = arr.length;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] >= target) {
                lb = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return lb;
    }
    public static int findLowerBoundBrute(int arr[], int target) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i] >= target) return i;
        }
        return arr.length;
    }
    public static void main(String[] args) {
        int arr1[] = new int[]{1,2,2,3,4};
        System.out.println(findLowerBound(arr1, 2));
        System.out.println(findLowerBoundBrute(arr1, 2));
        System.out.println(findLowerBoundIterative(arr1, 2));
    }
}
