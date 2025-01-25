package Greedy_Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinimumCoins {
    public static int findMinimumCoin(int V, int deno[]) {
        List<Integer> ans = new ArrayList<>();

        for (int j = deno.length - 1; j >= 0; j--) {
            while (V >= deno[j]) {
                V -= deno[j];
                ans.add(deno[j]);
            }
        }
        System.out.print("The denominations used: ");
        for (Integer integer : ans) {
            System.out.print(integer+" ");
        }
        System.out.println();
        return ans.size();
    }
    public static void main(String[] args) {
        int deno[] = {1,2,5,10,20,50,100,500,1000};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a value: ");
        int V = sc.nextInt();
        sc.close();
        int minimumNoCoins = findMinimumCoin(V, deno);
        System.out.println("The minimum number of coins required is: "+minimumNoCoins);
    }
}
