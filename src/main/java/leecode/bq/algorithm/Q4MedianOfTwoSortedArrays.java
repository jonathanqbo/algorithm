package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/7/21 11:58 PM
 */
public class Q4MedianOfTwoSortedArrays {

    /**
     * solution 1: Merge two array until required size
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean isEven = (nums1.length + nums2.length) % 2 == 0;
        int mid = (nums1.length + nums2.length + 1) / 2;
        mid = isEven ? mid + 1: mid;
        int[] nums3 = new int[mid];

        int i1 = 0, i2 = 0;
        int j = 0;
        while (j < mid) {
            if (i1 < nums1.length && i2 < nums2.length && nums1[i1] <= nums2[i2]) {
                nums3[j++] = nums1[i1++];
            } else if (i1 < nums1.length && i2 < nums2.length && nums1[i1] > nums2[i2]) {
                nums3[j++] = nums2[i2++];
            } else {
                break;
            }
        }

        if (i1 == nums1.length) {
            while (j < mid && i2 < nums2.length) {
                nums3[j++] = nums2[i2++];
            }
        }

        if (i2 == nums2.length) {
            while (j < mid && i1 < nums1.length) {
                nums3[j++] = nums1[i1++];
            }
        }

        if ((nums1.length + nums2.length) % 2 == 0) {
            return (nums3[mid-1] + nums3[mid - 2]) / 2.0;
        } else {
            return nums3[mid-1];
        }
    }

    /**
     * solution 2: binary search on small array
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int halfLength = (nums1.length + nums2.length + 1) / 2;

        int left = 0, right = nums1.length; // key1: right is array length
        while (left <= right) {
            int mid1 = left + (right - left) / 2;
            int mid2 = halfLength - mid1;

            int maxLeft1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int minRight1 = (mid1 == nums1.length) ? Integer.MAX_VALUE : nums1[mid1];
            int maxLeft2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int minRight2 = (mid2 == nums2.length) ? Integer.MAX_VALUE : nums2[mid2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((nums1.length + nums2.length) % 2 == 0) {
                    // note: 2.0 here to get decimal
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                right = mid1 - 1;
            } else {
                left = mid1 + 1;
            }
        }

        throw new IllegalArgumentException();
    }

}
