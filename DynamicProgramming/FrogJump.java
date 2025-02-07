package DynamicProgramming;

public class FrogJump {
    public static void main(String[] args) {
        int[] heights = {10, 20, 30, 10};
        int n = heights.length;
        int minEnergy = findMinimumEnergyBrute(n - 1, heights);
        System.out.println("Minimum energy required: " + minEnergy);

        int dp[] = new int[heights.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        int minEnergy2 = findMinimumEnergyMemoized(n - 1, heights,dp);
        System.out.println("Minimum energy required: " + minEnergy2);
    }
    static int findMinimumEnergyBrute(int index, int arr[]) {
        if (index == 0) {
            return 0;
        }
        int left = findMinimumEnergyBrute(index-1, arr) + Math.abs(arr[index] - arr[index-1]);

        int right = Integer.MAX_VALUE;

        if (index > 1) {
            right =  findMinimumEnergyBrute(index-2, arr) + Math.abs(arr[index] - arr[index - 2]);
        }
        return Math.min(left, right);
    }
    static int findMinimumEnergyMemoized(int index, int arr[], int dp[]) {
        if (index == 0) return 0;
        if (dp[index] != -1) return dp[index];
        
        int left = findMinimumEnergyMemoized(index - 1, arr,dp) + Math.abs (arr[index] - arr[index - 1]);
        int right = Integer.MAX_VALUE;
        if (index > 1) {
            right = findMinimumEnergyMemoized(index - 2, arr, dp) + Math.abs(arr[index] - arr[index - 2]);
        }

        dp[index] = Math.min(left, right);
        return dp[index];
    }
}
