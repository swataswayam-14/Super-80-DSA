package Greedy_Algorithms;

public class JumpGame {
    public static Boolean isValidJump(int arr[]) {
        int  maxIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i > maxIdx) return false;
            maxIdx = Math.max(maxIdx, arr[i] + i);
        }
        return true;
    }
    public static void main(String[] args) {
        int arr1[] = new int[]{1,2,4,1,1,0,2,5};
        int arr2[] = new int[]{1,2,3,1,1,0,2,5};
        System.out.println(isValidJump(arr1));
        System.out.println(isValidJump(arr2));
    }
}
