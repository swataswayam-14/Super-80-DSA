package Arrays_DSA_Questions.Hard;

import java.util.ArrayList;

public class CountReversePairs {
    public static void main(String[] args) {
        int[] a = {4, 1, 2, 3, 1};
        int cnt1 = countPairsBrute(a);
        int cnt2 = countReverseOptimal(a, a.length);
        System.out.println("The number of reverse pair is: " + cnt1);
        System.out.println("The number of reverse pair is: " + cnt2);
    }
    static int countPairsBrute(int a[]) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] > 2*a[j]) {
                    count++;
                }
            }
        }
        return count;
    }
    private static void merge(int[] arr,int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while (left<=mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            }else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i-low);
        }
    }
    static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid+1;
        int count = 0;
        for (int i=low; i<=mid; i++) {
            while (right <= high && arr[i] > 2*arr[right]) {
                right++;
            }
            count += (right - (mid+1));
        }
        return count;
    }
    static int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low>=high) {
            return count;
        }
        int mid = (low+high) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid+1, high);
        count += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return count;
    }
    static int countReverseOptimal(int[] skill, int n) {
        return mergeSort(skill, 0, n - 1);
    }
}
