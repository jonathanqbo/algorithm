package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/22/21 9:32 PM
 */
public class Q3LongestSubstringWithoutRepeatingCharacters {

    /**
     * Approach 3: Sliding Window Optimized
     * <p>
     * Runtime: 4 ms, faster than 89.72% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 39.4 MB, less than 42.25% of Java online submissions for Longest Substring Without Repeating Characters.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        // the latest index of the last char (if there are mulitple, only keep the latest index)
        Map<Character, Integer> map = new HashMap();
        int ans = 0, i = 0, j = 0;
        while (j < n) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                // key: the existed char[j] might existed before i, need be ignored
                // i : point to one after the last existed one
                i = Math.max(map.get(c) + 1, i);
            }

            map.put(c, j);
            ans = Math.max(ans, j - i + 1);

            j++;
        }

        return ans;
    }


    /**
     * Approach 2: Sliding Window
     *
     *
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
