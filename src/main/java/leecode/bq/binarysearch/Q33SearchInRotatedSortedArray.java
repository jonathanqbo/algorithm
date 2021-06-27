package leecode.bq.binarysearch;

/**
 * <b> </b>
 *
 * There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/1/21 3:52 PM
 */
public class Q33SearchInRotatedSortedArray {

    /**

     solution: binary search

                  /
               /
            /
         /
      /
     --------------------------------
                                 /
                               /
                            /
                         /
                      /
                   /

     ---

     if mid == target:
        found

     if mid >= left:
         if target < mid and target >= left:
            right = mid - 1;
         else:
            left = mid + 1;
     else mid < left:
         if target > mid and target >= right:
            left = mid + 1;
         else:
            right = mid - 1;

     */
    class Solution {

        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }

            int n = nums.length;

            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] >= nums[left]) {
                    if (nums[mid] > target && target >= nums[left]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }

            return -1;
        }

    }

}
