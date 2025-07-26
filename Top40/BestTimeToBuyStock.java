// Problem: Best Time to Buy and Sell Stock
// Given:
// An array prices[] where prices[i] is the stock price on day i.

// Goal:
// Find the maximum profit from one buy and one sell.
// Buy must happen before sell.

// Intuition
// To maximize profit:

// We want to buy at the lowest price so far and

// Sell at a higher price after it.

// So track the minimum price seen so far, and at each step, calculate potential profit:
// profit = current_price - min_price_so_far.

/* 
| Approach           | Time  | Space |
| ------------------ | ----- | ----- |
| Brute Force        | O(n²) | O(1)  |
| Optimized (1-pass) | O(n)  | O(1)  |
*/


// {7,1,5,3,6,4}
//buy at 1 and sell at 6 : output : 5

//brute force : 
// for every pair (i,j) such that i<j , calculate profit = prices[j] - prices[i] and track max

//optimised approach 
//keep track of min price seen so far
// at each day calculate profit = prices[i] - min
//update maxProfit accordingly

public class BestTimeToBuyStock {
    public static int maxProfitBrute(int arr[]) {
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int currProfit = arr[j] - arr[i];
                maxProfit = Math.max(maxProfit, currProfit);
            }
        }
        return maxProfit;
    }
    public static int maxProfitOptimised(int arr[]) {
        int maxProfit = Integer.MIN_VALUE;
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int currProfit = arr[i] - min;
            maxProfit = Math.max(maxProfit, currProfit);
            min = Math.min(min, arr[i]);
        }
        return maxProfit;
    }
}
