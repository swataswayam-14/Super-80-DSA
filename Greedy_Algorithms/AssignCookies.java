package Greedy_Algorithms;

import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] greed, int[]cookieSize) {
        int n = greed.length;
        int m = cookieSize.length;

        Arrays.sort(greed);
        Arrays.sort(cookieSize);

        int l = 0;
        int r = 0;

        while(l<n && r < m) {
            if (greed[l] <= cookieSize[r]) {
                l++;
            }
            r++;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] greed = {1,5,3,3,4};
        int[] cookieSize = {4,2,1,2,1,3};

        System.out.println("Array Representing Greed: ");
        for (int i = 0; i < greed.length; i++) {
            System.out.print(greed[i] +" ");
        }
        System.out.println();
        System.out.println("Array Representing CookieSize");
        for (int i = 0; i < cookieSize.length; i++) {
            System.out.print(cookieSize[i]+" ");
        }
        System.out.println();
        System.out.println("The number of children assigned with the cookies: "+findContentChildren(greed, cookieSize));
    }
}
