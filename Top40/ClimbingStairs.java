// 1. Problem Understanding
// You’re standing at the bottom of a staircase with n steps. Each time, you can either:

// Climb 1 step, or

// Climb 2 steps

// Your task: Count how many distinct ways you can reach the top (step n).

// This is a counting problem, not path listing.
// We're not interested in the path itself, just the total number of ways to reach step n.


// n = 1 : 
// 1 step : 1 way

// n = 2 :
// 1+1 , 2 : 2 way

// n = 3 : 
// 1+1+1 , 2+1, 1+2 : 3 way

//n = 4 : 
//1+1+1+1 , 2+1+1 , 1+1+2, 1+2+1, 2+2 : 5 way

// this is following fibonacci sequence

public class ClimbingStairs {
    public static int climbStairs(int n) { //T.C is O(2^n)
        if (n== 0 || n==1) return n;
        return climbStairs(n-1) + climbStairs(n-2);
    }
    //memoization 
    public static int climbStairsMemo(int n) { // T.C is O(n) , S.C is O(n) for recursion and memo array
        int memo[] = new int[n+1];
        return climb(memo, n);
    }
    private static int climb(int memo[], int n) {
        if (n==0 || n==1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = climb(memo, n-1) + climb(memo, n-2);
        return memo[n];
    }
    //tabulation
    public int climbStairsTabulation(int n) { //T.C is O(n) and S.C is O(n)
        if (n==0 || n==1) return n;
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    //space optimisation : only using 2 variables 
    public static int climbStairsCompleteOptimised(int n) { // T.C is O(n) and S.C is O(1)
        if(n==0 || n==1) return n;
        int prev2 = 0;
        int prev1 = 1;
        for(int i=2;i<=n;i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
