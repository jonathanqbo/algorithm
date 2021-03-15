package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/15/21 12:08 AM
 */
public class Q134GasStation {

    /**
     * solution: one pass with trick
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Gas Station.
     * Memory Usage: 38.9 MB, less than 90.43% of Java online submissions for Gas Station.
     *
     */
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int totalTank = 0;
            int curTank = 0;

            int startStation = 0;
            for (int i = 0; i < gas.length; i++) {
                totalTank = totalTank + gas[i] - cost[i];
                curTank = curTank + gas[i] - cost[i];
                // KEY: if curTank in cur period < 0 which means the gas gained is more than cost, which mean the next period gain more gas than cost,
                // so the start point must in next period if it's possible.
                if (curTank < 0) {
                    startStation = i + 1;
                    curTank = 0;
                }
            }

            return totalTank >= 0 ? startStation : -1;
        }
    }

}
