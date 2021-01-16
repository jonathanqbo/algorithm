package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/1/21 11:56 PM
 */
public class Q34FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * solution: two binary search to find the first and last postion.
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     * Memory Usage: 42.1 MB, less than 75.24% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};

        int leftIndex = binarySearchLeftMost(nums, 0, nums.length - 1, target);
        if (leftIndex == -1)
            return new int[]{-1, -1};

        int rightIndex = binarySearchRightMost(nums, leftIndex, nums.length - 1, target);

        return new int[]{leftIndex, rightIndex};
    }

    // leftMost: first item >= target, ie: move right pointer when equal
    private int binarySearchLeftMost(int[] nums, int from, int end, int target) {
        int left = from, right = end;

        // finally stop at last two values: [left, right]
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }

    // rightMost: first item > target, ie: move left pointer when equal
    private int binarySearchRightMost(int[] nums, int from, int end, int target) {
        int left = from, right = end;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            // place 1 different than leftmost:
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        // place 2 difference than leftmost
        if (nums[right] == target) {
            return right;
        } else if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

}
