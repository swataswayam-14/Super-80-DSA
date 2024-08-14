package Arrays_DSA_Questions;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int arr[] = {1,1,2,3,4,4,1,1,1,1,5,6,2,2};
        System.out.println("The maximum number of 1s in the array is "+maxConsecutiveOnes(arr));
    }
    static int maxConsecutiveOnes(int arr[]) {
        int maxCount = 0; 
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++; 
            } else {
                count = 0;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
