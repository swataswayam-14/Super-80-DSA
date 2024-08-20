package Arrays_DSA_Questions.Medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {
    public static void main(String[] args){
        List<Integer> A = Arrays.asList(new Integer[] {2, 1, 5, 4, 3, 0, 0});
        List<Integer> ans = nextGreaterPermutationOptimal(A);

        System.out.print("The next permutation is: [");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("]");

    }
    static List<Integer> nextGreaterPermutationOptimal(List<Integer> A) {
        int n = A.size();
        int breakIndex = -1;

        for (int i = n-2; i >= 0; i--) {
            if (A.get(i) < A.get(i+1)) {
                breakIndex = i;
                break;
            }
        }

        if (breakIndex == -1) {
            Collections.reverse(A);
            return A;
        }

        List<Integer> sublist = A.subList(breakIndex+1, n);
        Collections.reverse(sublist);
        return A;
    }
}