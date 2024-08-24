package Arrays_DSA_Questions.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4};
        int n = arr.length;
        List<List<Integer>> ans1 = tripletBrute(n, arr);
        List<List<Integer>> ans2 = tripletBrute(n, arr);
        List<List<Integer>> ans3 = tripletBrute(n, arr);
        for (List<Integer> it : ans1) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
        for (List<Integer> it : ans2) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
        for (List<Integer> it : ans3) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
    static List<List<Integer>> tripletBrute(int n,int[] arr) { // T.C of O(n^3* log(no. of unique triplets)) and space complexity of O(2*number of unique triplets)
        Set<List<Integer>> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int j2 = j+1; j2 < n; j2++) {
                    if (arr[i] + arr[j] + arr[j2] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[j2]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
    static List<List<Integer>> tripletBetter (int n, int arr[]) { // T.C is O(n^2 log(no of unique triplets)) and S.C is O(2* no. of unique triplets) + O(n)

        Set<List<Integer>> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> hashset = new HashSet<>();
            for (int j = 0; j < n; j++) {
                int third = -(arr[i] + arr[j]);
                if (hashset.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    temp.sort(null);
                    st.add(temp);
                }
                hashset.add(arr[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }

    static List<List<Integer>> tripletOptimal (int n, int arr[]) { // The T.C is O(nlogn) + O(n^2) and S.C is O(no of unique triplets)

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (i != 0 && arr[i] == arr[i-1]) continue;

            int j = i+1;
            int k = n-1;

            while(j<k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;

                    while (j<k && arr[j] == arr[j-1]) j++;
                    while (j<k && arr[k] == arr[k+1]) k--;
                }
            }
        }
        return ans;
    }
}
