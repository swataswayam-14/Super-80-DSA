package Arrays_DSA_Questions.Hard;


public class FindMissingRepeatingNumber {
    public static void main(String[] args) {
        int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
        int[] ans = findMissingRepeatingNumberBrute(a);
        System.out.println("The repeating and missing numbers are: {"+ ans[0] + ", " + ans[1] + "}");
    }
    static int[] findMissingRepeatingNumberBrute(int arr[]) {
        int n = arr.length;
        int repeating = -1;
        int missing = -1;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == i) {
                    count++;
                }
            }
            if (count == 0) {
                missing = i;
            } else if (count == 2) {
                repeating = i;
            }
            if (repeating != -1 && missing != -1) {
                break;
            }
        }
        return new int[] {repeating, missing};
    }
}
