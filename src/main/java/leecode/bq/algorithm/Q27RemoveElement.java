package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Custom Judge:
 *
 * The judge will test your solution with the following code:
 *
 * int[] nums = [...]; // Input array
 * int val = ...; // Value to remove
 * int[] expectedNums = [...]; // The expected answer with correct length.
 *                             // It is sorted with no values equaling val.
 *
 * int k = removeElement(nums, val); // Calls your implementation
 *
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // Sort the first k elements of nums
 * for (int i = 0; i < actualLength; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/30/20 11:06 PM
 */
public class Q27RemoveElement {

    /**

     solution2 (preferred): the amount of val is rare:

     for each nums[i]==val, swap with last one, size - 1,  and don't increase i

     */
    class Solution1 {

        public int removeElement(int[] nums, int val) {
            int writer = 0;
            int n = nums.length;

            while (writer < n) {
                if (nums[writer] == val) {
                    nums[writer] = nums[n - 1];
                    n--;
                } else {
                    writer++;
                }
            }

            return writer;
        }

    }

    /**

     solution1: read write pointers

     in case the amount of val is a lot

     */
    class Solution {

        public int removeElement(int[] nums, int val) {
            int writer = 0;
            for (int reader = 0; reader < nums.length; reader++) {
                if (nums[reader] != val) {
                    nums[writer++] = nums[reader];
                }
            }

            return writer;
        }

    }

}
