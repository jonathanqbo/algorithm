package leecode.bq.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/5/21 11:54 PM
 */
public class Q349IntersectionOfTwoArrays {

    /**
     * solution 1: use build-in set function
     *
     * Runtime: 4 ms, faster than 25.05% of Java online submissions for Intersection of Two Arrays.
     * Memory Usage: 39.4 MB, less than 35.54% of Java online submissions for Intersection of Two Arrays.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet();
        for(int v: nums1) {
            set1.add(v);
        }

        Set<Integer> set2 = new HashSet();
        for(int v: nums2) {
            set2.add(v);
        }

        set1.retainAll(set2);

        // stream drop performance a lot
        return set1.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * solution 3: same as solution 1, just change stream to for-loop
     *
     * Runtime: 2 ms, faster than 97.18% of Java online submissions for Intersection of Two Arrays.
     * Memory Usage: 39.3 MB, less than 35.54% of Java online submissions for Intersection of Two Arrays.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet();
        for(int v: nums1) {
            set1.add(v);
        }

        Set<Integer> set2 = new HashSet();
        for(int v: nums2) {
            set2.add(v);
        }

        set1.retainAll(set2);

        int[] result = new int[set1.size()];
        int i = 0;
        for (Integer v: set1) {
            result[i] = v;
            i++;
        }

        return result;
    }

    /**
     * solution 2: if array is sorted
     *
     * Runtime: 5 ms, faster than 14.79% of Java online submissions for Intersection of Two Arrays.
     * Memory Usage: 39.1 MB, less than 79.13% of Java online submissions for Intersection of Two Arrays.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> l = new HashSet();
        for (int i1 = 0, i2 = 0; i1 < nums1.length && i2 < nums2.length; ) {
            if (nums1[i1] == nums2[i2]) {
                l.add(nums1[i1]);
                i1++;
                i2++;
            } else if (nums1[i1] > nums2[i2]) {
                i2++;
            } else if (nums1[i1] < nums2[i2]) {
                i1++;
            }
        }

        return l.stream().mapToInt(Integer::intValue).toArray();
    }
}
