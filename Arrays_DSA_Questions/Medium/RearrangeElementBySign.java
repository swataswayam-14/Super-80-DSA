package Arrays_DSA_Questions.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeElementBySign {
    public static void main(String[] args) {
        int arr[] = {-1, 2, 3, 4, -8, -5};
        rearrangeElement(arr);
        System.out.println(Arrays.toString(arr));
        int arr2[] =  {-1, 2, 3, 4, -8, -5};
        rearrangeMethod2(arr2);
        System.out.println(Arrays.toString(arr2));
        int arr3[] =  {-1, 2, 3, 4, -8, -5};
        System.out.println(Arrays.toString(rearrangeElementBrute(arr3)));
        int arr4[] =  {-1, 2, 3, 4, -8, -5};
        System.out.println(Arrays.toString(rearrangeElementOptimal(arr4)));
    }

    static void rearrangeElement(int arr[]) { // the order is not maintained
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if ((i % 2 == 0) && (arr[i] < 0)) {
                int c = i + 1; 
                while (c < n) {
                    if (arr[c] >= 0) {
                        int temp = arr[i];
                        arr[i] = arr[c];
                        arr[c] = temp;
                        break;
                    }
                    c++;
                }
            } else if ((i % 2 != 0) && (arr[i] >= 0)) {
                int c = i + 1; 
                while (c < n) {
                    if (arr[c] < 0) { 
                        int temp = arr[i];
                        arr[i] = arr[c];
                        arr[c] = temp;
                        break;
                    }
                    c++;
                }
            }
        }
    }
    static void rearrangeMethod2(int arr[]) { //the order is not maintained
        Arrays.sort(arr); 
        int n = arr.length;
        int midLength = n / 2;
        int i = 0;
        while ((i<n && midLength < n)) {
            int temp = arr[i];
            arr[i] = arr[midLength];
            arr[midLength] = temp;
            i+=2;
            midLength++;
        }
    }

    static int [] rearrangeElementBrute(int arr[]) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[0] >= 0 ) {
                pos.add(arr[i]);
            }else {
                neg.add(arr[i]);
            }
        }
        int posIdx = 0;
        int negIdx = 1;
        int i = 0;
        while (posIdx < n && negIdx < n && i < pos.size() && i < neg.size()) {
            arr[posIdx] = pos.get(i);
            arr[negIdx] = neg.get(i);
            posIdx += 2;
            negIdx += 2;
            i++;
        }
        return arr;
    }
    static int[] rearrangeElementOptimal(int arr[]) {
        int n = arr.length;
        int posIdx = 0; 
        int negIdx = 1; 

        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                if (posIdx < n) {
                    newArr[posIdx] = arr[i];
                    posIdx += 2; 
                }
            } else {
                if (negIdx < n) {
                    newArr[negIdx] = arr[i];
                    negIdx += 2; 
                }
            }
        }

        return newArr;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}