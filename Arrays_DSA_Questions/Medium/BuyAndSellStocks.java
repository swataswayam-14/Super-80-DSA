package Arrays_DSA_Questions.Medium;

public class BuyAndSellStocks {
    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};
        System.out.println("The maximum profit is "+maxProfit(arr));
    }
    static int maxProfit(int arr[]) {

        int minimum = arr[0];
        int maxProfit = 0;

        for (int i = 1; i < arr.length; i++) {
            int cost = arr[i];
            int profit = cost - minimum;
            maxProfit = Math.max(maxProfit, profit);
            minimum = Math.min(arr[i], minimum);
        }

        return maxProfit;
    }
}
