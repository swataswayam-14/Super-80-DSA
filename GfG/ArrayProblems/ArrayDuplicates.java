package ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayDuplicates {
    public static ArrayList<Integer> findDuplicates(int arr[]) {
        if(arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num: arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> frequency: freqMap.entrySet()) {
            if(frequency.getValue() == 2) res.add(frequency.getKey());
        }
        return res;
    }
    public static ArrayList<Integer> findDuplicatesOptmised(int arr[]) {
        if(arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(arr);
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=1;i<arr.length;i++) {
            if(arr[i] == arr[i-1]) res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2,3,1,2,3};
        int arr2[] = new int[]{3,1,2};
        System.out.println(findDuplicates(arr));
        System.out.println(findDuplicatesOptmised(arr));
        System.out.println(findDuplicatesOptmised(arr2));
    }
}
