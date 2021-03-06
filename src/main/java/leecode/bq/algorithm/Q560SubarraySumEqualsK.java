package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/1/21 11:08 PM
 */
public class Q560SubarraySumEqualsK {

    /**
     * solution: another form of two sum
     *
     * Runtime: 18 ms, faster than 73.01% of Java online submissions for Subarray Sum Equals K.
     * Memory Usage: 41.4 MB, less than 74.25% of Java online submissions for Subarray Sum Equals K.
     *
     */
    class Solution {
        // solution: another form of two sum
        public int subarraySum(int[] nums, int k) {
            // sum to amount that has same sum
            Map<Integer, Integer> sums = new HashMap<>();

            int result = 0;
            int sum = 0;
            for (int num: nums) {
                sum += num;

                int need = sum - k;

                if (need == 0) {
                    result++;
                }

                if (sums.containsKey(need)) {
                    // Note: + total amount of items that has same sum
                    result += sums.get(need);
                }

                sums.put(sum, sums.getOrDefault(sum, 0) + 1);
            }

            return result;
        }
    }

}
