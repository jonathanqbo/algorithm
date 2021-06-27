package leecode.bq.number;

/**
 * <b> </b>
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 *
 * The replacement must be in place and use only constant extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 *
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/25/21 9:19 PM
 */
public class Q31NextPermutation {

    /**

    solution:
    1) from right to left, find the first drop num[i], if not found, reverse it and return
    2) from right to left, find the first num[j] that > num[i], and swap them
    3) reverse the sub array num[i+1:]

    eg:

    498765321
    find 4
    find 5
    switch 4, 5 => 5 98764321
    reverse => 5 12346789

    498765321 => 512346789

    */
    class Solution {

        public void nextPermutation(int[] nums) {
            int n = nums.length;

            // find first drop num[peak] num[i]
            int firstDrop = n - 2;
            // note: here ">=", be careful about the "="
            while (firstDrop >= 0 && nums[firstDrop] >= nums[firstDrop + 1]) {
                firstDrop--;
            }

            // entire nums are descending
            if (firstDrop == -1) {
                reverse(nums, 0, n - 1);
                return;
            }

            int peak = firstDrop + 1;

            // find first num num[j] in nums[peak:] that > num[i]
            int firstGreater = n - 1;
            // note: here uses "<=", be careful about the "=
            while (firstGreater >= peak && nums[firstGreater] <= nums[firstDrop]) {
                firstGreater--;
            }

            // swap num[i] and num[j]
            swap(nums, firstDrop, firstGreater);

            // reverse nums[peak:]
            reverse(nums, peak, n - 1);
        }

        private void reverse(int[] nums, int left, int right) {
            while (left < right) {
                swap(nums, left++, right--);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }

}
