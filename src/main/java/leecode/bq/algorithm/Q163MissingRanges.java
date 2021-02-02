package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/31/21 10:40 PM
 */
public class Q163MissingRanges {

    /**
     * solution: just take care each edge cases separately
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Ranges.
     * Memory Usage: 39 MB, less than 6.79% of Java online submissions for Missing Ranges.
     *
     * @param nums
     * @param lower
     * @param upper
     * @return
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList();
        if (nums.length == 0) {
            result.add(range(lower, upper));
            return result;
        }

        if (lower != nums[0]) {
            result.add(range(lower, nums[0] - 1));
        }

        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] + 1 != nums[i + 1]) {
                result.add(range(nums[i] + 1, nums[i + 1] - 1));
            }

            i++;
        }

        if (upper != nums[nums.length - 1]) {
            result.add(range(nums[nums.length - 1] + 1, upper));
        }

        return result;
    }

    private String range(int lower, int upper) {
        // key: use StringBuilder. It increases performance a lot 9ms -> 0ms!
        return upper == lower ? String.valueOf(upper) : new StringBuilder().append(lower).append("->").append(upper).toString();
    }

}
