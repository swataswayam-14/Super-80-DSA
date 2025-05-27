package SDE_Sheet.Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSums {
    //given a list (arr) of N integers, print sums of all subsets in it, output be printed in increasing order of sums
    public static void func(int idx, int sum, ArrayList<Integer> arr, int N, ArrayList<Integer> subsetSum) {
        if (idx == N) {
            subsetSum.add(sum);
            return;
        }
        func(idx+1, sum+arr.get(idx), arr, N, subsetSum); // pick the element
        func(idx+1, sum, arr, N, subsetSum); // donot pick the element
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> subsetSum = new ArrayList<>();
        func(0, 0, arr, N, subsetSum);
        Collections.sort(subsetSum);
        return subsetSum;
    }
    public static void main(String[] args) {
        SubsetSums subsetSumsSolver = new SubsetSums();

        // Test case 1
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(3);
        ArrayList<Integer> result1 = subsetSumsSolver.subsetSums(arr1, arr1.size());
        System.out.println("Subset sums of [1, 2, 3]: " + result1);

        // Test case 2
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(5);
        arr2.add(-1);
        arr2.add(2);
        ArrayList<Integer> result2 = subsetSumsSolver.subsetSums(arr2, arr2.size());
        System.out.println("Subset sums of [5, -1, 2]: " + result2);

        // Test case 3 (empty list)
        ArrayList<Integer> arr3 = new ArrayList<>();
        ArrayList<Integer> result3 = subsetSumsSolver.subsetSums(arr3, arr3.size());
        System.out.println("Subset sums of []: " + result3);
    }
}
