package leecode.bq.backtracking;

import java.util.*;

/**
 * <b> </b>
 *
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/8/21 10:55 AM
 */
public class Q47PermutationsII {

    /**

     Since it's to get permutation, so we are not able to sort nums[] in place.
     Use Set to track same num, skip the swap with same num. (this is the only difference with problem Permutations I)

     @see 46. Permutations

     */
    class Solution {

        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new LinkedList<>();
            dfs(nums, 0, result);

            return result;
        }

        private void dfs(int[] nums, int start, List<List<Integer>> result) {
            if (start == nums.length - 1) {
                List<Integer> permutation = new ArrayList<>(nums.length);
                for (int num: nums) {
                    permutation.add(num);
                }

                result.add(permutation);
                return;
            }

            Set<Integer> numUsed = new HashSet<>();
            for (int i = start; i < nums.length; i++) {
                // KEY: same value only exist once in one index position
                // check if same num has existed in cur position
                if (!numUsed.add(nums[i])) {
                    continue;
                }

                // KEY: set nums[start] == each of nums[start...end], and continue the recursion
                // In this way, we can guarantee the value is not used, don't need to check if the num is already used
                // the difference between permutation and combination:
                // for the left candidate values: permutation has all other values as candidate, while combination has only the values that in its right as candidate
                // so for combination, don't change the original nums[], the next start is "i+1" instead of "start+1"
                swap(nums, start, i);

                dfs(nums, start + 1, result);

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
