package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/26/21 11:05 PM
 */
public class Q55JumpGame {

    /**
     * solution 1: left to right, check max position can be reached.
     *
     * Runtime: 2 ms, faster than 42.76% of Java online submissions for Jump Game.
     * Memory Usage: 40.7 MB, less than 90.87% of Java online submissions for Jump Game.
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int maxReachPos = 0;
        for (int i = 0; i <= maxReachPos; i++) {
            maxReachPos = Math.max(i + nums[i], maxReachPos);

            if (i >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }

    /**
     * solution 2: right to left, check most left good position (that can reach to end) for each item
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Jump Game.
     * Memory Usage: 41.3 MB, less than 35.05% of Java online submissions for Jump Game.
     *
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        int leftMostGoodPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= leftMostGoodPos) {
                leftMostGoodPos = i;
            }
        }

        return leftMostGoodPos == 0;
    }

    /**
     * solution 3: DP bottom-up
     *
     * Runtime: 657 ms, faster than 14.05% of Java online submissions for Jump Game.
     * Memory Usage: 40.3 MB, less than 98.40% of Java online submissions for Jump Game.
     *
     * @param nums
     * @return
     */
    public boolean canJump3(int[] nums) {
        int[] indicator = new int[nums.length];
        indicator[nums.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i] && (i + j) < nums.length; j++) {
                if (indicator[i + j] == 1) {
                    indicator[i] = 1;
                    break;
                }
            }
        }

        return indicator[0] == 1;
    }

}
