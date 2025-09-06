package DSA_Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.w3c.dom.stylesheets.LinkStyle;


class Pair {
    int diff, value;
    Pair(int d, int v) {
        this.diff = d;
        this.value = v;
    }
}
public class FindKClosestElements {
    public static List<Integer> findKClosestBrute (int arr[], int k, int x) {
        List<Pair> diffList = new ArrayList<>();
        
        for(int num: arr) {
            diffList.add(new Pair(Math.abs(num - x), num));
        }
        //sorting by distance
        Collections.sort(diffList, (a,b) -> {
            if(a.diff == b.diff) return Integer.compare(a.value, b.value);
            return Integer.compare(a.diff, b.diff);
        });

        List<Integer> result = new ArrayList<>();
        for(int i=0;i<k;i++) {
            result.add(diffList.get(i).value);
        }
        Collections.sort(result);
        return result;
    }
    public static List<Integer> findClosestElements(int arr[], int k, int x) {
        int left = 0;
        int right = arr.length - k;

        while (left < right) {
            int mid = (left+right) / 2;
            //move right if left side is having a more distance than x
            if(x-arr[mid] > arr[mid+k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=left; i< left+k ; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
