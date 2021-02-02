package leecode.bq.algorithm;

import java.util.Arrays;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/24/21 10:46 PM
 */
public class Q2593SumSmaller {

    /**
     * solution: sort + two pointers
     *
     * Runtime: 3 ms, faster than 95.72% of Java online submissions for 3Sum Smaller.
     * Memory Usage: 37.6 MB, less than 100.00% of Java online submissions for 3Sum Smaller.
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);

        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            result += twoSum(nums, i + 1, target - nums[i]);
        }

        return result;
    }

    private int twoSum(int[] nums, int i, int target) {
        int result = 0;
        //
        int low = i, high = nums.length - 1;
        while (low < high) {
            int diff = target - nums[low] - nums[high];
            if (diff > 0) {
                // KEY: [low, low+1], [low,low+2],... [low, high] all right answer
                // so before moving low index, result += high - low
                result += high - low;
                low++;
            } else {
                high--;
            }
        }

        return result;
    }

}
