package Arrays_DSA_Questions.Hard;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        int r = 5;
        int c = 3;
        int element = pascalTriangle(r, c);
        System.out.println("The element at position (r,c) is : "+ element);
        int n = 5;
        printPascalTriangleRowBrute(n);
        printPascalTriangleRowOptimised(n);
        List<List<Integer>> ans = pascalTriangle(n);
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
    static int nCr(int n, int r) { //we are given the row number r and the column number c, and we need to find out the element at position (r,c). 
        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n-i);
            res = res / (i+1);
        }
        return (int)res;
    }
    static int pascalTriangle(int r, int c) {
        int element = nCr(r-1, c-1);
        return element;
    }
    static void printPascalTriangleRowBrute(int n) { //Given the row number n. Print the n-th row of Pascal’s triangle.
        for (int c = 1; c <= n; c++) {
            System.out.print(nCr(n-1, c-1)+" ");
        }
        System.out.println();
    }
    static void printPascalTriangleRowOptimised(int n) {
        int ans = 1;
        System.out.print(ans+" ");
        for (int i = 1; i < n; i++) {
            ans = ans * (n-i);
            ans = ans / i;
            System.out.print(ans+" ");
        }
        System.out.println();
    }
    static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int row = 1; row<=n; row++) {
            List<Integer> tempList = new ArrayList<>();
            for (int col = 1; col<= row; col++) {
                tempList.add(nCr(row-1, col-1));
            }
            ans.add(tempList);
        }
        return ans;
    }
}
