package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * Given an unsorted integer array nums, find the smallest missing positive integer.
 *
 * You must implement an algorithm that runs in O(n) time and uses constant extra space.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: nums = [7,8,9,11,12]
 * Output: 1
 *
 *
 * Created at 6/26/21 10:18 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q41FirstMissingPositive {

    /**

     solution: Swap [1:n] in array

     key:
     1. the answer either in [1:n] or n + 1
     2. loop 1st: so loop each num, if it's in [1:n], swap it in place
     3. loop 2nd: loop each num, if num[i] != i, then i is the answer, otherwise n+1 is the answer

     note:
     have to use swap() instead of replace, because the target postion to swap might hasn't been visited yet.
     and after swap, don't move i.
     */
    class Solution {

        public int firstMissingPositive(int[] nums) {
            int n = nums.length;

            int i = 0;
            while (i < n) {
                if (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                    swap(nums, i, nums[i] - 1);
                } else {
                    i++;
                }
            }

            for (int j = 0; j < n; j++) {
                if (nums[j] != j + 1) {
                    return j + 1;
                }
            }

            return n + 1;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

    }


    class Solution1 {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            //
            boolean hasN = false;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0 || nums[i] >= n) {
                    if (nums[i] == n) {
                        hasN = true;
                    }

                    nums[i] = 0;
                }
            }

            //
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0 && nums[nums[i]] > 0) {
                    nums[nums[i]] = -nums[nums[i]];
                }
            }

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > 0) {
                    return i;
                }
            }

            return hasN ? n + 1 : n;
        }
    }

}
