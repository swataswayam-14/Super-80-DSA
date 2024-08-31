package Arrays_DSA_Questions.Hard;

public class CountInversion {
    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        int cnt = countInversionBrute(a);
        System.out.println("The number of inversions is: " + cnt);
    }
    static int countInversionBrute (int arr[]) { //T.C is O(n^2) and S.C is O(1)
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count ++;
                }
            }
        }
        return count;
    }

}
