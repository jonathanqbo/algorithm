package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/8/21 10:55 AM
 */
public class Q47PermutationsII {

    /**
     * solution: Q46 Permutation + HashSet duplication check
     *
     * Runtime: 1 ms, faster than 99.37% of Java online submissions for Permutations II.
     * Memory Usage: 39.8 MB, less than 54.43% of Java online submissions for Permutations II.
     */
    class Solution {

        public List<List<Integer>> permuteUnique(int[] nums) {
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

            Set<Integer> numUsed = new HashSet<>();
            for (int i = start; i < nums.length; i++) {
                // KEY: same value only exist once in one index position
                // check if same num has existed in cur position
                // This is the only difference with Permutation I
                if (!numUsed.add(nums[i])) {
                    continue;
                }

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
