package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/27/21 10:01 PM
 */
public class Q238ProductofArrayExceptSelf {

    /**
     * solution: O(1) space complexity
     *
     * Runtime: 2 ms, faster than 33.48% of Java online submissions for Product of Array Except Self.
     * Memory Usage: 56.4 MB, less than 16.96% of Java online submissions for Product of Array Except Self.
     *
     */
    class Solution {

        public int[] productExceptSelf2(int[] nums) {
            int[] result = new int[nums.length];

            result[0] = 1;
            // skip nums[0]
            for (int i = 1; i < nums.length; i++) {
                result[i] = nums[i-1] * result[i - 1];
            }

            int r = 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                result[i] = result[i] * r;
                r *= nums[i];
            }

            return result;
        }
    }


    /**
     * solution 2: O(N) space complexity
     *
     * more understandable
     */
    class Solution2 {

        public int[] productExceptSelf(int[] nums) {
            int[] left = new int[nums.length];
            left[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                left[i] = nums[i - 1] * left[i - 1];
            }

            int[] right = new int[nums.length];
            right[nums.length - 1] = 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                right[i] = nums[i + 1] * right[i + 1];
            }

            int[] result = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                result[i] = left[i] * right[i];
            }

            return result;
        }
    }

}
