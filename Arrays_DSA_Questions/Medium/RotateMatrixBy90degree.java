package Arrays_DSA_Questions.Medium;

public class RotateMatrixBy90degree {
    public static void main(String[] args) {
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int rotated[][] = rotateMatrixBy90Brute(arr);
        int rotated1[][] = rotateMatrixBy90Optimal(arr);

        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated.length; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < rotated1.length; i++) {
            for (int j = 0; j < rotated1.length; j++) {
                System.out.print(rotated1[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int[][] rotateMatrixBy90Brute(int arr[][]) {

        int newArr[][] = new int[arr.length][arr[0].length]; // 

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                newArr[j][arr.length-i-1] = arr[i][j];
            }
        }
        return newArr;
    }

    static int[][] rotateMatrixBy90Optimal(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length / 2; j++) {
                int temp = 0;
                temp = arr[i][j];
                arr[i][j] = arr[i][arr.length - 1 - j];
                arr[i][arr.length - 1 - j] = temp;
            }
        }
        return arr;
    }
}
