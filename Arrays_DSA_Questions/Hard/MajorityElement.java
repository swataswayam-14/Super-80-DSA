package Arrays_DSA_Questions.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {11, 33, 33, 11, 33, 11};
        List<Integer> ans1 = majorityElementBrute(arr);
        List<Integer> ans2 = majorityElementsBetter(arr);
        List<Integer> ans3 = majorityElementOptimal(arr);
        System.out.print("The majority elements are: ");
        for (int i = 0; i < ans1.size(); i++) {
            System.out.print(ans1.get(i) + " ");
        }
        for (int i = 0; i < ans2.size(); i++) {
            System.out.print(ans2.get(i) + " ");
        }
        for (int i = 0; i < ans3.size(); i++) {
            System.out.print(ans3.get(i) + " ");
        }
        System.out.println();
    }
    static List<Integer> majorityElementBrute (int []v) { // T.C is O(n^2) and S.C is O(1)
        int n = v.length;
        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (ls.size() == 0 || ls.get(0) != v[i]) {
                int cnt = 0;
                for (int j = 0; j < n; j++) {
                    if (v[j] == v[i]) {
                        cnt++;
                    }
                }
                if (cnt > (n/3)) {
                    ls.add(v[i]);
                }
            }
            if (ls.size() == 2) break;
        }
        return ls;
    }
    static List<Integer> majorityElementsBetter(int v[]){ // T.C is O(n) or O(nlogn) and S.C is O(n) (map data structure)

        int n = v.length;
        List<Integer> ls = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        int minimum = (int)(n/3);

        for (int i = 0; i < n; i++) {
            int value = freq.getOrDefault(v[i], 0);
            freq.put(v[i], value+1);

            if (freq.get(v[i]) >= minimum) {
                ls.add(v[i]);
            }
            if (ls.size() == 2) {
                break;
            }
        }
        return ls;
    }

    static List<Integer> majorityElementOptimal(int v[]) { // T.C is O(2n) and S.C is O(1)

        List<Integer> ls = new ArrayList<>();
        
        int ctn1 = 0;
        int ctn2 = 0;
        int el2 = Integer.MIN_VALUE;
        int el1 = Integer.MIN_VALUE;

        int n = v.length;

        for (int i = 0; i < n; i++) {
            if (ctn1 == 0 && el2 != v[i]) {
                ctn1 = 1;
                el1 = v[i];
            } else if( ctn2 == 0 && el1 != v[i]){
                ctn2 = 1;
                el2 = v[i];
            } else if( el1 == v[i]) {
                ctn1++;
            } else if(el2 == v[i]) {
                ctn2++;
            } else {
                ctn1--;
                ctn2--;
            }
        }
        ctn1 = 0;
        ctn2 = 0;
        int minimum = (int) (n/3);
        for (int i = 0; i < n; i++) {
            if (v[i] == el1) ctn1++;
            if(v[i] == el2) ctn2++;
        }
        if (ctn1>=minimum) {
            ls.add(el1);
        }
        if (ctn2>=minimum) {
            ls.add(el2);
        }
        return ls;
    }
}
