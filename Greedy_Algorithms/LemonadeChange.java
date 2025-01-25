package Greedy_Algorithms;

public class LemonadeChange {
    public static Boolean canSale(int arr[]) {
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 5) {
                five += 1;
            } else if (arr[i] == 10) {
                if (five != 0) {
                    five -= 1;
                    ten += 1;
                } else {
                    printResult(five, ten, twenty);
                    return false;
                }
            } else {
                if (ten != 0 && five != 0) {
                    ten -= 1;
                    five -= 1;
                    twenty += 1;
                } else if (five >= 3) {
                    five -= 3;
                    twenty += 1;
                } else {
                    printResult(five, ten, twenty);
                    return false;
                }
            }
        }
        printResult(five, ten, twenty);
        return true;
    }
    public static void printResult(int five, int ten, int twenty) {
        int totalIncome = (five * 5 + ten * 10 + twenty * 20);
        System.out.println("The total income of the vendor is: "+totalIncome);
        System.out.println("Total number of lemonade sold: "+totalIncome/5);
    }
    public static void main(String[] args) {
        int arr1[] = {5,5,5,10,20};
        int arr2[] = {5,5,10,10,20};
        System.out.println(canSale(arr1));
        System.out.println(canSale(arr2));
    }
}