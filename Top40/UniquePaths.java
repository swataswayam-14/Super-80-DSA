// Unique Paths
// Given an m x n grid, find the number of unique paths from top-left to bottom-right, only moving right or down.



// Brute Force (Recursion)
// Try all paths recursively by going right and down.

// Time: Exponential — O(2^(m+n))
// Space: O(m+n) stack space

import java.util.Arrays;

public class UniquePaths {
    public int uniquePathsBrute(int m, int n) {
        return dfs(0,0,m,n);
    }
    private int dfs(int i, int j, int m, int n) {
        if(i== m-1 && j== n-1) return 1;
        if(i>= m || j >= n) return 0;
        return dfs(i+1, j, m, n) + dfs(i, j+1, m, n);
    }

// Optimized DP (2D Table)
// Store paths from each cell to the destination.

// dp[i][j] = dp[i+1][j] + dp[i][j+1]

// Time: O(m × n)
// Space: O(m × n)
    public int uniquePathsDP(int m,int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) dp[i][0] = 1;
        for(int j=0;j<n;j++) dp[0][j] = 1;

        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

// Space-Optimized DP (1D array)
// Only previous row is needed at any time.

// Time: O(m × n)
// Space: O(n)
    public int uniquePaths(int m , int n) {
        int [] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                dp[j] += dp[j-1];
            }
        }
        return dp[n-1];
    }
}
