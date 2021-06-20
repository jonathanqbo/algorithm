package leecode.bq.algorithm;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/20/21 10:20 AM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q1060MissingElementinSortedArray {

    /**

     Solution: Binary Searcch

     4, 7, 9, 10
     4, 5, 6, 7
     0, 2, 3, 3

     @see: 1539. Kth Missing Positive Number (https://leetcode.com/problems/kth-missing-positive-number/)

     */
    class Solution {

        public int missingElement(int[] nums, int k) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                // KEY: the number in mid should be: nums[0] + mid
                int diff = nums[mid] - nums[0] - mid;

                if (diff < k) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            // KEY:
            return nums[0] + left - 1 + k;
        }

    }

}
