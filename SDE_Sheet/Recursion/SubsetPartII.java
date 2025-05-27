package SDE_Sheet.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetPartII{
    public static void findSubsets(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ansList) {
        ansList.add(new ArrayList<>(ds));
        for (int i = ind; i<nums.length; i++) {
            if (i!= ind && nums[i] == nums[i-1]) continue;
            ds.add(nums[i]);
            findSubsets(i+1, nums, ds, ansList);
            ds.remove(ds.size()-1); // removing the added element for the next recursion call
        }
    }
    public List<List<Integer>> subsetsWithDup(int [] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ansList);
        return ansList;
    }
    public static void main(String[] args) {
        SubsetPartII solver = new SubsetPartII();

        // Test case 1: No duplicates
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result1 = solver.subsetsWithDup(nums1);
        System.out.println("Subsets of [1, 2, 3]: " + result1);

        // Test case 2: With duplicates
        int[] nums2 = {1, 2, 2};
        List<List<Integer>> result2 = solver.subsetsWithDup(nums2);
        System.out.println("Subsets of [1, 2, 2]: " + result2);

        // Test case 3: All elements are duplicates
        int[] nums3 = {2, 2, 2};
        List<List<Integer>> result3 = solver.subsetsWithDup(nums3);
        System.out.println("Subsets of [2, 2, 2]: " + result3);

        // Test case 4: Empty array
        int[] nums4 = {};
        List<List<Integer>> result4 = solver.subsetsWithDup(nums4);
        System.out.println("Subsets of []: " + result4);
    }
}