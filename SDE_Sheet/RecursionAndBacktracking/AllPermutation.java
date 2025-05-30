package SDE_Sheet.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class AllPermutation {
    private void recurPermute(int index, int nums[], List<List<Integer>> ans){
        if (index == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index; i<nums.length;i++) {
            swap(i, index, nums);
            recurPermute(index+1, nums, ans);
            swap(i, index, nums);
        }
    }
    private void swap(int i, int j, int nums[]) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public List<List<Integer>> permute(int nums[]) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute( 0, nums, ans);
        return ans;
    }
    public static void main(String[] args) {
        AllPermutation ap = new AllPermutation();
        
        // Test case 1
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result1 = ap.permute(nums1);
        System.out.println("Permutations of [1, 2, 3]:");
        for (List<Integer> perm : result1) {
            System.out.println(perm);
        }

        // Test case 2
        int[] nums2 = {0, 1};
        List<List<Integer>> result2 = ap.permute(nums2);
        System.out.println("\nPermutations of [0, 1]:");
        for (List<Integer> perm : result2) {
            System.out.println(perm);
        }

        // Test case 3
        int[] nums3 = {1};
        List<List<Integer>> result3 = ap.permute(nums3);
        System.out.println("\nPermutations of [1]:");
        for (List<Integer> perm : result3) {
            System.out.println(perm);
        }
    }
}
