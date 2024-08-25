package Arrays_DSA_Questions.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target = 9;
        List<List<Integer>> ans1 = FourSumBrute(nums, target);
        List<List<Integer>> ans2 = FourSumBetter(nums, target);
        List<List<Integer>> ans3 = fourSumOptimal(nums, target);
        System.out.println("The quadruplets are: ");
        for (List<Integer> it : ans1) {
            System.out.print("[");
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
        System.out.println("The quadruplets are: ");
        for (List<Integer> it : ans2) {
            System.out.print("[");
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
        System.out.println("The quadruplets are: ");
        for (List<Integer> it : ans3) {
            System.out.print("[");
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }

    static List<List<Integer>> FourSumBrute(int arr[], int target) { // the T.C is O(n^4) and S.C is O(unique 4plets)
        int n = arr.length;
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k<n; k++) {
                    for (int l = k+1; l<n; l++) {
                        long sum = arr[i];
                        sum+=arr[j];
                        sum+=arr[k];
                        sum+=arr[l];
                        if (sum == target) {
                            ArrayList<Integer> temp = new ArrayList<>();
                            temp.add(arr[i]);
                            temp.add(arr[j]);
                            temp.add(arr[k]);
                            temp.add(arr[l]);
                            Collections.sort(temp);
                            ans.add(temp);
                        }
                    }
                }
            }
        }
        List<List<Integer>> answer = new ArrayList<>(ans);
        return answer;
    }
    static List<List<Integer>> FourSumBetter(int nums[], int target) { // The T.C is O(n^3*log(n)) and S.C is O(n)
        int n = nums.length; 
        Set<List<Integer>> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> hashset = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long fourth = target - sum;
                    if (hashset.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add((int) fourth);
                        temp.sort(Integer::compareTo);
                        st.add(temp);
                    }
                    hashset.add((long) nums[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
    static List<List<Integer>> fourSumOptimal (int arr[],int target) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i>0 && arr[i] == arr[i-1]) continue;
            for (int j = i+1; j < n; j++) {
                if (j>i+1 && arr[j] == arr[j-1]) continue;

                int k = j+1;
                int l = n-1;
                while (k<l) {
                    long sum = arr[i]+arr[j];
                    sum += (arr[k]+arr[l]);
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(arr[l]);
                        ans.add(temp);
                        
                        k++;
                        l--;
                        while( k<l && arr[k] == arr[k-1]) k++;
                        while (k<l && arr[l] == arr[l+1]) l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }   
            }
        }
        return ans;
    }
}
