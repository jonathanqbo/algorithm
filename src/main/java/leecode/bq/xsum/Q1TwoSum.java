package leecode.bq.xsum;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/21/20 11:27 PM
 */
public class Q1TwoSum {

    /**
     * solution: one pass HashMap
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum.
     * Memory Usage: 39.4 MB, less than 29.33% of Java online submissions for Two Sum
     *
     * @param nums
     * @param target
     * @return
     */
    class Solution {

        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> numToIdx = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                int need = target - num;
                if (numToIdx.containsKey(need)) {
                    return new int[] {i, numToIdx.get(need)};
                } else {
                    numToIdx.put(num, i);
                }
            }

            throw new IllegalArgumentException("No such solution");
        }

    }

}
