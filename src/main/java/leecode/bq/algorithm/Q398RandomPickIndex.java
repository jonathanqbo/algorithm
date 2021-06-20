package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:01 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q398RandomPickIndex {

    /**
     solution 1: HashMap

     time complexity: init: O(N) pick: O(1)
     space complexity: O(N)

     ---------------

     solution 2: Reservoir sampling

     time complexity: init: O(1), pick: O(N)
     space complexity: O(1) (since we don't copy the array, just refer it)

     explaination:

     {1,2,3,3,3} with target 3, you want to select 2,3,4 with a probability of 1/3 each.

     2 : It's probability of selection is 1 * (1/2) * (2/3) = 1/3
     3 : It's probability of selection is (1/2) * (2/3) = 1/3
     4 : It's probability of selection is just 1/3

     */


    class Solution {
        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            int result = 0;

            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != target) {
                    continue;
                }

                if (new Random().nextInt(++count) == 0) {
                    result = i;
                }
            }

            return result;
        }

    }

    class Solution2 {
        Map<Integer, List<Integer>> numToIdxs = new HashMap<>();

        public Solution2(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                numToIdxs.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            }
        }

        public int pick(int target) {
            List<Integer> idxs = numToIdxs.get(target);
            return idxs.get(new Random().nextInt(idxs.size()));
        }
    }


}
