package leecode.bq.algorithm;

import java.util.Arrays;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/24/21 10:08 PM
 */
public class Q163SumClosest {

    /**
     * solution: sort + two pointers
     *
     * Runtime: 4 ms, faster than 85.84% of Java online submissions for 3Sum Closest.
     * Memory Usage: 38.1 MB, less than 99.85% of Java online submissions for 3Sum Closest.
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int result2Sum = twoSum(nums, i + 1, target - nums[i]);
            int curDiff = target - nums[i] - result2Sum;
            if (Math.abs(curDiff) < Math.abs(diff)) {
                diff = curDiff;
            }
        }

        return target - diff;
    }

    private int twoSum(int[] nums, int i, int target) {
        int low = i, high = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        while(low < high) {
            int curDiff = target - nums[high] - nums[low];
            if (Math.abs(curDiff) < Math.abs(diff)) {
                diff = curDiff;
            }

            if (curDiff > 0) {
                low++;
            } else if (curDiff < 0) {
                high--;
            } else {
                return target;
            }
        }

        return target - diff;
    }

}
