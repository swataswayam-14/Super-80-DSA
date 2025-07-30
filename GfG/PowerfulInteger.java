import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
}
