package java;

/**
 * Created by yangji27 on 6/2/16.
 */
public class BestTimeBuySellStock {
    public int scanInput(int[] prices) {
        int rs = 0;

        int minSoFar = 0;
        for(int i = 0; i<prices.length; i++) {
            if(prices[i] - prices[minSoFar] > rs) {
                rs = prices[i]-prices[minSoFar];
            }

            if(prices[i] < prices[minSoFar]) {
                minSoFar = i;
            }
        }
        return rs;
    }
}
