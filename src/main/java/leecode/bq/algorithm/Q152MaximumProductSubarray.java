package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/17/21 11:39 PM
 */
public class Q152MaximumProductSubarray {

    /**
     * solution 1: brute force
     *
     * Runtime: 88 ms, faster than 9.74% of Java online submissions for Maximum Product Subarray.
     * Memory Usage: 38.8 MB, less than 65.23% of Java online submissions for Maximum Product Subarray.
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int acc = 1;
            for (int j = i; j < nums.length; j++) {
                acc *= nums[j];

                result = Math.max(result, acc);
            }
        }

        return result;
    }

    /**
     * solution 2: DP with keeping max and min product that ends with cur num
     *
     * Runtime: 1 ms, faster than 93.81% of Java online submissions for Maximum Product Subarray.
     * Memory Usage: 38.4 MB, less than 97.68% of Java online submissions for Maximum Product Subarray.
     *
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums) {
        // key: max/min product that ends with cur num
        int maxSoFar = nums[0];
        // KEY: minSoFar to handle negative num
        int minSoFar = nums[0];

        int result = maxSoFar;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            if (num >= 0) {
                maxSoFar = Math.max(num, maxSoFar * num);
                minSoFar = Math.min(num, minSoFar * num);
            } else {
                int tmp = maxSoFar;
                maxSoFar = Math.max(num, minSoFar * num);
                minSoFar = Math.min(num, tmp * num);
            }

            result = Math.max(result, maxSoFar);
        }

        return result;
    }

}
