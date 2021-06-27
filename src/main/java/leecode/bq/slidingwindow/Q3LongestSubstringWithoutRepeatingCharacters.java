package leecode.bq.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <b> </b>
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/22/21 9:32 PM
 */
public class Q3LongestSubstringWithoutRepeatingCharacters {

    /**

     solution 1: sliding window + Set

     keep set of chars, if contain, move left pointer, otherwise move right pointer

     ---------

     solution 2 (preferred): sliding window optimized + Map<char, last index>

     keep last index of each chars, if last index > left, move left to last index + 1, otherwise move right pointer

     */

    class Solution {

        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> charToLastIdx = new HashMap<>();
            int n = s.length();
            int result = 0;

            int left = 0, right = 0;
            while (right < n) {
                char c = s.charAt(right);

                if (charToLastIdx.containsKey(c)) {
                    // key: here is the max, for case: "abba"
                    left = Math.max(left, charToLastIdx.get(c) + 1);
                }

                result = Math.max(result, right - left + 1);

                charToLastIdx.put(c, right);
                right++;
            }

            return result;
        }

    }

    class Solution1 {

        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            int n = s.length();

            int result = 0;
            int left = 0, right = 0;
            while (right < n) {
                char c = s.charAt(right);

                while (set.contains(c)) {
                    set.remove(s.charAt(left++));
                }

                result = Math.max(result, right - left + 1);

                set.add(c);
                right++;
            }

            return result;
        }

    }

}
