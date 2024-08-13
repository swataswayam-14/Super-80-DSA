package Arrays_DSA_Questions;

import java.util.HashSet;

public class UnionOfArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {3, 4, 5, 6};

        int[] result = union(arr1, arr2);
        for (int num : result) {
            System.out.print(num + " ");
        }
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
}