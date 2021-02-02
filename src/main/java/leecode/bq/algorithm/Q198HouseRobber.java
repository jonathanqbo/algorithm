package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/16/21 6:13 PM
 */
public class Q198HouseRobber {

    /**
     * solution: dp
     *
     * f(k) = Largest amount that you can rob from the first k houses.
     * Ai = Amount of money at the ith house.
     * f(k) = max(f(k – 2) + Ak, f(k – 1))
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
     * Memory Usage: 36.3 MB, less than 76.38% of Java online submissions for House Robber.
     *
     * @param nums
     * @return
     */
    // f(k) = Largest amount that you can rob from the first k houses.
    // Ai = Amount of money at the ith house.
    //
    // f(k) = max(f(k – 2) + Ak, f(k – 1))
    public int rob(int[] nums) {
        // the max amount for the first k-1
        int fkPre = 0;
        // the max amount for the first k
        int fk = 0;

        for (int num : nums) {
            int tmp = fk;
            fk = Math.max(fkPre + num, fk);
            fkPre = tmp;
        }

        return fk;
    }

    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        // the max amount for the first k-1
        int fkPre = 0;
        // the max amount for the first k
        int fk = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tmp = fk;
            fk = Math.max(fkPre + nums[i], fk);
            fkPre = tmp;
        }

        return fk;
    }

}
