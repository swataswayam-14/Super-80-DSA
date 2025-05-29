package SDE_Sheet.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    private void findCombinations(int ind, int arr[], int target , List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind; i<arr.length;i++) {
            if(i > ind && arr[i] == arr[i-1]) continue;
            if (arr[i] > target) break;

            ds.add(arr[i]);
            findCombinations(i+1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
    public List<List<Integer>> combinationSumII(int [] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    public static void main(String[] args) {
        CombinationSumII solver = new CombinationSumII();

        // Test case 1: Typical case with duplicates
        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        System.out.println("Combinations for [10, 1, 2, 7, 6, 1, 5] with target 8:");
        System.out.println(solver.combinationSumII(candidates1, target1));

        // Test case 2: All elements same, should avoid duplicate combinations
        int[] candidates2 = {2, 2, 2, 2};
        int target2 = 4;
        System.out.println("Combinations for [2, 2, 2, 2] with target 4:");
        System.out.println(solver.combinationSumII(candidates2, target2));

        // Test case 3: No valid combination
        int[] candidates3 = {3, 4, 5};
        int target3 = 2;
        System.out.println("Combinations for [3, 4, 5] with target 2:");
        System.out.println(solver.combinationSumII(candidates3, target3));

        // Test case 4: Empty array
        int[] candidates4 = {};
        int target4 = 5;
        System.out.println("Combinations for [] with target 5:");
        System.out.println(solver.combinationSumII(candidates4, target4));

        // Test case 5: Target is 0
        int[] candidates5 = {1, 2, 3};
        int target5 = 0;
        System.out.println("Combinations for [1, 2, 3] with target 0:");
        System.out.println(solver.combinationSumII(candidates5, target5));
    }
}