import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean isDuplicateMostOptimal(int arr[]) {
        Set<Integer> seen = new HashSet<>();
        for (int num: arr) {
            if(seen.contains(num)) return true;
            seen.add(num);
        }
        return false;
    }
    public static boolean isDuplicateOptimised(int arr[]) {
        Arrays.sort(arr);
        int prev = arr[0];
        for (int i = 1; i < arr.length;) {
            if(prev == arr[i]) return true;
            prev = arr[i];
            i++;
        }
        return false;
    }
    public static boolean isDuplicateOptimised_i(int arr[]) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length;i++) {
            if(arr[i-1]== arr[i]) return true;
        }
        return false;
    }
}
