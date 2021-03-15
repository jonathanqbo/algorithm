package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/8/21 11:42 AM
 */
public class Q39CombinationSum {

    /**
     * solution: backtracking
     *
     * Runtime: 4 ms, faster than 57.31% of Java online submissions for Combination Sum.
     * Memory Usage: 39 MB, less than 86.13% of Java online submissions for Combination Sum.
     *
     */
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
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
                combination.add(nums[i]);
                // KEY: next recursion still start from same "first" (ie: i)
                // but only start from i to avoid duplicate combination
                // this is also the only difference than normal combination algorithm
                backtrack(nums, remain - nums[i], i, combination, result);
                combination.remove(combination.size() - 1);
            }
        }
    }

}
