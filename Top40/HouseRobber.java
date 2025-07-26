// You're a robber, trying to rob houses along a street.
// Each house has a certain amount of money, and is represented by an array nums[], where:

// nums[i] = amount of money at the i-th house.

// You cannot rob two adjacent houses (because it’ll trigger an alarm system).
// Return the maximum amount of money you can rob without alerting the police.


// [1,2,3,1]
//rob house 0 -> 1
//skip house 1
//rob house 2 -> 3
//skip house 3

//total : 3+1 = 4

//alternatively 
//rob house 1 -> 2
//skip house 2
//rob house 3 -> 1

//total : 2+1 = 3

//final answer = 4


//intuition : we want to maximise total robbed amount under the constraint : 
//cannot rob two adjacent houses

// for any house i, we have 2 choices : 
// 1. Rob house i -> cannot rob i-1 -> add nums[i] + dp[i-2]
// 2. skip house i -> take the max till i-1 -> dp[i-1]

//dp[i] = max(dp[i-1], nums[i] + dp[i-2])

import java.util.Arrays;

public class HouseRobber {
    public static int rob(int nums[]) { //T.C is O(2^n)
        return robFrom(nums, nums.length-1);
    }
    private static int robFrom(int nums[], int i) {
        if (i<0) return 0;
        return Math.max(robFrom(nums, i-1),nums[i] + robFrom(nums, i-2));
    }

    //memoization
    public static int robMemo(int nums[]) { // T.C is O(n) and S.C is O(n)
        int memo[] = new int[nums.length];
        Arrays.fill(memo, -1);
        return robFromMemo(nums, nums.length-1, memo);
    }
    public static int robFromMemo(int nums[] , int i, int memo[]) {
        if(i<0) return 0;
        if(memo[i] != 0)return memo[i];
        memo[i] = Math.max(robFromMemo(nums, i-1, memo), nums[i] + robFromMemo(nums, i-2, memo));
        return memo[i];
    }
    //tabulation
    public static int robTab(int nums[]) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2;i< nums.length;i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
        return dp[nums.length -1];
    }
    //space optimisation : only last 2 states matter
    public static int ronMostOptimised(int nums[]) { // T.C is O(n) and S.C is O(1)
        if (nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int prev2 = 0;
        int prev1 = 0;

        for(int num: nums) {
            int current = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
