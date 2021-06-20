package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/20/21 10:17 AM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q1004MaxConsecutiveOnesIII {

    /**

     solution: sliding window with k 0 in it

     */

    class Solution {

        public int longestOnes(int[] nums, int k) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int longestOne = 0;

            int left = 0, right = 0;
            int windowSize = 0;
            while (right < nums.length) {
                if (nums[right] == 0) {
                    windowSize++;

                    if (windowSize > k) {
                        while (left < right && nums[left] == 1) {
                            left++;
                        }
                        left++;
                        windowSize--;
                    }
                }

                longestOne = Math.max(longestOne, right - left + 1);

                right++;
            }

            return longestOne;
        }

    }

}
