package leecode.bq.algorithm;

import java.util.Arrays;

/**
 * <b> </b>
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/24/21 10:08 PM
 */
public class Q163SumClosest {

    /**

     solution: sort + two pointers

     for each nums[i], two pointers to find the closest triplet in nums[i+1:]

     */
    class Solution {

        public int threeSumClosest(int[] nums, int target) {
            int n = nums.length;

            Arrays.sort(nums);

            // Note: keep tracking diff instead of sum
            int minDiff = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int cur = nums[i];

                // two pointers
                int left = i + 1, right = n - 1;
                while (left < right) {
                    int curDiff = nums[right] + nums[left] + cur - target;

                    if (Math.abs(curDiff) < Math.abs(minDiff)) {
                        minDiff = curDiff;
                    }

                    if (curDiff < 0) {
                        left++;
                    } else if (curDiff > 0) {
                        right--;
                    } else {
                        return target;
                    }
                }
            }

            return target + minDiff;
        }

    }


}
