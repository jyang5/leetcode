package java;

/**
 * Created by yangji27 on 6/2/16.
 */
public class BestTimeBuySellStock2 {
    public int maxProfit(int[] prices) {
        int r = prices.length;
        int rs = 0;

        int buyIn = 0;
        for(int i = 1; i<r; i++) {
            if(prices[i]-prices[buyIn] > 0) {
                rs += prices[i] - prices[buyIn];
                buyIn = i;
            }
            else {
                buyIn = i;
            }
        }
        return rs;
    }
}
