package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 * <p>
 * <p>
 * Created at 6/19/21 10:00 PM
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 */
public class Q340LongestSubstringwithAtMostKDistinctCharacters {

    /**

     solution: Sliding window + HashMap<char, LastPosition>

     */

    class Solution {

        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            if (s == null || s.isEmpty() || k == 0) {
                return 0;
            }


            Map<Character, Integer> window = new HashMap<>();

            int n = s.length();
            int left = 0;
            int right = 0;
            int maxWindowSize = 0;

            while (right < n) {
                char c = s.charAt(right);
                window.put(c, right);

                while (window.size() > k) {
                    char cl = s.charAt(left++);
                    if (left > window.get(cl)) {
                        window.remove(cl);
                        break;
                    }
                }

                int curWindowSize = right - left + 1;
                if (curWindowSize > maxWindowSize) {
                    maxWindowSize = curWindowSize;
                }

                right++;
            }

            return maxWindowSize;
        }

    }

}
