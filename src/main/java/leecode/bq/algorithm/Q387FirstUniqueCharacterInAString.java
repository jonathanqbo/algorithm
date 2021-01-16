package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/14/21 11:04 PM
 */
public class Q387FirstUniqueCharacterInAString {

    /**
     * solution 1: HashMap
     *
     * Runtime: 21 ms, faster than 58.85% of Java online submissions for First Unique Character in a String.
     * Memory Usage: 39.6 MB, less than 40.45% of Java online submissions for First Unique Character in a String.
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> count = new HashMap();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            Character c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * solution 2: array
     *
     * Runtime: 7 ms, faster than 87.85% of Java online submissions for First Unique Character in a String.
     * Memory Usage: 39.8 MB, less than 30.76% of Java online submissions for First Unique Character in a String.
     *
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        int[] count = new int[26];

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count[c - 'a'] += 1;
        }

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (count[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
