public class FraudulentTransactionWindow {
/* Problem:
Given an array of transaction amounts and an integer T, detect if there exists any contiguous window of size ≥ 3 whose average transaction amount exceeds T. */
    public static boolean hasFraud(int[] arr, int T) {
        int n = arr.length;
        int[] prefix = new int[n+1];

        for(int i=0;i<n;i++) {
            prefix[i+1] = prefix[i] + arr[i];
        }

        for(int len = 3;len<=n;len++) {
            for(int i=0; i+len<=n; i++) {
                int sum = prefix[i+len] - prefix[i];
                if((double) sum / len > T) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {100,200,300,400,100};
        System.out.println(hasFraud(arr, 250));
    }
}
