package SDE_Sheet.Recursion;

import java.util.ArrayList;
import java.util.List;

public class kthPermutationSequence{
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();
        for(int i=1;i<n;i++) {
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);
        String ans = "";
        k = k-1;
        while(true) {
            ans = ans + numbers.get(k/fact);
            numbers.remove(k/fact);
            if(numbers.size() == 0) break;
            k = k%fact;
            fact = fact / numbers.size();
        }
        return ans;
    }
    public static void main(String[] args) {
        kthPermutationSequence solver = new kthPermutationSequence();

        // Test case 1: Standard case
        int n1 = 3, k1 = 3;
        System.out.println("k = 3 permutation of n = 3: " + solver.getPermutation(n1, k1)); // Expected: "213"

        // Test case 2: Smallest permutation
        int n2 = 4, k2 = 1;
        System.out.println("k = 1 permutation of n = 4: " + solver.getPermutation(n2, k2)); // Expected: "1234"

        // Test case 3: Last permutation
        int n3 = 3, k3 = 6;
        System.out.println("k = 6 permutation of n = 3: " + solver.getPermutation(n3, k3)); // Expected: "321"

        // Test case 4: Middle permutation
        int n4 = 4, k4 = 12;
        System.out.println("k = 12 permutation of n = 4: " + solver.getPermutation(n4, k4)); // Expected: "2431"

        // Test case 5: Single element
        int n5 = 1, k5 = 1;
        System.out.println("k = 1 permutation of n = 1: " + solver.getPermutation(n5, k5)); // Expected: "1"
    }
}