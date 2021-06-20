package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/16/21 4:26 PM
 */
public class Q121BestTimeToBuyAndSellStock {

    /**
     * solution:
     *
     * for every element, we are calculating the difference between that element and the minimum of all the values before that element
     * and we are updating the maximum profit if the difference thus found is greater than the current maximum profit
     *
     * Runtime: 1 ms, faster than 97.63% of Java online submissions for Best Time to Buy and Sell Stock.
     * Memory Usage: 51.8 MB, less than 5.11% of Java online submissions for Best Time to Buy and Sell Stock.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price: prices) {
            if ((price - minPrice) > maxProfit) {
                maxProfit = price - minPrice;
            }
            if (price < minPrice) {
                minPrice = price;
            }
            // this will drop performance a lot
            // maxProfit = Math.max(maxProfit, price - minPrice);
            // minPrice = Math.min(minPrice, price);
        }

        return maxProfit;
    }

}
