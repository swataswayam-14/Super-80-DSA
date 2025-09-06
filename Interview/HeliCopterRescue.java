import java.util.Arrays;

public class HeliCopterRescue {
/* Problem:
A helicopter can carry at most 2 people at a time. Each person has a weight, and the max capacity of the helicopter is limit.
Find the minimum number of trips needed to rescue all people. */

    /*
Input: weights = [3, 2, 2, 1], limit = 3  
Output: 3
Explanation:
- Trip 1: (1,2)
- Trip 2: (2)
- Trip 3: (3)
     */
    public static int minTrips(int[] people, int limit) {
        Arrays.sort(people);
        int i=0, j = people.length -1, trips = 0;

        while(i<=j) {
            if(people[i] + people[j] <= limit) {
                i++; //pair lightest with heaviest
            }
            j--; // heaviest always goes
            trips++;
        }
        return trips;
    }
    public static void main(String[] args) {
        int[] people = {3, 2, 2, 1};
        System.out.println(minTrips(people, 3));
    }
}
