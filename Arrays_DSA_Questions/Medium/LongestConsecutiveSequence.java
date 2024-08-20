package Arrays_DSA_Questions.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4};
        int ans1 = longestSequenceBrute(a);
        int ans2 = longestSequenceBetter(a);
        int ans3 = longestSequenceOptimal(a);
        System.out.println("The longest consecutive sequence is " + ans1);
        System.out.println("The longest consecutive sequence is " + ans2);
        System.out.println("The longest consecutive sequence is " + ans3);
    }
    static boolean linearSearch(int arr[], int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }
    static int longestSequenceBrute(int arr[]) {
        int n = arr.length;
        int longest = 1;

        for (int i = 0; i < n; i++) {
            int x = arr[i];
            int count = 1;

            while (linearSearch(arr, x + 1) == true) {
                x += 1;
                count += 1;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
    static int longestSequenceBetter(int arr[]) {
        int n = arr.length;

        if (n == 0) {
            return 0;
        }
        int longest = 1;
        int count = 1;
        
        Arrays.sort(arr);
        int lastSmallest = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if( arr[i] - 1 == lastSmallest ) {
                count++;
                lastSmallest = arr[i];
            } else if(arr[i] != lastSmallest) {
                count = 1;
                lastSmallest = arr[i];
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
    static int longestSequenceOptimal(int arr[]) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        for (int it: set) {
            if (!(set.contains(it-1))) {
                int count = 1;
                int x = it;
                while(set.contains(x+1)) {
                    x+=1;
                    count+=1;
                }
                longest = Math.max(count, longest);
            }
        }
        return longest;
    }
}

