package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/21/20 11:27 PM
 */
public class Q1TwoSum {

    /**
     * solution 1: Brute force
     *
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

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
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (valueToIndex.containsKey(target - nums[i])) {
                return new int[] {valueToIndex.get(target - nums[i]), i};
            } else {
                valueToIndex.put(nums[i], i);
            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }

}
