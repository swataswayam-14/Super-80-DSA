package DSA_Test;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static int fibRecur(int n) {
        if(n < 0) return 0;
        if (n==0 || n== 1) return n;

        return fibRecur(n-1) + fibRecur(n-2);
    }
    private static Map<Integer, Integer> map = new HashMap<>();

    public static int fibMemo(int n) {

        if(n< 0) return 0;
        if (n <= 1) return n;

        if(map.containsKey(n)) return map.get(n);
        int res = fibMemo(n-1) + fibMemo(n-2);
        map.put(res, n);
        return res;
    }
    public static int fibMemoOptmised(int n, Map<Integer, Integer> map) {
        if(n < 0) return 0;
        if(n <= 1) return n;

        if(map.containsKey(n)) return map.get(n);
        int res = fibMemoOptmised(n-1, map) + fibMemoOptmised(n-2, map);
        map.put(res, n);
        return res;
    }
    public static int fibTabulation(int n) {
        if(n<0) return 0;
        if(n <= 1) return n;

        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i<= n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static int fibTabulationSpaceOptimsed(int n) {
        if(n<0) return 0;
        if(n <= 1) return n;

        int prev2 = 0;
        int prev1 = 1;
       
        for(int i = 2; i<= n;i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
