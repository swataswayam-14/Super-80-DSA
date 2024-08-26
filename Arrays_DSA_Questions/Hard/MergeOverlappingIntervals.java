package Arrays_DSA_Questions.Hard;

import java.util.*;

public class MergeOverlappingIntervals {
    public static void main(String[] args) { 
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        List<List<Integer>> ans1 = mergeOverlappingIntervalsBrute(arr);
        List<List<Integer>> ans2 = mergeOverlappingIntervalsBrute(arr);
        System.out.print("The merged intervals are: \n");
        for (List<Integer> it : ans1) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
        System.out.println();
        for (List<Integer> it : ans2) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
        System.out.println();
    }
    public static List<List<Integer>> mergeOverlappingIntervalsBrute(int arr[][]) {// T.C is O(nlogn) + O(2n) and S.C is O(n)
        int n = arr.length;

        Arrays.sort(arr, new Comparator<int []>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            if (!ans.isEmpty() && end <= ans.get(ans.size() -1).get(1)) {
                continue;
            }
            for (int j=i+1;j<n;j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                }else {
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }
        return ans;
    }
    public static List<List<Integer>> mergeOverlappingIntervalsOptimal(int arr[][]) { // T.C is O(nlogn) + O(n) and S.C is O(n)
        int n = arr.length;

        Arrays.sort(arr, new Comparator<int []>() {
            public int compare(int a[], int b[]) {
                return a[0] - b[0];
            }
        });
        List<List<Integer>> ans = new ArrayList<>();

        for (int i=0;i<n;i++) {
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            } else {
                ans.get(ans.size() -1).set(1,Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
            }
        }
        return ans;
    }
}
