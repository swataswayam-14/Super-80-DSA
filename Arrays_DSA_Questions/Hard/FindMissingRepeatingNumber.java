package Arrays_DSA_Questions.Hard;


public class FindMissingRepeatingNumber {
    public static void main(String[] args) {
        int[] a = {3, 1, 2, 5, 4, 6, 7, 5};
        int[] ans1 = findMissingRepeatingNumberBrute(a);
        System.out.println("The repeating and missing numbers are: {"+ ans1[0] + ", " + ans1[1] + "}");
        int[] ans2 = findMissingRepeatingNumberBetter(a);
        System.out.println("The repeating and missing numbers are: {"+ ans2[0] + ", " + ans2[1] + "}");
        int[] ans3 = findMissingRepeatingNumberOptimal_i(a);
        System.out.println("The repeating and missing numbers are: {"+ ans3[0] + ", " + ans3[1] + "}");
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
    static int[] findMissingRepeatingNumberBetter(int arr[]) {
        int n = arr.length;
        int hash[] = new int[n+1];

        for (int i = 0; i < n; i++) {
            hash[arr[i]]++;
        }
        int repeating = -1;
        int missing = -1;

        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == 0) missing = i;
            else if(hash[i] == 2) repeating = i;
        }
        return new int[] {repeating, missing};
    }
    static int[] findMissingRepeatingNumberOptimal_i(int arr[]) {
        int n = arr.length;
        int sn = (n*(n+1)) / 2;
        int s2n = (n * (n+1) * (2*n+1)) / 6;

        int s = 0;
        int s2 = 0;

        for (int i = 0; i < arr.length; i++) {
            s = s + arr[i];
            s2 = s2 + arr[i] * arr[i];
        }

        int val1 = s - sn; //(x+y)
        int val2 = s2 - s2n;

        val2 = val2/val1; // (x-y)

        int x = (val1 + val2) / 2;
        int y = x - val1;
        return new int[] {x,y};
    }
}
