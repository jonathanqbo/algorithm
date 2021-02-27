package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/21/21 9:37 PM
 */
public class Q205IsomorphicStrings {


    /**
     * solution 1: Map
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1)) {
                if (!map.get(c1).equals(c2)) {
                    return false;
                }
            } else {
                // NOTE: bad time complexity
                if (map.containsValue(c2)) {
                    return false;
                }

                map.put(c1, c2);
            }
        }

        return true;
    }

    /**
     * solution 2: Two Map for one-one relationship
     *
     * Runtime: 13 ms, faster than 30.30% of Java online submissions for Isomorphic Strings.
     * Memory Usage: 38.8 MB, less than 90.03% of Java online submissions for Isomorphic Strings.
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map12 = new HashMap<>(s.length());
        Map<Character, Character> map21 = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map12.containsKey(c1)
                    && map21.containsKey(c2)
                    && map12.get(c1).equals(c2)
                    && map21.get(c2).equals(c1)) {
                continue;
            }

            if (!map12.containsKey(c1) && !map21.containsKey(c2)) {
                map12.put(c1, c2);
                map21.put(c2, c1);
                continue;
            }

            return false;
        }

        return true;
    }


    /**
     * solution 3: Word Pattern
     *
     * String 1:              A B E A C D B
     * index pattern:         0 1 2 0 4 5 1
     * String 2:              X Y I X H K Y
     * index pattern:         0 1 2 0 4 5 1
     *
     * Runtime: 10 ms, faster than 42.00% of Java online submissions for Isomorphic Strings.
     * Memory Usage: 39.1 MB, less than 46.75% of Java online submissions for Isomorphic Strings.
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charToIdx1 = new HashMap<>();
        Map<Character, Integer> charToIdx2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            int idx1 = charToIdx1.getOrDefault(c1, -1);
            int idx2 = charToIdx2.getOrDefault(c2, - 1);

            if (idx1 != idx2) {
                return false;
            }

            if (idx1 == -1) {
                charToIdx1.put(c1, i);
                charToIdx2.put(c2, i);
            }
        }

        return true;
    }


    /**
     * solution 4: word pattern using array
     *
     * Runtime: 3 ms, faster than 97.42% of Java online submissions for Isomorphic Strings.
     * Memory Usage: 38.7 MB, less than 90.03% of Java online submissions for Isomorphic Strings.
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic4(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charToIdx1 = new int[256];
        int[] charToIdx2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (charToIdx1[c1] != charToIdx2[c2]) {
                return false;
            }

            if (charToIdx1[c1] == 0) {
                charToIdx1[c1] = i + 1;
                charToIdx2[c2] = i + 1;
            }
        }

        return true;
    }

}
