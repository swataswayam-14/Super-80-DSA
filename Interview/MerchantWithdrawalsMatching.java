import java.util.Arrays;

public class MerchantWithdrawalsMatching {
/* Razorpay must match incoming payments with merchant withdrawals. Each withdrawal must be matched with exact one payment of ≥ amount. Minimize the number of unmatched withdrawals. */

    public static int unmatched(int[] payments, int[] withdrawals) {
        Arrays.sort(payments);
        Arrays.sort(withdrawals);

        int i=0, j=0, matched = 0;

        while(i<payments.length && j<withdrawals.length) {
            if(payments[i] >= withdrawals[j]) {
                matched++;
                i++;
                j++;
            } else {
                i++;
            }
        }
        return withdrawals.length - matched;
    }
    public static void main(String[] args) {
        int[] payments = {50,100,200};
        int[] withdrawals = {80,90,150};
        System.out.println(unmatched(payments, withdrawals));
    }
}
