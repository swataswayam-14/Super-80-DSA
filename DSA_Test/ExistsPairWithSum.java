package DSA_Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExistsPairWithSum {
/*
Pairs With Equal Sum
Given an array of integers, determine if there exists two different pairs (a, b) and (c, d) such that a + b = c + d.

Concepts: Hashing, combinations

Follow-up: Return any one such pair if exists.
*/
//[1,3,5,7,5,6,0]
//i = 0; j= i -> sum -> index(i,j) : Map
    public static boolean isExistsPair(int arr[]) {
        int n= arr.length;

        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int sum = arr[i] + arr[j];
                if(!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<>());
                }
                map.get(sum).add(new int[]{i,j});
            }
        }
        for(Map.Entry<Integer, List<int[]>> entry: map.entrySet()) {
            List<int[]> pairs = entry.getValue();
            for(int i=0;i<pairs.size();i++) {
                for(int j=i+1; j< pairs.size();j++) {
                    int[] p1 = pairs.get(i);
                    int[] p2 = pairs.get(j);
                    if(p1[0] != p2[0] && p1[0] != p2[1] && p1[1] != p2[0] && p1[1] != p2[1]) {
                        System.out.println("Pairs: (" + arr[p1[0]] + "," + arr[p1[1]] + ") and (" + arr[p2[0]] + "," + arr[p2[1]] + ")");
                        return true;
                    }
                }
            }
        }
        return false;
    }

/*
    instead of storing multiple pairs per sum, we can use a single hashmap<Integer, int[]> to store only one pair for each unique sum. When a new pair with the same sum is found , just check oif the indices are disjoint
*/

    public static boolean isExistsPairOptimal(int arr[]) {
        Map<Integer, int[]> sumMap = new HashMap<>();
        int n = arr.length;
        List<int[]> pairs = new ArrayList<>();

        for(int i=0;i<n;i++) {
            for(int j=i+1; j<n; j++) {
                int sum = arr[i] + arr[j];
                if(sumMap.containsKey(sum)) {
                    int[] prev = sumMap.get(sum);
                    if(prev[0] != i && prev[1] != i && prev[0] != j && prev[1] != j) {
                        pairs.add(prev);
                        System.out.println(pairs);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
