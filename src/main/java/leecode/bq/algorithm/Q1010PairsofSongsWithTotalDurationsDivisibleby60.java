package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/28/21 9:53 PM
 */
public class Q1010PairsofSongsWithTotalDurationsDivisibleby60 {

    /**
     * solution 1: Hashmap one loop
     *
     * Runtime: 18 ms, faster than 14.12% of Java online submissions for Pairs of Songs With Total Durations Divisible by 60.
     * Memory Usage: 52.3 MB, less than 5.15% of Java online submissions for Pairs of Songs With Total Durations Divisible by 60.
     *
     */
    class Solution {
        public int numPairsDivisibleBy60(int[] time) {
            Map<Integer, Integer> map = new HashMap<>();

            int result = 0;
            for (int t: time) {
                int mod = t % 60;
                int need = mod == 0 ? 0 : 60 - mod;
                if (map.containsKey(need)) {
                    // KEY: all the existed another part of "pair" count
                    result += map.get(need);
                }

                map.put(mod, map.getOrDefault(mod, 0) + 1);
            }

            return result;
        }
    }

    /**
     * solution 2: using Array One loop
     *
     * Runtime: 5 ms, faster than 46.77% of Java online submissions for Pairs of Songs With Total Durations Divisible by 60.
     * Memory Usage: 51.7 MB, less than 14.15% of Java online submissions for Pairs of Songs With Total Durations Divisible by 60.
     *
     */
    class Solution2 {

        public int numPairsDivisibleBy60(int[] time) {
            int[] mods = new int[60];

            int result = 0;
            for (int t : time) {
                int mod = t % 60;
                int need = mod == 0 ? 0 : 60 - mod;

                // KEY: all the existed another part of "pair" count
                result += mods[need];

                mods[mod]++;
            }

            return result;
        }
    }

}
