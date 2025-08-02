package ArrayProblems;

import java.util.*;

public class FirstRepeatingElement {
    public static int firstRepeated(int arr[]) {
        if (arr == null || arr.length == 0) return Integer.MIN_VALUE;

        int n = arr.length;
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            indexMap.putIfAbsent(arr[i], i);
        }
        int firstRepeatingIndex = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() >= 2) {
                int idx = indexMap.get(entry.getKey());
                firstRepeatingIndex = Math.min(firstRepeatingIndex, idx);
            }
        }

        return (firstRepeatingIndex == Integer.MAX_VALUE) ? -1 : firstRepeatingIndex;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 5, 3, 4, 3, 5, 6};
        System.out.println(firstRepeated(arr)); 
    }
}
