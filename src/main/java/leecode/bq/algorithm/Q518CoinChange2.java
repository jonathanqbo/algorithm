package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/10/21 8:51 PM
 */
public class Q518CoinChange2 {

    /**
     * solution 1: Brute force: backtrack all combination (Time Limit Exceeded)
     */
    class Solution {
        int result = 0;

        public int change(int amount, int[] coins) {
            backtrack(coins, 0, amount);
            return result;
        }

        void backtrack(int[] coins, int first, int targetAmount) {
            if (targetAmount == 0) {
                result++;
                return;
            }
            if (targetAmount < 0) {
                return;
            }

            for (int i = first; i < coins.length; i++) {
                targetAmount -= coins[i];
                backtrack(coins, i, targetAmount);
                targetAmount += coins[i];
            }
        }
    }

}
