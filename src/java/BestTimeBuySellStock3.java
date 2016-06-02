package java;

/**
 * Created by yangji27 on 6/2/16.
 * https://www.youtube.com/watch?v=oDhu5uGq_ic&feature=youtu.be
 */
public class BestTimeBuySellStock3 {
    public int maxProfit(int[] prices) {
        int s = prices.length;
        if (s <= 1) return 0;

        int K = 2; // number of max transation allowed
        int maxProf = 0;
        int[][] f = new int[K+1][s];

        for (int tran = 1; tran <= K; tran++) {
            int maxDiffSoFar = f[tran-1][0] - prices[0];
            for (int day = 1; day < s; day++) {
                f[tran][day] = Math.max(f[tran][day-1], prices[day] + maxDiffSoFar);
                maxDiffSoFar = Math.max(maxDiffSoFar, f[tran-1][day] - prices[day]);
                maxProf = Math.max(f[tran][day], maxProf);
            }
        }
        return maxProf;
    }
}
