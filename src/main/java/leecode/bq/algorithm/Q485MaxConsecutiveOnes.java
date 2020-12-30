package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 12/30/20 4:34 PM
 */
public class Q485MaxConsecutiveOnes {

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Max Consecutive Ones.
     * Memory Usage: 40.1 MB, less than 98.14% of Java online submissions for Max Consecutive Ones.
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }

        // there are might left 1 in the end of list
        return Math.max(max, count);
    }

}
