package leecode.bq.binarysearch;

/**
 * <b> </b>
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/1/21 11:56 PM
 */
public class Q34FindFirstAndLastPositionOfElementInSortedArray {

    /**

     solution: Two BinarySearch to find leftmost and rightmost

     KEY: how to know no such target found

     */
    class Solution {
        final int[] NOT_FOUND = new int[] {-1, -1};

        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return NOT_FOUND;
            }
            int n = nums.length;

            // find the leftmost equal
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            int leftMost = right + 1;

            // key: !valid means not found
            if (!(leftMost >= 0 && leftMost < n && nums[leftMost] == target)) {
                return NOT_FOUND;
            }

            // find the rightmost equal
            left = leftMost + 1;
            right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            int rightMost = left - 1;

            return new int[] {leftMost, rightMost};
        }

    }

}
