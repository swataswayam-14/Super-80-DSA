package Greedy_Algorithms;

import java.util.Arrays;

public class ShortestJobFirst {
    public int findShortedtWaitingTime(int arr[]) {
        Arrays.sort(arr);
        int t = 0;
        int wtTime = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) { //[1,2,5,7] : execution time of processes
            wtTime += t;
            t+=arr[i];
        }
        return (wtTime/n);
    }//the T.C is O(n) + O(nlogn) and SC is O(1)
}
