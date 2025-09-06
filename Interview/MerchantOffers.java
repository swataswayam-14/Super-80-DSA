public class MerchantOffers {
    /* Each merchant defines an offer interval [start,end] (day range). Given queries (day numbers), return how many offers are active that day.

Interval queries = payment gateway discount engine. */
    public static int[] activeOffers(int[][] offers, int[] days) {
        int[] ans = new int[days.length];
        for(int q=0;q<days.length;q++) {
            int d = days[q];
            int cnt = 0;

            for(int [] off: offers) {
                if(off[0] <= d && d <= off[1]) cnt++;
            }
            ans[q] = cnt;
        }
        return ans;
    }
}
