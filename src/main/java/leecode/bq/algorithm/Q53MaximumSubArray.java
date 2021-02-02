package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/23/20 11:24 PM
 */
public class Q53MaximumSubArray {

    /**
     * DP solution:
     * dp(i): the maximum sub of substring that is end with nums[i]
     *
     * key: dp[i] is the sum of contiguous sub-array that **ends** with item i.
     * so for i+1: dp is either dp[i]+n[i+1] or n[i+1]
     * if it's n[i+1] which means dp starts over
     *
     * in this process, check all of dp sum, and keep the max one
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int dp = nums[0];
        int result = dp;
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            if (dp > result) result = dp;
        }

        return result;
    }

}
