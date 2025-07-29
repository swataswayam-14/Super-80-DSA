package DSA_Test;

public class BestTimeToBuyAndSell {
    public static int maxProfit(int arr[]) {
        int mini = arr[0];
        int maxProfit = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int currProfit = arr[1] - mini;
            maxProfit = Math.max(maxProfit, currProfit);
            mini = Math.min(mini, arr[i]);
        }
        return maxProfit;
    }
}
