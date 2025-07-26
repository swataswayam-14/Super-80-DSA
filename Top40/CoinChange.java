// You're given:

// A list of coin denominations: int[] coins

// A target amount: int amount

// You can use unlimited number of each coin.
// Your task: Find the minimum number of coins required to make up the target amount.

// If it’s not possible, return -1.


// [1,2,5] , amount = 11
// 5+5+1 : 3 coins


//[2,5,10,1] amount = 27

//10+10+5+2 : 4 coins

//[1] amount = 0
// 0

//[2] amount = 3
// -1

//intuition 
// -> we can pick the same coin multiple times
// -> we're trying to minimise the count of coins used (not maximise the sum)

// use bottom - up dp
//dp[i] = minimum number of coins needed to make amount i

// initialise 
//dp[0] = 0 // 0 coins needed to make amount 0 
//dp[i] = inf for all i>0

//then for each amount i and each coin
//dp[i] = min(dp[i], dp[i-coin] + 1)

import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int result = Integer.MAX_VALUE;
        for(int coin: coins) {
            if(amount - coin >= 0) {
                int sub = coinChange(coins, amount - coin);
                if(sub!= -1) result = Math.min(result, sub+1);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    //memoization
    public int coinChangeMemo(int coins[], int amount) {
        int memo[] = new int[amount+1];
        Arrays.fill(memo, -2); // -2 means uncomputed
        return dp(coins, amount, memo);
    }
    private static int dp(int[] coins, int rem, int[] memo) {
        if(rem < 0) return -1;
        if(rem == 0) return 0;
        if(memo[rem] != -2) return memo[rem];

        int min = Integer.MAX_VALUE;
        for(int coin: coins) {
            int res = dp(coins, rem-coin, memo);
            if(res >= 0 && res < min) {
                min = res+1;
            }
        }
        memo[rem] = (min == Integer.MAX_VALUE) ? -1: min;
        return memo[rem];
    }
}
