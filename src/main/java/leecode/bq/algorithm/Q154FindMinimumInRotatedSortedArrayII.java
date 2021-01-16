package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/5/21 11:00 PM
 */
public class Q154FindMinimumInRotatedSortedArrayII {

    /**
     * solution: binary search on a list that has duplicated values
     *
     * key: don't move aggressively in case ==
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array II.
     * Memory Usage: 38.6 MB, less than 92.09% of Java online submissions for Find Minimum in Rotated Sorted Array II.
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // key: if ==, just move right by 1 instead mid
                right = right - 1;
            }
        }

        return nums[right];
    }

}
