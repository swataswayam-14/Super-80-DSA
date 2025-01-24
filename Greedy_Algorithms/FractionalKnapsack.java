package Greedy_Algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    static double fractionalKnapsackSolve(int W, Item arr[], int n) {
        Arrays.sort(arr, new itemComparator());//sorts in descending order according to the ratio

        int currWeight = 0;
        double finalValue = 0.0;

        for (int i = 0; i < n; i++) {
            if (currWeight + arr[i].weight <= W) {
                currWeight += arr[i].weight;
                finalValue += arr[i].value;
            } else {
                double remain = ((double)(arr[i].value) / (double) (arr[i].weight)) * (W-currWeight);
                finalValue += remain;
            }
        }
        return finalValue;
    }
    public static void main(String[] args) {
        int n=3;
        int weight = 50;
        Item arr[] = {
            new Item(100, 20),
            new Item(60, 10),
            new Item(120, 30)
        };
        double ans = fractionalKnapsackSolve(weight, arr, n);
        System.out.println("The maximum value is "+ans);
    }
}

class Item {
    int value;
    int weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class itemComparator implements Comparator<Item>
{

    @Override
    public int compare(Item o1, Item o2) {
        double r1 = (double)(o1.value) / (double)(o1.weight);
        double r2 = (double)(o2.value)/ (double)(o2.weight);

        if (r1<r2) {
            return 1;
        }else if(r1 > r2) {
            return -1;
        } else {
            return 0;
        }
    }
    
}

