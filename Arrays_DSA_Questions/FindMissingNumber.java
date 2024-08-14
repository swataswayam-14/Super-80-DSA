package Arrays_DSA_Questions;

public class FindMissingNumber {
    public static void main(String[] args) {
        int arr[] = {0,1,2,3,4,5,6,8};
        int n = 8;
        System.out.println("The missing number is "+findMissing(arr, n));
        System.out.println("The missing number is "+missingNumberBruteForce(arr, n));
        System.out.println("The missing number is "+missingNumberBetter(arr, n));
        System.out.println("The missing number is "+missingNumberOptimal_i(arr, n));
        System.out.println("The missing number is "+missingNumberOptimal_ii(arr, n));
    }
    static int findMissing(int arr[], int n) { // [1,2,4,5]    5
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != n) {
                return n;
            }
            n--;
        }
        return -1;
    }
    static int missingNumberBruteForce(int arr[] , int n) {
        for (int i = 0; i <= n; i++) {
            int flag = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return i;
            }
        }
        return -1;
    }
    static int missingNumberBetter(int arr[], int n) {
        int hash[] = new int[n+1];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]] = 1;
        }
        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }
    static int missingNumberOptimal_i(int arr[], int n) {
        int sum = (n*(n+1))/2;
        int sumArr = 0;
        for (int i = 0; i < arr.length; i++) {
            sumArr += arr[i];
        }
        int missingNum = sum - sumArr;
        if(missingNum != 0){
            return missingNum;
        }
        return -1;
    }
    static int missingNumberOptimal_ii(int[] arr, int n) {
        int xor1 = 0;
        int xor2 = 0;
    
        for (int i = 0; i <= n; i++) {
            xor1 ^= i;
        }
        for (int num : arr) {
            xor2 ^= num;
        }
        if ((xor1 ^ xor2) != 0){
            return xor1 ^ xor2;
        }
        return -1;
    }
}
