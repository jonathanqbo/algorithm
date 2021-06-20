package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:10 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q523ContinuousSubarraySum {

    /**
     solution: accumulative sum, and find the former existed first sum[i] that has same mod.

     sum[i1] % k = x
     sum[i2] % k = x
     (sum[i1] - sum[i2]) % k = 0

     KEY:
     1. using Map<mod of sum, the first index>
     2. special handle case: [0] by initializing map.put(0, -1)


     NOTE: per problem description: 0 is always a multiple of k, so if there is a sum == 0 with more than two elements, then that's a valid result
     eg: [0, 0], should return true

     */

    class Solution {

        public boolean checkSubarraySum(int[] nums, int k) {
            Map<Integer, Integer> sumToIdx = new HashMap<>();

            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                int mod = sum % k;
                if (mod == 0 && i >= 1) {
                    return true;
                }

                if (sumToIdx.containsKey(mod)) {
                    int idx = sumToIdx.get(mod);
                    if (i - idx >= 2) {
                        return true;
                    }
                } else {
                    sumToIdx.put(mod, i);
                }
            }

            return false;
        }

    }


// class Solution {

//     public boolean checkSubarraySum(int[] nums, int k) {
//         Map<Integer, Integer> sumToIdx = new HashMap<>();

//         int sum = 0;
//         for (int i = 0; i < nums.length; i++) {
//             int num = nums[i];

//             sum += num;
//             sum = sum % k;
//             if (sum == 0 && i >= 1) {
//                 return true;
//             }

//             if (sumToIdx.containsKey(sum)) {
//                 if (i - sumToIdx.get(sum) >= 2) {
//                     return true;
//                 }
//             } else {
//                 // KEY: keep the first index
//                 sumToIdx.put(sum, i);
//             }
//         }

//         return false;
//     }

// }

// class Solution1 {

//     public boolean checkSubarraySum(int[] nums, int k) {
//         // KEY: ModOfSum to first index
//         Map<Integer, Integer> sumToIdx = new HashMap<>();
//         // KEY: to handle case: [0], sum=0, but only 1 element. should return false
//         sumToIdx.put(0, -1);

//         int sum = 0;
//         for (int i = 0; i < nums.length; i++) {
//             int num = nums[i];

//             sum += num;
//             sum = sum % k;

//             if (sumToIdx.containsKey(sum)) {
//                 if (i - sumToIdx.get(sum) >= 2) {
//                     return true;
//                 }
//             } else {
//                 // KEY: keep the first index
//                 sumToIdx.put(sum, i);
//             }
//         }

//         return false;
//     }

// }

}
