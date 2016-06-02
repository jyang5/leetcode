package java;

/**
 * Created by yangji27 on 6/2/16.
 */
public class BestTimeBuySellStock4 {
    public int maxProfit(int k, int[] prices) {
        int s = prices.length;
        if (s <= 1) return 0;
        if(k >= s / 2) return quickSolve(prices);

        int maxProf = 0;
        int[][] f = new int[k][s];

        for (int tran = 0; tran < k; tran++) {
            int maxDiffSoFar = -prices[0];
            for (int day = 0; day < s; day++) {
                if(day-1<0) f[tran][day] = Math.max(0, prices[day] + maxDiffSoFar);
                else f[tran][day] = Math.max(f[tran][day-1], prices[day] + maxDiffSoFar);

                if(tran-1<0) maxDiffSoFar = Math.max(maxDiffSoFar, 0 - prices[day]);
                else maxDiffSoFar = Math.max(maxDiffSoFar, f[tran-1][day] - prices[day]);

                maxProf = Math.max(f[tran][day], maxProf);
            }
        }
        return maxProf;

    }

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
