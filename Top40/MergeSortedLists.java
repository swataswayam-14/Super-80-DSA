import java.util.ArrayList;
import java.util.List;

public class MergeSortedLists {
    public static List<Integer> merge(int arr1[], int arr2[]) {
        List<Integer> res = new ArrayList<>();
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < arr1.length && pointer2 < arr2.length) {
            if (arr1[pointer1] <= arr2[pointer2]) {
                res.add(arr1[pointer1]);
                pointer1++;
            } else {
                res.add(arr2[pointer2]);
                pointer2++;
            }
        }
        while (pointer1 < arr1.length) {
            res.add(arr1[pointer1]);
            pointer1++;
        }
        while (pointer2 < arr2.length) {
            res.add(arr2[pointer2]);
            pointer2++;
        }
        return res;
    }
}
