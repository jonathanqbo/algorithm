package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/7/21 9:28 PM
 */
public class Q46Permutations {

    /**
     * solution: Backtracking
     * key: when do recursion, swap with each of others instead of check if the number has been used or not
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Permutations.
     * Memory Usage: 39.6 MB, less than 22.83% of Java online submissions for Permutations.
     *
     */
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new LinkedList<>();

            permute(nums, 0, result);

            return result;
        }

        private void permute(int[] nums, int start, List<List<Integer>> result) {
            if (start == nums.length - 1) {
                List<Integer> onePermutation = new ArrayList<>(nums.length);
                for (int num: nums) {
                    onePermutation.add(num);
                }
                result.add(onePermutation);
                return;
            }

            for (int i = start; i < nums.length; i++) {
                // KEY: set nums[start] == each of nums[start...end], and continue the recursion
                // In this way, we can guarantee the value is not used, don't need to check if the num is already used
                // the difference between permutation and combination:
                // for the left candidate values: permutation has all other values as candidate, while combination has only the values that in its right as candidate
                // so for combination, don't change the original nums[], the next start is "i+1" instead of "start+1"
                swap(nums, start, i);

                permute(nums, start + 1, result);

                // backtracking
                swap(nums, start, i);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

}
