package ArrayProblems;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumPairs {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        Map<Integer, Integer> prefixMap = new HashMap<>();

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=0;i<arr.length;i++) {
            int compliment = - arr[i];
            if(prefixMap.containsKey(compliment)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(compliment);
                list.add(arr[i]);
                res.add(list);
            } else {
                prefixMap.put(arr[i],i);
            }
        }
        return res;
    }
    public static ArrayList<ArrayList<Integer>> getPairsAllRequirement(int arr[]) {
        Set<Integer> seen = new HashSet<>();
        Set<String> uniquePairs = new HashSet<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for(int num: arr) {
            int complement = -num;
            if(seen.contains(complement)) {
                int a = Math.min(num, complement);
                int b = Math.max(num, complement);
                String key = a+":"+b;
                if(!uniquePairs.contains(key)) {
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(a);
                    pair.add(b);
                    res.add(pair);
                    uniquePairs.add(key);
                }
            }
            seen.add(num);
        }
        res.sort((a,b) -> {
            if(!a.get(0).equals(b.get(0))) return a.get(0) - b.get(0);
            return a.get(1) - b.get(1);
        });
        return res;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{6, 1, 8, 0, 4, -9, -1, -10, -6, -5};
        System.out.println(getPairs(arr));
        System.out.println(getPairsAllRequirement(arr));
    }
}
