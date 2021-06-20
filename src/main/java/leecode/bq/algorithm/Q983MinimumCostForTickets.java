package leecode.bq.algorithm;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:33 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q983MinimumCostForTickets {

    /**

     solution 1: dp - bottom up (14%, good for interview)

     dp[i]: the min cost from first day to day i.
     dp[i+1] = Min{dp[i] + cost1, dp[i-7] + cost7, dp[i-30] + cost30}
     dp[0] = 0

     ----------

     solution 2: optimized solution 1 (not really optimized)

     instead of check every day, we check only the last 30 days, and from first day to last day

     */

    class Solution {

        public int mincostTickets(int[] days, int[] costs) {
            int firstDay = days[0];
            int lastDay = days[days.length - 1];

            Set<Integer> daySet = Arrays.stream(days).boxed().collect(Collectors.toSet());

            int[] dp = new int[lastDay - firstDay + 2];
            dp[0] = 0;

            for (int day = firstDay; day <= lastDay; day++) {
                int i = day - firstDay + 1;

                if (!daySet.contains(day)) {
                    dp[i] = dp[i - 1];
                    continue;
                }

                int cost1 = dp[i - 1] + costs[0];
                int cost7 = dp[Math.max(0, i - 7)] + costs[1]; // KEY: if day<7, dp[i] = cost7
                int cost30 = dp[Math.max(0, i - 30)] + costs[2];

                dp[i] = Math.min(cost1, Math.min(cost7, cost30));
            }

            return dp[dp.length - 1];
        }

    }

    class Solution2 {

        public int mincostTickets(int[] days, int[] costs) {
            int lastDay = days[days.length - 1];
            Set<Integer> daySet = Arrays.stream(days).boxed().collect(Collectors.toSet());

            int[] dp = new int[lastDay + 1];
            for (int i = 1; i <= lastDay; i++) {
                if (!daySet.contains(i)) {
                    dp[i] = dp[i - 1];
                    continue;
                }

                int cost1 = dp[i - 1] + costs[0];
                int cost7 = dp[Math.max(0, i - 7)] + costs[1]; // KEY: if day<7, dp[i] = cost7
                int cost30 = dp[Math.max(0, i - 30)] + costs[2];

                dp[i] = Math.min(cost1, Math.min(cost7, cost30));
            }

            return dp[lastDay];
        }

    }

    class Solution3 {

        public int mincostTickets(int[] days, int[] costs) {
            Set<Integer> daySet = IntStream.of(days).boxed().collect(Collectors.toSet());

            int firstDay = days[0];
            int lastDay = days[days.length - 1];

            int[] dp = new int[30];
            for (int day = firstDay; day <= lastDay; day++) {
                if (!daySet.contains(day)) {
                    dp[day % 30] = dp[(day - 1) % 30];
                } else {
                    int cost1 = dp[(day - 1) % 30] + costs[0];
                    int cost2 = dp[(Math.max(0, day - 7)) % 30] + costs[1];
                    int cost3 = dp[(Math.max(0, day - 30)) % 30] + costs[2];
                    dp[day % 30] = Math.min(cost1, Math.min(cost2, cost3));
                }
            }

            return dp[lastDay % 30];
        }

    }

}
