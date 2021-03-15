package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/7/21 11:27 PM
 */
public class Q90SubsetsII {

    /**
     * solution: sort and check duplication based on Q78 subset.
     *
     * Runtime: 1 ms, faster than 99.49% of Java online submissions for Subsets II.
     * Memory Usage: 38.9 MB, less than 93.43% of Java online submissions for Subsets II.
     *
     */
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            // sort first
            Arrays.sort(nums);

            List<List<Integer>> result = new LinkedList<>();

            backtrack(nums, 0, new ArrayList<Integer>(), result);

            return result;
        }

        private void backtrack(int[] nums, int first, List<Integer> subset, List<List<Integer>> result) {
            if (subset.size() <= nums.length) {
                result.add(new ArrayList<>(subset));
            }

            for (int i = first; i < nums.length; i++) {
                // key: only add first one, and ignore all other sames nums to avoid duplication
                // for same nums, only visit one time
                if (i > first && nums[i] == nums[i - 1]) {
                    continue;
                }

                subset.add(nums[i]);
                backtrack(nums, i + 1, subset, result);
                subset.remove(subset.size() - 1);
            }
        }

    }

}
