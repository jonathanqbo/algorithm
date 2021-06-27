package leecode.bq.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <b> </b>
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/8/21 12:00 PM
 */
public class Q40CombinationSumII {

    /**

     solution: dfs + backtracking + sort + skip same num

     NOTE:
     1. could have same number in candidate
     2. each number can only be used ONCE at most (n same number can be used n times)

     KEY: to avoid duplicate result, and n amount of same number can be used n times,
     dfs on FIRST one for same number, and skip other same number

     0, 1, 1, 1, 2, 3

                    0
                1   2   3
             1      3
            1
         2   3
      3

     @see 39. Combination Sum https://leetcode.com/problems/combination-sum/

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
                return;
            }
            if (remain < 0) {
                return;
            }

            for (int i = first; i < nums.length; i++) {
                // KEY: duplication check: if two same num, ignore all except FIRST
                // bacause n same number can be used n times, so here start from FIRST, then skip all the same following number
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
