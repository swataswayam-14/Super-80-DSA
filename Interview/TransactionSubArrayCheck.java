public class TransactionSubArrayCheck {
/* Problem Statement:
Razorpay processes payments in batches. You are given an array of transaction amounts arr[].
Check if there exists any contiguous batch of size k whose **total transaction amount ≥ targetLimit`. */

/*

arr = [100, 200, 50, 300, 400], k = 2, targetLimit = 500


true   (because batch [300,400] = 700 ≥ 500)

 */
    public static boolean isExists(int transactions[], int k, int targetLimit) {
        int amount =0;
        for(int i=0;i<k;i++) {
            amount += transactions[i];
        }

        if(amount >= targetLimit) {
            return true;
        }

        for(int i=k;i<transactions.length;i++) {
            amount = amount - transactions[i-k] + transactions[i];
            if(amount >= targetLimit) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {100, 200, 50, 300, 400};
        int k=2;
        int targetLimit = 700;

        System.out.println(isExists(arr, k, targetLimit));
    }
}
