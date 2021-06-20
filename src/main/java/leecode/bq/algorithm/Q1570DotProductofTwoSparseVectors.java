package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/20/21 10:42 AM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q1570DotProductofTwoSparseVectors {

    /**

     solution: Map

     key:
     1. sparse vector means majority item is 0
     2. use Map to keep the non-0 value only

     ----------

     solution 2: List<int[idx, value]> + two pointers (because index is always ordered)

     */


    class SparseVector {

        Map<Integer, Integer> idxToNum = new HashMap<>();

        SparseVector(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    idxToNum.put(i, nums[i]);
                }
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            // NOTE: drop timecost from 9ms to 7ms
            if (idxToNum.size() > vec.idxToNum.size()) {
                return vec.dotProduct(this);
            }

            Map<Integer, Integer> idxToNum2 = vec.idxToNum;

            int result = 0;
            for (Map.Entry<Integer, Integer> kv : idxToNum.entrySet()) {
                int idx = kv.getKey();
                int val = kv.getValue();
                if (idxToNum2.containsKey(idx)) {
                    result += val * idxToNum2.get(idx);
                }
            }

            return result;
        }

    }

}
