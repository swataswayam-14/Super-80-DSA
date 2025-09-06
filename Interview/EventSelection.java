import java.util.Arrays;

public class EventSelection {
    /* You are given n events where each event i has (startTime, endTime, value).
You can attend at most 2 non-overlapping events. Return the maximum total value. */

/*
Input: events = [[1,3,4],[3,4,3],[2,5,2],[4,6,4]]  
Output: 8  
Explanation: Attend [1,3,4] and [4,6,4]
 */
    public static int maxTwoEvents(int [][] events) {
        Arrays.sort(events, (a,b) -> a[0] - b[0]); // sort by start time
        int n = events.length;

        int[] maxFuture = new int[n+1];

        //fill the maxFuture array backwards

        for(int i=n-1;i>=0;i--) {
            maxFuture[i] = Math.max(maxFuture[i+1], events[i][2]);
        }

        int ans = 0;
        for(int i=0;i<n;i++) {
            int val = events[i][2];

            //binary search for next event that starts after the current ends

            int low = i+1, high = n-1, next = n;
            while(low <= high) {
                int mid = ((low+high)/2);
                if(events[mid][0] > events[i][1]) {
                    next = mid;
                    high = mid - 1;
                } else {
                    low = mid+1;
                }
            }
            val += maxFuture[next];
            ans = Math.max(ans, val);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] events = {{1,3,4},{3,4,3},{2,5,2},{4,6,4}};
        System.out.println(maxTwoEvents(events));
    }
}
