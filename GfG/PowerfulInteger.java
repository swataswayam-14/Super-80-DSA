import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class PowerfulInteger {
    public int powerfulInteger(int [][] intervals, int k) {
        Set<Integer> set = new HashSet<>();
        for(int[] interval: intervals) {
            set.add(interval[0]);
            set.add(interval[1]);
        }
        Map<Integer, Integer> freqMap = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for(int num: set) {
            for(int [] interval : intervals) {
                int currMax = num;
                if(interval[0] <= num && num <= interval[1]) {
                    freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
                    if(freqMap.get(num) >= k) max = Math.max(currMax, max);
                }
            }
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }
    public int powerfulIntegerOptmised(int [][] intervals, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int[] interval: intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1] + 1, map.getOrDefault(interval[1] + 1, 0) - 1);
        }

        int count = 0;
        int max = -1;
        int prev = -1;

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int point = entry.getKey();
            if(count >= k && prev != -1) {
                max = Math.max(max, point - 1);
            }
            count += entry.getValue();
            prev = point;
        }
        return max;
    }
}
