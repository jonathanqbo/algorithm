package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/23/20 11:24 PM
 */
public class Q53MaximumSubArray_X {

    /**
     * DP solution:
     * dp(i): the maximum sub of substring that is end with nums[i]
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
