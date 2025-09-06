import java.util.Arrays;

public class PaymentSettleMent {
/* A Razorpay wallet must settle users’ debts. Each transaction weight = debt amount.
The wallet can settle at most 2 debts in a single operation, but their sum must not exceed the settlementLimit.
Find the minimum number of operations required. */

/* debts = [3, 2, 2, 1], settlementLimit = 3 */

/* output = 3 */
    public static int minOps(int[] debts, int settlementLimit) {
        Arrays.sort(debts);
        int i = 0, j = debts.length - 1, ops = 0;

        while(i<=j) {
            if(debts[i] + debts[j] <= settlementLimit) i++;
            j--;
            ops++;
        }
        return ops;
    }
}
