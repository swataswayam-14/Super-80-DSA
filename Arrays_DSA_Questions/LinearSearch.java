package Arrays_DSA_Questions;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = {1,3,5,2,5,4,7,8};
        int target = 5;
        System.out.println(linearSearch(arr, target));
    }
    static int linearSearch(int arr[], int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
