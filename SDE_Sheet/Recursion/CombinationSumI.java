package SDE_Sheet.Recursion;
import java.util.*;

public class CombinationSumI {
    private void findCombinations(int ind, int arr[], int target, List<List<Integer>> ans, List<Integer> ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1); // backtrack after recursion
        }
        findCombinations(ind+1, arr, target, ans, ds);
    }
    public List<List<Integer>> combinationSum(int [] candidates , int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        CombinationSumI solver = new CombinationSumI();

        // Test case 1: Normal case
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println("Combinations for [2, 3, 6, 7] with target 7:");
        System.out.println(solver.combinationSum(candidates1, target1));

        // Test case 2: Candidates include 1
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println("Combinations for [2, 3, 5] with target 8:");
        System.out.println(solver.combinationSum(candidates2, target2));

        // Test case 3: No combination possible
        int[] candidates3 = {4, 5};
        int target3 = 3;
        System.out.println("Combinations for [4, 5] with target 3:");
        System.out.println(solver.combinationSum(candidates3, target3));

        // Test case 4: Empty array
        int[] candidates4 = {};
        int target4 = 7;
        System.out.println("Combinations for [] with target 7:");
        System.out.println(solver.combinationSum(candidates4, target4));
    }
}