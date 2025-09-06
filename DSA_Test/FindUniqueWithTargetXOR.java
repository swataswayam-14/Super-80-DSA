package DSA_Test;

import java.util.HashSet;
import java.util.Set;

public class FindUniqueWithTargetXOR {
    /*
    Find Unique Triplet with Target XOR
    Given an array arr and a value target, return true if there exists three distinct elements a, b, c such that a ^ b ^ c == target.

    Concepts: Bit Manipulation, Hashing
     */

    //brute force : try out every possible combinations
    public static boolean isExists(int arr[], int target) {
        int n = arr.length;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                for(int k=j+1;k<n;k++) {
                    if((arr[i] ^ arr[j] ^ arr[k]) == target) return true;
                }
            }
        }
        return false;
    }
    public static boolean isExistsOptimised(int arr[], int target) {
        int n = arr.length;
        Set<Integer> pairXORs = new HashSet<>();
        for(int c=2;c<n;c++) {
            int required = target ^ arr[c];
            if(pairXORs.contains(required)) return true;

            for(int i=0;i<c-1;i++) {
                for(int j=i+1;j<c;j++) {
                    pairXORs.add(arr[i] ^ arr[j]);
                }
            }
        }
        return false;
    }
}
