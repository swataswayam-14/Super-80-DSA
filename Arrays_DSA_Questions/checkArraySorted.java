package Arrays_DSA_Questions;

public class checkArraySorted {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        System.out.println(isSorted(arr));
    }
    static boolean isSorted(int arr[]) { //O(n): TC
        for (int i = 1; i < arr.length; i++) {
            if(!(arr[i] >= arr[i-1])){
                return false;
            }
        }
        return true;
    }
}
