package leecode.bq.algorithm;

import java.util.Arrays;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/26/21 9:50 PM
 */
public class Q453MinimumMovestoEqualArrayElements {

    /**
     * solution 1: sort, then count
     *
     * Runtime: 10 ms, faster than 36.03% of Java online submissions for Minimum Moves to Equal Array Elements.
     * Memory Usage: 39.2 MB, less than 80.08% of Java online submissions for Minimum Moves to Equal Array Elements.
     *
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        Arrays.sort(nums);

        int result = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            // KEY: everytime, increase the min nums[0] to the max nums[i], then nums[0] == nums[i] == the new min, the nums[i-1] is the new max
            // next time, increase the min nums[0] to new max nums[i-1] which is still nums[i-1] - nums[0]
            // so always be: the max - the min, ie: nums[i] - nums[0]
            result += nums[i] - nums[0];
        }

        return result;
    }

    /**
     * solution 2: optimized solution 1
     * from solution 1, we can see we don't need sort entire array, just need know the min num
     *
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Minimum Moves to Equal Array Elements.
     * Memory Usage: 39.6 MB, less than 46.15% of Java online submissions for Minimum Moves to Equal Array Elements.
     *
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num: nums) {
            min = Math.min(min, num);
        }
        // using IntStream will increase runtime from 1ms to 4ms
        // int min = IntStream.of(nums).min().getAsInt();

        int result = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            result += nums[i] - min;
        }

        return result;
    }

}
