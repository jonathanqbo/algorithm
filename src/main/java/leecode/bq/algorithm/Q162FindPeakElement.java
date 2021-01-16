package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/1/21 4:40 PM
 */
public class Q162FindPeakElement {

    /**
     * solution 1: linear scan
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
     * Memory Usage: 38.9 MB, less than 30.92% of Java online submissions for Find Peak Element.
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return nums.length - 1;
    }

    /**
     * solution 2: binary search
     *
     * key: if a node in a slope, it must have a peak in one side. Do binary search based on it.
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
     * Memory Usage: 38.2 MB, less than 99.45% of Java online submissions for Find Peak Element.
     *
     * @param nums
     * @return
     */
    public int findPeakElement2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

}
