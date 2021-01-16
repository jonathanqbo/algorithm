package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/6/21 8:37 PM
 */
public class Q350IntersectionOfTwoArraysII {

    /**
     * solution 1: sort and two pointers
     *
     * Runtime: 2 ms, faster than 94.96% of Java online submissions for Intersection of Two Arrays II.
     * Memory Usage: 39 MB, less than 87.98% of Java online submissions for Intersection of Two Arrays II.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> l = new LinkedList();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                l.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[l.size()];
        int k = 0;
        for (Integer v: l) {
            result[k++] = v;
        }

        return result;
    }

    /**
     * solution 2: use Map keep number and their amount for one array, then check another array
     *
     * Runtime: 2 ms, faster than 94.96% of Java online submissions for Intersection of Two Arrays II.
     * Memory Usage: 39.2 MB, less than 48.97% of Java online submissions for Intersection of Two Arrays II.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> valueToAmount = new HashMap();
        for (int v: nums1) {
            valueToAmount.put(v, valueToAmount.getOrDefault(v, 0) + 1);
        }

        int k = 0; // use nums1 to store result
        for (int v: nums2) {
            int amount = valueToAmount.getOrDefault(v, 0);
            if (amount > 0) {
                nums1[k++] = v;

                valueToAmount.put(v, amount - 1);
            }
        }

        return Arrays.copyOf(nums1, k);
    }

}
