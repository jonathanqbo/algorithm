package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/11/21 9:59 PM
 */
public class Q122BestTimeToBuyAndSellStockII {

    /**
     * solution: peak vally
     *
     * Runtime: 1 ms, faster than 68.06% of Java online submissions for Best Time to Buy and Sell Stock II.
     * Memory Usage: 39.1 MB, less than 16.90% of Java online submissions for Best Time to Buy and Sell Stock II.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int peak = 0, vally = 0;
        int i = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            vally = prices[i];

            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];

            profit += peak - vally;
        }

        return profit;
    }

    /**
     * solution 2: single pass, calculate every increasing
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Best Time to Buy and Sell Stock II.
     * Memory Usage: 38.7 MB, less than 65.92% of Java online submissions for Best Time to Buy and Sell Stock II.
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }

        return profit;
    }

}
