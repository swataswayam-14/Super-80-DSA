package Arrays_DSA_Questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UnionOfArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {3, 4, 5, 6};

        int[] result = union(arr1, arr2);
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(unionOptimal(arr1, arr2));
    }
    static int[] union(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr1) {
            set.add(num);
        }

        for (int num : arr2) {
            set.add(num);
        }

        int[] unionArr = new int[set.size()];
        int index = 0;
        for (int num : set) {
            unionArr[index++] = num;
        }

        return unionArr;
    }
    static List<Integer> unionOptimal(int arr1[],int arr2[]) {
        int n1 = arr1.length;
        int n2 = arr2.length;

        int i=0;
        int j=0;

        List<Integer> lst = new ArrayList<>();

        while(i<n1 && j< n2) {
            if(arr1[i] <= arr2[j]) {
                if(lst.size() == 0 || !lst.contains(arr1[i])) {
                    lst.add(arr1[i]);
                }
                i++;
            }else{
                if(lst.size() == 0 || !lst.contains(arr2[j])) {
                    lst.add(arr2[j]);
                }
                j++;
            }
        }
        while(i<n1) {
            if(lst.size() == 0 || !lst.contains(arr1[i])) {
                lst.add(arr1[i]);
            }
            i++;
        }
        while(j<n2) {
            if(lst.size() == 0 || !lst.contains(arr2[j])) {
                lst.add(arr2[j]);
            }
            j++;
        }
        return lst;
    }
}