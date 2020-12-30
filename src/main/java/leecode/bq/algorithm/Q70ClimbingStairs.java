package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/25/20 5:00 PM
 */
public class Q70ClimbingStairs {

    /**
     * dp[i] = dp[i-1] + dp[i-2]
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
     * Memory Usage: 35.5 MB, less than 83.83% of Java online submissions for Climbing Stairs.
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2)
            return n;

        int dpn1 = 1;
        int dpn2 = 2;
        int dp = 0;

        int i = 3;

        while (i <= n) {
            dp = dpn1 + dpn2;
            dpn1 = dpn2;
            dpn2 = dp;
            i++;
        }

        return dp;
    }

}
