package ArraysAndHashing;

import java.util.*;

public class Majorityelement {
    public static List<Integer> majorityElementBruteForce(int[] v) {
        int n = v.length;
        List<Integer> ls = new ArrayList<>();

        for (int i=0;i<n;i++) {
            if(ls.size() == 0 || ls.get(0) != v[i]) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if(v[j] == v[i]) {
                        cnt ++;
                    }
                }
                if (cnt > (n/3)) {
                    ls.add(v[i]);
                }
                if(ls.size() == 2) break;
            }
        }
        return ls;
    }

    public static List<Integer> majorityElementOptimal(int[] v) {
        int n = v.length;
        List<Integer> ls = new ArrayList<>();
    
        //array to store the count of each element
        int[] count = new int[101];
        int mini = (int) (n / 3) + 1;
    
        for (int i = 0; i < n; i++) {
            count[v[i]]++;
            if (count[v[i]] == mini) {
                ls.add(v[i]);
            }
            if (ls.size() == 2) {
                break;
            }
        }
        return ls;
    }
    public static List<Integer> majorityElementMostOptimal(int []v) {
        int n = v.length;
        int cnt1 = 0, cnt2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;

        // applying the Extended Boyer Moore's Voting Algorithm:
        for (int i = 0; i < n; i++) {
            if(cnt1 == 0 && el2 != v[i]) {
                cnt1 = 1;
                el1 = v[i];
            }
            if(cnt2 == 0 && el1 != v[i]) {
                cnt2 = 1;
                el2 = v[i];
            }else if( v[i] == el1) cnt1 ++;
            else if( v[i] == el2) cnt2 ++;
            else {
                cnt1 --;
                cnt2 --;
            }
        }
        List<Integer> ls = new ArrayList<>();
        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if(v[i] == el1) cnt1 ++;
            if(v[i] == el2) cnt2 ++;
        }

        int mini = (int)(n/3) + 1;
        if(cnt1 >= mini) ls.add(el1);
        if(cnt2 >= mini) ls.add(el2);
        return ls;
    }
    public static void main(String[] args) {
        int[] arr = {11, 33, 33, 11, 33, 11};
        List<Integer> ans = majorityElementMostOptimal(arr);
        System.out.print("The majority elements are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
