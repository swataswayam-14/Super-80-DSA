public class MinimumSwapsToGroupOne {
    /*
     Minimum Swaps to Group All 1s Together
    You are given a binary array. Find the minimum number of swaps required to group all 1s together.

    Concepts: Sliding Window

    Follow-up: Do it in O(n)
     */

     //Brute Approach
    
    //arr = [1,0,1,0,1]
    //total_ones = 3

    //try all windows of size 3 : 
    // - [1,0,1] -> 1 zero -> 1 swap
    // - [0,1,0] -> 2 zeros -> 2 swap
    // -[1,0,1] -> 1 zero -> 1 swap
    //min-swap = 1
    public static int minSwapsBrute(int arr[]) { //[0,1,1,0,1,0,1,1,1]
        //count total number of 1s in the array : countOnes
        //try placing 1s in every possible group of size countOnes
          // -> each grp (window) should ideally contain only 1s
          // -> if not count how many zeros are inside it -> those many number of swaps are needed
          // try all possible windows of size countOnes -> keep track of minimum no. of 0s inside any such windows
          // return the minimum 

        int n = arr.length;
        int countOnes = 0;

        for(int num: arr) {
            if(num == 1) countOnes ++;
        }
        if(countOnes == 0 || countOnes == n) return 0;

        int minSwaps = Integer.MAX_VALUE;
        for(int i=0; i <= n-countOnes; i++) {
            int zeroCount = 0;
            for(int j=i;j< i+countOnes ;j++) {
                if(arr[j] == 0) zeroCount++;
            }
            minSwaps = Math.min(minSwaps, zeroCount);
        }
        return minSwaps;
    }
    public static int minSwapsOptimised(int arr[]) {
        int totalOnes = 0;
        for(int num: arr) {
            if(num == 1) totalOnes ++;
        }
        if(totalOnes == 0 || totalOnes == arr.length) return 0;

        int maxOnesInWindow = 0;
        int currentOnes = 0;

        int left = 0;
        for(int right = 0; right < arr.length ; right ++) {
            currentOnes += arr[right];
            if(right - left + 1 > totalOnes) {
                currentOnes -= arr[left++];
            }
            if(right - left + 1 == totalOnes){
                maxOnesInWindow = Math.max(maxOnesInWindow, currentOnes);
            }
        }
        return totalOnes - maxOnesInWindow;
    }
}
