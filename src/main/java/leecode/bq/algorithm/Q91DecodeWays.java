package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/27/21 5:07 PM
 */
public class Q91DecodeWays {

    /**
     * solution 1: recursion + memory
     *
     * Runtime: 2 ms, faster than 37.22% of Java online submissions for Decode Ways.
     * Memory Usage: 37.6 MB, less than 52.87% of Java online submissions for Decode Ways.
     *
     */
    class Solution {
        public int numDecodings(String s) {
            // will exceed time limit without cache
            Map<Integer, Integer> mem = new HashMap<>();
            return decode(s, 0, mem);
        }

        private int decode(String s, int idx, Map<Integer, Integer> mem) {
            if (mem.containsKey(idx)) {
                return mem.get(idx);
            }

            // KEY:
            //        (n-1th)  (nth)
            // +1.==>          (nth)
            // +2.==>                (n+1th)
            if (idx == s.length()) {
                return 1;
            }

            if (s.charAt(idx) == '0') {
                return 0;
            }

            if (idx == s.length() - 1) {
                return 1;
            }

            int result = decode(s, idx + 1, mem);
            if (Integer.parseInt(s.substring(idx, idx + 2)) <= 26) {
                result += decode(s, idx + 2, mem);
            };

            mem.put(idx, result);

            return result;
        }

    }

    /**
     * solution 2: DP with only need last two result
     *
     * Runtime: 1 ms, faster than 95.24% of Java online submissions for Decode Ways.
     * Memory Usage: 37.3 MB, less than 80.36% of Java online submissions for Decode Ways.
     *
     */
    class Solution2 {

        // pretty same with Febonacci and Clamb Stairs
        // difference is need to check 0 for current digit and 10-26 last two digits
        public int numDecodings(String s) {
            if (s.isEmpty() || s.charAt(0) == '0') {
                return 0;
            }

            int dp0 = 1;
            int dp1 = 1;
            for (int i = 1; i < s.length(); i++) {
                int dpi = 0;
                if (s.charAt(i) != '0') {
                    dpi = dp1;
                }

                int lastTwoDigits = Integer.parseInt(s.substring(i - 1, i + 1));
                if (lastTwoDigits >= 10 && lastTwoDigits <= 26) {
                    dpi += dp0;
                }

                dp0 = dp1;
                dp1 = dpi;
            }

            return dp1;
        }
    }

}
