package ArrayProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArraySubSet {
    public boolean isSubset(int a[], int b[]) {
        if(b.length > a.length) return false;
        //to find if b is a subset of a
        Map<Integer, Integer> freq1 = new HashMap<>();
        Map<Integer, Integer> freq2 = new HashMap<>();

        for(int num: a) {
            freq1.put(num, freq1.getOrDefault(num, 0) + 1);
        }
        for(int num: b) {
            freq2.put(num, freq2.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry2: freq2.entrySet()) {
            int num = entry2.getKey();
            if(!freq1.containsKey(num)) return false;
            else {
                if(!(freq1.get(num) >= freq2.get(num))) { // the frequency of the element in subset array is more than that present in the parent array
                    return false; 
                }
            }
        }
        return true;
    }
    public boolean isSubsetOptmised(int a[], int b[]) { // slight optmise
        if(b.length > a.length) return false;
        //to find if b is a subset of a
        Map<Integer, Integer> freq1 = new HashMap<>();
        Map<Integer, Integer> freq2 = new HashMap<>();

        for(int num: a) {
            freq1.put(num, freq1.getOrDefault(num, 0) + 1);
        }
        for(int num: b) {
            freq2.put(num, freq2.getOrDefault(num, 0) + 1);
        }
        for(int key: freq2.keySet()) {
            if(freq1.getOrDefault(key, 0) < freq2.get(key)) return false;
        }
        return true;
    }
}
