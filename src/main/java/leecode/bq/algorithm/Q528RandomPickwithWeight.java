package leecode.bq.algorithm;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/22/21 10:39 PM
 */
public class Q528RandomPickwithWeight {

    /**
     * solution 1: Section + Binary Search
     *
     * Runtime: 22 ms, faster than 71.34% of Java online submissions for Random Pick with Weight.
     * Memory Usage: 43.9 MB, less than 84.46% of Java online submissions for Random Pick with Weight.
     *
     */
    class Solution {
        int[] weights;
        int count = 0;

        public Solution(int[] w) {
            weights = new int[w.length];

            for (int i = 0; i < w.length; i++) {
                count += w[i];
                weights[i] = count;
            }
        }

        public int pickIndex() {
            // KEY: use random(count) + 1, because weights is 1 based.
            int idx = Arrays.binarySearch(weights, new Random().nextInt(count) + 1);
            if (idx < 0) {
                idx = -idx - 1;
            }

            return idx;
        }
    }


    /**
     * solution 2: section + TreeMap
     *
     * Runtime: 37 ms, faster than 30.39% of Java online submissions for Random Pick with Weight.
     * Memory Usage: 45.7 MB, less than 19.32% of Java online submissions for Random Pick with Weight.
     *
     */
    class Solution2 {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count = 0;

        public Solution2(int[] w) {
            for (int i = 0; i < w.length; i++) {
                count += w[i];
                map.put(count, i);
            }
        }

        public int pickIndex() {
            int idx = map.higherKey(new Random().nextInt(count));
            return map.get(idx);
        }
    }

}
