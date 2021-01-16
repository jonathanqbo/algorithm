package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/11/21 9:22 PM
 */
public class Q410SplitArrayLargestSum {

    /**
     * solution 1: binary search + greedy
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Split Array Largest Sum.
     * Memory Usage: 36.8 MB, less than 46.05% of Java online submissions for Split Array Largest Sum.
     *
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        long max = 0;
        for (int num: nums) {
            if (num > max) {
                max = num;
            }
            sum += num;
        }

        long left = max, right = sum;
        long ans = sum;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            int count = splitByMid(nums, mid);
            if (count <= m) {
                right = mid - 1;
                ans = Math.min(mid, ans);
            } else {
                left = mid + 1;
            }
        }

        return (int)ans;
    }

    private int splitByMid(int[] nums, long max) {
        // start from 1
        int count = 1;
        long sum = 0;
        for (int num: nums) {
            if (sum + num > max) {
                count++;
                sum = num;
            } else {
                sum += num;
            }
        }

        return count;
    }

}
