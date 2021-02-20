package leecode.bq.algorithm;

import java.util.Arrays;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/18/21 10:52 PM
 */
public class Q322CoinChange {

    /**
     * solution 1: recursion top down
     *
     * Runtime: 32 ms, faster than 21.89% of Java online submissions for Coin Change.
     * Memory Usage: 38.6 MB, less than 46.30% of Java online submissions for Coin Change.
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, new int[amount + 1]);
    }

    private int helper(int[] coins, int amount, int[] mem) {
        // KEY: draw the recursion tree, it will end with <0 or ==0
        // <0 ==> not existed; ==0  existed
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        if (mem[amount] != 0) {
            return mem[amount];
        }

        int result = Integer.MAX_VALUE;
        for (int coin: coins) {
            int subResult = helper(coins, amount - coin, mem);
            if (subResult != -1 && subResult < result) {
                result = subResult + 1;
            }
        }
        result = result == Integer.MAX_VALUE ? -1 : result;

        mem[amount] = result;
        return result;
    }

    /**
     * solution 2: DP
     *
     * Runtime: 11 ms, faster than 87.94% of Java online submissions for Coin Change.
     * Memory Usage: 38.4 MB, less than 72.89% of Java online submissions for Coin Change.
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // note: cannot be MAX_VALUE, because we will do +1 later
        Arrays.fill(dp, Integer.MAX_VALUE - 1);

        // KEY, all posible combination will end with dp[0]
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin: coins) {
                if (i < coin) {
                    continue;
                }

                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }

}
