package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/7/21 11:00 PM
 */
public class Q78Subsets {

    /**
     * solution 2: optimized solution 1.
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Subsets.
     * Memory Usage: 39.2 MB, less than 73.83% of Java online submissions for Subsets.
     *
     */
    class Solution2 {

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new LinkedList<>();

            backtrack(nums, 0, new ArrayList<Integer>(), result);

            return result;
        }

        private void backtrack(int[] nums, int first, List<Integer> subset, List<List<Integer>> result) {
            if (subset.size() <= nums.length) {
                // save a copy
                result.add(new ArrayList(subset));
            }

            for (int i = first; i < nums.length; i++) {
                subset.add(nums[i]);

                // KEY: the difference with permuataion is next "first" is from "i+1" instead of "first+1"
                backtrack(nums, i + 1, subset, result);

                subset.remove(subset.size() - 1);
            }
        }

    }

    /**
     * solution 1: backtracking
     *
     * Runtime: 1 ms, faster than 64.24% of Java online submissions for Subsets.
     * Memory Usage: 39.2 MB, less than 61.17% of Java online submissions for Subsets.
     *
     */
    class Solution {

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new LinkedList<>();

            // NOTE: len starts from 0, empty list is one of result
            for (int len = 0; len <= nums.length; len++) {
                List<Integer> subset = new ArrayList<>(len);
                backtrack(nums, 0, len, subset, result);
            }

            return result;
        }

        private void backtrack(int[] nums, int first, int length, List<Integer> subset, List<List<Integer>> result) {
            if (subset.size() == length) {
                // save a copy
                result.add(new ArrayList(subset));
                return;
            }

            for (int i = first; i < nums.length; i++) {
                subset.add(nums[i]);

                // KEY: the difference with permuataion is next "first" is from "i+1" instead of "first+1"
                backtrack(nums, i + 1, length, subset, result);

                subset.remove(subset.size() - 1);
            }
        }

    }

}
