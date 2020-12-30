package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * Key: merge from right to left, and utilize the empty space in nums1.
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
 * Memory Usage: 38.9 MB, less than 79.75% of Java online submissions for Merge Sorted Array.
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/25/20 8:48 PM
 */
public class Q88MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1, p2 = n - 1, p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }

            p--;
        }

        if (p2 >= 0)
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

}
