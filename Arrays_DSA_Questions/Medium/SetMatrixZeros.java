package Arrays_DSA_Questions.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZeros {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int n = matrix.size();
        int m = matrix.get(0).size();

        ArrayList<ArrayList<Integer>> ans = setZerosBrute(matrix, n, m);
        ArrayList<ArrayList<Integer>> ans2 = setZerosBetter(matrix, n, m);
        ArrayList<ArrayList<Integer>> ans3 = setZerosOptimal(matrix, n, m);

        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : ans) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : ans2) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : ans3) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
    static void markRow (ArrayList<ArrayList<Integer>> matrix , int n, int m, int i) {
        for(int j=0; j<m; j++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j,-1);
            }
        }
    }
    static void markCol (ArrayList<ArrayList<Integer>> matrix , int n, int m, int j) {
        for(int i=0; i<n; i++) {
            if (matrix.get(i).get(j) != 0) {
                matrix.get(i).set(j,-1);
            }
        }
    }
    static ArrayList<ArrayList<Integer>> setZerosBrute(ArrayList<ArrayList<Integer>> matrix , int n , int m) {
        //T.C is of the order of n cube
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    markCol(matrix, n, m, j);
                    markRow(matrix, n, m, i);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == -1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;
    }
    static ArrayList<ArrayList<Integer>> setZerosBetter(ArrayList<ArrayList<Integer>> matrix , int n , int m){
        //T.C is O(n square) and S.C is O(n)
        int col[] = new int[m];
        int row[] = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;
    }
    static ArrayList<ArrayList<Integer>> setZerosOptimal(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
        // T.C is O(n sqaure) and S.C is O(1)
        int col0 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
                    matrix.get(i).set(0, 0);
                    if (j != 0)
                        matrix.get(0).set(j, 0);
                    else
                        col0 = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix.get(i).get(j) != 0) {
                    if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
                        matrix.get(i).set(j, 0);
                    }
                }
            }
        }
        if (matrix.get(0).get(0) == 0) {
            for (int j = 0; j < m; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix.get(i).set(0, 0);
            }
        }

        return matrix;
    }

}
