// You are given an integer array nums[].

// Your goal:
//  Find all unique triplets (a, b, c) such that:

// a + b + c == 0  

// Each triplet must be in non-descending order (i.e., [a, b, c] with a ≤ b ≤ c)

// No duplicate triplets allowed in the result

// [-1,0,1,2,-2,-4]
//sort it 
// [-4, -1, -1, 0, 1,2]
//triplet that sum to 0 
// -1,-1,2
// -1,0,1

//output : [[-1,-1,2],[-1,0,1]]

//input : [0,1,1]
//sum = 0
//output: []

//intuition : 
// variation of the 2 sum problem

//steps : 
// fix the element nums[i]
// apply 2 pointer on subarray nums[i+1...n-1]
//skip duplicates for both i, left and right
//since we want all unique triplets , we must sort the array to make duplicate elimination easier

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> findTripletBrute(int nums[], int target){
    List<List<Integer>> res = new ArrayList<>(); 
        for(int i=0;i <= nums.length-3; i++) {
            for(int j=i+1;j<= nums.length - 2; j++) {
                for(int k = j+1; k<= nums.length -1; k++) {
                    List<Integer> triplet = new ArrayList<>();
                    if(nums[i] + nums[j] + nums[k] == target){
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        res.add(triplet);
                    }
                }
            }
        }
        return res;
    }
    public static List<List<Integer>> tripletOptimised(int nums[], int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length -2 ; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue; // skip duplicates
            int left = i+1;
            int right = nums.length - 1;
            while(left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if(total == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1])left++;
                    while(left<right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (total < target) {
                    left++;
                } else {
                    right --;
                }
            }
        }
        return res;
    }
}
