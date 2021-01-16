package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/31/20 8:08 PM
 */
public class Q487MaxConsecutiveOnesII {

    /**
     * solution 1: two pointer
     *
     * two pointer that has 2 zero in it. find the first zero and move left pointer after it.
     *
     * Runtime: 2 ms, faster than 86.50% of Java online submissions for Max Consecutive Ones II.
     * Memory Usage: 40.4 MB, less than 80.51% of Java online submissions for Max Consecutive Ones II.
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int l = 0;
        int r = 0;
        int zeroAmount = 0;

        while (r < nums.length) {
            if (nums[r] == 0) {
                zeroAmount++;
            }

            if (zeroAmount == 2) {
                // find first 0, and move left after it.
                while (nums[l] == 1) {
                    l++;
                }
                l++;
                zeroAmount--;
            }

            max = Math.max(max, r - l + 1);

            r++;
        }

        return max;
    }

    /**
     * solution 2: check each 0, flip it and see what max is. (not perfect)
     *
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Max Consecutive Ones II.
     * Memory Usage: 40.7 MB, less than 43.76% of Java online submissions for Max Consecutive Ones II.
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes2(int[] nums) {
        int max = 0;

        boolean hasZero = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                continue;

            hasZero = true;

            int amount = 1;
            int j = i-1;
            while (j >= 0 && nums[j] == 1) {
                amount++;
                j--;
            }
            j = i + 1;
            while (j < nums.length && nums[j] == 1) {
                amount++;
                i++;
                j++;
            }

            max = Math.max(amount, max);
        }

        return hasZero ? max : nums.length;
    }

}
