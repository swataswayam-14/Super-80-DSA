//  Kth Largest Element in Array
// Given: An unsorted array of integers nums[] and an integer k.

// Goal: Return the kth largest element in the array (not sorted order, but actual value).

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
    //brute force : sort the array and return the element at n-k
    //optmised 1: use a min heal of size k -> O(nlogk)
    //optimised 2: use quickselect algo -> O(n) average

    public static int findKthLargestBrute(int nums[], int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    public static int findKthLargestOptimised_i(int nums[], int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num: nums) {
            minHeap.add(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
    // optmised 2 : quick select like quick sort
    //partition the array like quicksort
    // if pivot is at index n-k , we found kth largest
    //else recurse on left and right half
    public static int findKthLargestOptimised_ii(int nums[], int k) {
        int target = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, target);
    }
    private static int quickSelect(int nums[], int left, int right, int k) {
        int pivot = nums[right];
        int pIndex = left;

        for(int i=left;i<right;i++) {
            if(nums[i] <= pivot) {
                swap(nums, i, pIndex++);
            }
        }
        swap(nums, pIndex, right);
        if(pIndex == k) return nums[pIndex];
        else if (pIndex < k) return quickSelect(nums, pIndex + 1, right, k);
        else return quickSelect(nums, left, pIndex - 1, k);
    }
    private static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
