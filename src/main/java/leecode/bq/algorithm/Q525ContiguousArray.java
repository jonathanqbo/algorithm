package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:11 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q525ContiguousArray {

    /**

     solution 1: HashMap counting balance + two sum

     KEY: keep tracking the balance and its first index, then two sum, or balance[0:i] == 0
     KEY: if same balance, the subarr can be balanced

     0   1   0   1   1   1   0  0   0
     -1  0  -1   0   1   2   1  0  -1

     */

    class Solution {

        public int findMaxLength(int[] nums) {
            Map<Integer, Integer> balanceToIdx = new HashMap<>();
            int max = 0;

            int balance = 0;
            for (int i = 0; i < nums.length; i++) {
                balance += nums[i] == 0 ? -1 : 1;

                if (balance == 0 && (i + 1) > max) {
                    max = i + 1;
                }

                if (balanceToIdx.containsKey(balance)) {
                    int firstIdx = balanceToIdx.get(balance);
                    max = Math.max(max, i - firstIdx);
                } else {
                    balanceToIdx.put(balance, i);
                }
            }

            return max;
        }

    }

}
