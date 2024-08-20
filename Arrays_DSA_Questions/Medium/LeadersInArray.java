package Arrays_DSA_Questions.Medium;

import java.util.ArrayList;

public class LeadersInArray {
    public static void main(String[] args) {
        int arr[] = {10,22,12,3,0,6};
        System.out.println(printLeaders(arr));
        System.out.println(getLeadersBrute(arr));
        System.out.println(getLeadersOptimal(arr));
    }
    static ArrayList<Integer> printLeaders(int arr[]) { // O(n^2)

        int n = arr.length;
        ArrayList<Integer> leaders = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i; j < n; j++) {
                if (arr[i] >= arr[j]) {
                    count++;
                } else {
                    break;
                }
            }
            if (count == n-i) {
                leaders.add(arr[i]);
            }
        }
        return leaders;
    }

    static ArrayList<Integer> getLeadersBrute(int arr[]) { // O(n^2) T.C

        int n = arr.length;

        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean isLeader = true;
            for (int j = i+1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    isLeader = false;
                }
            }
            if (isLeader) {
                lst.add(arr[i]);
            }
        }
        return lst;
    }

    static ArrayList<Integer> getLeadersOptimal(int arr[]) { // O(n) T.C

        int n = arr.length;
        ArrayList<Integer> lst = new ArrayList<>();

        int maximum = arr[n-1];
        lst.add(maximum);

        for (int i = n-2; i >= 0; i--) {
            if (arr[i] > maximum) {
                lst.add(arr[i]);
                maximum = arr[i];
            }
        }
        return lst;
    }
}
