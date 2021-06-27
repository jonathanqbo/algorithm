package leecode.bq.algorithm;

/**
 * <b> </b>
 *
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/13/21 4:18 PM
 */
public class Q45JumpGameII {

    /**

     solution: looping from left to right, and keep tracking maxReach and nextMaxReach

     key:
     keep maxReach, and nextMaxReach
     [i, maxReach] just keep calculating nextMaxReach
     in maxReach, => jump++, maxReach = nextMaxReach
     keep calculating nextMaxReach = i + nums[i], if

     */
    class Solution {

        public int jump(int[] nums) {
            int jump = 0;
            int maxReach = 0;

            int nextMaxReach = maxReach;
            // note: loop stop at the 2nd from last
            for (int i = 0; i < nums.length - 1; i++) {
//             // i is not reachable
//             if (i > maxReach) {
//                 throw new IllegalArgumentException();
//             }

                nextMaxReach = Math.max(nextMaxReach, i + nums[i]);

                if (i == maxReach) {
                    jump++;
                    maxReach = nextMaxReach;
                } }

            return jump;
        }

    }

    class Solution1 {
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
