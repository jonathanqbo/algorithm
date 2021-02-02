package leecode.bq.algorithm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/31/21 9:06 PM
 */
public class Q159LongestSubstringwithAtMostTwoDistinctCharacters {

    /**
     * solution: sliding window
     *
     * Runtime: 4 ms, faster than 84.73% of Java online submissions for Longest Substring with At Most Two Distinct Characters.
     * Memory Usage: 39.4 MB, less than 22.68% of Java online submissions for Longest Substring with At Most Two Distinct Characters.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0, right = 0;
        // key: char to its right most index (the recent last position)
        Map<Character, Integer> counter = new HashMap(3);
        int resultLeft = -1, resultRight = -1;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (counter.containsKey(c) || counter.size() < 2) {
                counter.put(c, right);
                right++;
                continue;
            }

            if (right - left > resultRight - resultLeft) {
                resultRight = right;
                resultLeft = left;
            }

            // key: directly get next left index
            left = Collections.min(counter.values());
            counter.remove(s.charAt(left));
            left++;
        }

        if (right - left > resultRight - resultLeft) {
            resultRight = right;
            resultLeft = left;
        }

        return resultLeft == -1 ? s.length() : (resultRight - resultLeft);

    }

    /**
     * solution 2: sliding window with different pattern
     *
     * Runtime: 9 ms, faster than 42.44% of Java online submissions for Longest Substring with At Most Two Distinct Characters.
     * Memory Usage: 39.5 MB, less than 22.68% of Java online submissions for Longest Substring with At Most Two Distinct Characters.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        int left = 0, right = 0;
        // key: char to its right most index (the recent last position)
        Map<Character, Integer> counter = new HashMap(3);
        int resultLeft = -1, resultRight = -1;

        while (right < s.length()) {
            char c = s.charAt(right);
            counter.put(c, right);

            if (counter.size() == 3) {
                if (right - left > resultRight - resultLeft) {
                    resultRight = right;
                    resultLeft = left;
                }

                left = Collections.min(counter.values());
                counter.remove(s.charAt(left));
                left++;
            }

            right++;
        }

        if (right - left > resultRight - resultLeft) {
            resultRight = right;
            resultLeft = left;
        }

        return resultLeft == -1 ? s.length() : (resultRight - resultLeft);

    }

}
