package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/13/21 4:18 PM
 */
public class Q45JumpGameII {

    /**
     * solution: reach to max-reachable position, then jump and set new max-reachable position at that moment
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Jump Game II.
     * Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Jump Game II.
     *
     */
    class Solution {
        public int jump(int[] nums) {
            int curMaxReach = nums[0];
            int nextMaxReach = nums[0];
            // if length == 1, means already in last position, don't need jump
            if (nums.length <= 1) {
                return 0;
            }

            // note: init jumps as 1
            int jumps = 1;
            for (int i = 0; i < nums.length; i++) {
                if (curMaxReach < i) {
                    jumps++;
                    curMaxReach = nextMaxReach;
                }

                nextMaxReach = Math.max(nextMaxReach, i + nums[i]);
            }

            return jumps;
        }
    }

}
