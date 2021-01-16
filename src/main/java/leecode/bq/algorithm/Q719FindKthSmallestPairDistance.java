package leecode.bq.algorithm;

import java.util.Arrays;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/8/21 11:08 PM
 */
public class Q719FindKthSmallestPairDistance {

    /**
     * solution 1: Bruce Force get all possible pairs and their distance
     * <p>
     * Runtime: 343 ms, faster than 21.11% of Java online submissions for Find K-th Smallest Pair Distance.
     * Memory Usage: 53.3 MB, less than 5.10% of Java online submissions for Find K-th Smallest Pair Distance.
     *
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int[] arr = new int[nums[nums.length - 1] + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                arr[Math.abs(nums[i] - nums[j])]++;
            }
        }

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count += arr[i];
            if (count >= k) {
                return i;
            }
        }
        return 0;
    }

    /**
     * solution 2: binary search + slide window
     *
     * Runtime: 5 ms, faster than 42.07% of Java online submissions for Find K-th Smallest Pair Distance.
     * Memory Usage: 39 MB, less than 86.69% of Java online submissions for Find K-th Smallest Pair Distance.
     *
     * @param nums
     * @param k
     * @return
     */
    public int smallestDistancePair2(int[] nums, int k) {
        Arrays.sort(nums);

        int low = 0;
        int high = nums[nums.length - 1] - nums[0];
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            // key: one loop get all pairs that distance <= mid
            for (int start = 0, end = 0; end < nums.length; end++) {
                while (nums[end] - nums[start] > mid) {
                    start++;
                }
                // pairs that ends with "end": {start, end}, {start + 1, end} ...
                count += end - start;
            }

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

}
