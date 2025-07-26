import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum (int arr[], int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            int compliment = target - arr[i];
            if (map.containsKey(compliment)) {
                return new int[]{map.get(compliment), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }
    public static int[] twoSumBrute(int arr[] , int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] + arr[j] == target) return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
}
