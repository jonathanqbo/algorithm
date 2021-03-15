package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/15/21 12:12 AM
 */
public class Q526BeautifulArrangement {

    /**
     * solution: backtracking permutation + pre-check
     *
     * Runtime: 37 ms, faster than 78.84% of Java online submissions for Beautiful Arrangement.
     * Memory Usage: 35.2 MB, less than 98.66% of Java online submissions for Beautiful Arrangement.
     *
     */
    class Solution {
        int count = 0;

        public int countArrangement(int n) {
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
            }

            permute(nums, 0);
            return count;
        }

        private void permute(int[] nums, int first) {
            // KEY: until the last digit also passed the check
            if (first == nums.length) {
                count++;
            }

            for (int i = first; i < nums.length; i++) {
                swap(nums, first, i);
                if (nums[first] % (first + 1) == 0 || (first + 1) % nums[first] == 0) {
                    permute(nums, first + 1);
                }
                swap(nums, i, first);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

}
