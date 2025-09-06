import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RefundQueries {
/*
Problem Statement:
Razorpay keeps a list of active transactions. You are given a list transactions = [1,2,3,4,5] and a set of queries of two types:

D x → delete transaction at index x (0-based).

M x → move to transaction at index x and print it.
 */

 /*
You must simulate these queries efficiently.

Input:

transactions = [10, 20, 30, 40, 50]
queries = ["M 2", "D 2", "M 2", "D 0", "M 1"]


Output:

30
40
50
  */
    public static void processQueries(List<Integer> transactions, String[] queries) {
        for(String q: queries) {
            String[] parts = q.split(" ");
            char type = parts[0].charAt(0);
            int index = Integer.parseInt(parts[1]);

            if(type == 'M') {
                System.out.println(transactions.get(index));
            } else if(type == 'D') {
                transactions.remove(index);
            }
        }
    }
    public static void main(String[] args) {
        List<Integer> transactions = new ArrayList<>(Arrays.asList(10,20,30,40,50));
        String[] queries = {"M 2", "D 2", "M 2", "D 0", "M 1"};
        processQueries(transactions, queries);
    }
}
