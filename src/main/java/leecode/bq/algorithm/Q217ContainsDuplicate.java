package leecode.bq.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/12/21 9:08 PM
 */
public class Q217ContainsDuplicate {

    /**
     * solution 1: hashset
     *
     * Runtime: 5 ms, faster than 71.84% of Java online submissions for Contains Duplicate.
     * Memory Usage: 45.1 MB, less than 45.24% of Java online submissions for Contains Duplicate.
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        // key: set init capacity
        Set<Integer> set = new HashSet(nums.length);
        for (int num: nums) {
            if (set.contains(num)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }

    /**
     * solution 2: sort and check
     *
     * Runtime: 3 ms, faster than 99.58% of Java online submissions for Contains Duplicate.
     * Memory Usage: 42.4 MB, less than 82.83% of Java online submissions for Contains Duplicate.
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }

}
