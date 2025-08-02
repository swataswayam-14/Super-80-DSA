package ArrayProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class UnionOfArray {
     public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        if(a == null || b == null) {
            return new ArrayList<>();
        }
        Set<Integer> union = new HashSet<>();
        for(int i=0;i<a.length;i++) {
            union.add(a[i]);
        }
        for(int i=0;i<b.length;i++){
            union.add(b[i]);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int num: union) {
            res.add(num);
        }
        Collections.sort(res);
        return res;
    }
    public static ArrayList<Integer> findUnionOptimised(int a[] ,int b[]) {
        Set<Integer> union = new TreeSet<>(); // treeset keeps elements in sorted order
        if(a != null) {
            for(int num : a) union.add(num);
        }
        if( b!= null) {
            for(int num: b) {
                union.add(num);
            }
        }
        return new ArrayList<>(union);
    }

}
