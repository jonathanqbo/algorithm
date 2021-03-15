package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/8/21 12:00 PM
 */
public class Q40CombinationSumII {

    /**
     * solution: backtracking + sort + duplication check
     *
     * Runtime: 4 ms, faster than 71.85% of Java online submissions for Combination Sum II.
     * Memory Usage: 39.2 MB, less than 75.96% of Java online submissions for Combination Sum II.
     *
     */
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            // sort to avoid duplication combination
            Arrays.sort(candidates);
            backtrack(candidates, target, 0, new ArrayList<Integer>(), result);
            return result;
        }

        private void backtrack(int[] nums, int remain, int first, List<Integer> combination, List<List<Integer>> result) {
            if (remain == 0) {
                result.add(new ArrayList<>(combination));
            }
            if (remain < 0) {
                return;
            }

            for (int i = first; i < nums.length; i++) {
                // KEY: duplication check: if two same num, ignore all except first
                if (i > first && nums[i] == nums[i - 1]) {
                    continue;
                }

                combination.add(nums[i]);
                backtrack(nums, remain - nums[i], i + 1, combination, result);
                combination.remove(combination.size() - 1);
            }
        }
    }

}
