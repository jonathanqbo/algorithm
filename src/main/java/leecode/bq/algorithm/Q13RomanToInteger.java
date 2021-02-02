package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/18/21 10:54 PM
 */
public class Q13RomanToInteger {

    static Map<Character, Integer> kv = new HashMap();

    static {
        kv.put('I', 1);
        kv.put('V', 5);
        kv.put('X', 10);
        kv.put('L', 50);
        kv.put('C', 100);
        kv.put('D', 500);
        kv.put('M', 1000);
    }

    /**
     * solution 1: left to right pass
     *
     * Runtime: 3 ms, faster than 99.92% of Java online submissions for Roman to Integer.
     * Memory Usage: 39 MB, less than 82.43% of Java online submissions for Roman to Integer.
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int result = 0;
        int size = s.length();
        for (int i = 0; i < size; i++) {
            int n1 = kv.get(s.charAt(i));
            if (i + 1 < size) {
                int n2 = kv.get(s.charAt(i + 1));

                // key: n[i+1] > n[i] means need to do "-"
                if (n2 > n1) {
                    result += n2 - n1;
                    // note: don't forget i + 1 in this case
                    i++;
                } else {
                    result += n1;
                }

            } else {
                result += n1;
            }
        }

        return result;
    }

    /**
     * solution 2: treat 2 combo as one type of number
     *
     * Runtime: 6 ms, faster than 30.23% of Java online submissions for Roman to Integer.
     * Memory Usage: 39.4 MB, less than 46.87% of Java online submissions for Roman to Integer.
     *
     */
    static class Solution2 {
        static Map<String, Integer> kv = new HashMap();

        static {
            kv.put("I", 1);
            kv.put("V", 5);
            kv.put("X", 10);
            kv.put("L", 50);
            kv.put("C", 100);
            kv.put("D", 500);
            kv.put("M", 1000);
            // for solution 2
            kv.put("IV", 4);
            kv.put("IX", 9);
            kv.put("XL", 40);
            kv.put("XC", 90);
            kv.put("CD", 400);
            kv.put("CM", 900);
        }

        public int romanToInt(String s) {
            int result = 0;
            int i = 0;
            int size = s.length();

            while (i < size) {
                String s1 = String.valueOf(s.charAt(i));

                if (i + 1 < size) {
                    String s2 = s1 + String.valueOf(s.charAt(i + 1));
                    if (kv.containsKey(s2)) {
                        result += kv.get(s2);
                        i = i + 2;
                        continue;
                    }
                }

                result += kv.get(s1);
                i++;
            }

            return result;
        }
    }
}
