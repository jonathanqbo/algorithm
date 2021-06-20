package leecode.bq.algorithm;

import java.util.HashSet;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:12 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q548SplitArraywithEqualSum {

    /**

     (i, j, k)

     solution 1 (Time Limit Exceeded): cumulative sum + 3 for loop

     -------

     solution 2: cumulative sum + 2 for loop (find j, then check left to find candidate i, then check right to find candidate k), using Set to keep the candiate sum

     */
// class Solution {
//     public boolean splitArray(int[] nums) {
//         return true;
//     }
// }

    class Solution {
        public boolean splitArray(int[] nums) {
            if (nums.length < 7)
                return false;
            int[] sum = new int[nums.length];
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }
            for (int j = 3; j < nums.length - 3; j++) {
                HashSet< Integer > set = new HashSet < > ();
                for (int i = 1; i < j - 1; i++) {
                    if (sum[i - 1] == sum[j - 1] - sum[i])
                        set.add(sum[i - 1]);
                }
                for (int k = j + 2; k < nums.length - 1; k++) {
                    if (sum[nums.length - 1] - sum[k] == sum[k - 1] - sum[j] && set.contains(sum[k - 1] - sum[j]))
                        return true;
                }
            }
            return false;
        }
    }

    class Solution2 {
        public boolean splitArray(int[] nums) {
            if (nums.length < 7)
                return false;

            int[] sum = new int[nums.length];
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }
            for (int i = 1; i < nums.length - 5; i++) {
                int sum1 = sum[i - 1];
                for (int j = i + 2; j < nums.length - 3; j++) {
                    int sum2 = sum[j - 1] - sum[i];
                    if (sum1 != sum2)
                        continue;
                    for (int k = j + 2; k < nums.length - 1; k++) {
                        int sum3 = sum[k - 1] - sum[j];
                        int sum4 = sum[nums.length - 1] - sum[k];
                        if (sum3 == sum4 && sum2 == sum4)
                            return true;
                    }
                }
            }
            return false;
        }
    }

}
