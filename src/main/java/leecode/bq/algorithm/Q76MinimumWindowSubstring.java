package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 1/27/21 11:31 PM
 */
public class Q76MinimumWindowSubstring {

    /**
     * solution 1: slide window with Map
     *
     * Runtime: 17 ms, faster than 22.07% of Java online submissions for Minimum Window Substring.
     * Memory Usage: 39.3 MB, less than 65.61% of Java online submissions for Minimum Window Substring.
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> dictT = new HashMap();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int amount = dictT.getOrDefault(c, 0);
            dictT.put(c, amount+1);
        }

        int[] ans = {Integer.MAX_VALUE, 0, 0};
        Map<Character, Integer> window = new HashMap();
        int formed = 0;

        int l = 0, r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (!dictT.containsKey(c)) {
                r++;
                continue;
            }

            int amount = window.getOrDefault(c, 0) + 1;
            window.put(c, amount);

            if (amount == dictT.get(c)) {
                formed++;
            }

            // l <= r: for cases that t.length() == 1
            while (l <= r && formed == dictT.size()) {
                char c1 = s.charAt(l);
                if (dictT.containsKey(c1)) {
                    if (r - l + 1 < ans[0]) {
                        ans[0] = r - l + 1;
                        ans[1] = l;
                        ans[2] = r;
                    }

                    int newAmount = window.get(c1) - 1;
                    window.put(c1, window.get(c1) - 1);

                    if (newAmount < dictT.get(c1)) {
                        formed--;
                    }
                }

                l++;
            }

            r++;
        }

        return ans[0] == Integer.MAX_VALUE ? "" : s.substring(ans[1], ans[2] + 1);
    }


    /**
     * solution 2: slide window + array (since s, t are English char only)
     *
     * Runtime: 3 ms, faster than 94.84% of Java online submissions for Minimum Window Substring.
     * Memory Usage: 39 MB, less than 83.59% of Java online submissions for Minimum Window Substring.
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow2(String s, String t) {
        int[] dictT = new int[128];
        int dictSize = 0;
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (dictT[c] == 0) {
                dictSize++;
            }

            dictT[c] += 1;
        }

        int ansStart = -1, ansEnd = s.length();
        int[] window = new int[128];
        int formed = 0;

        int l = 0, r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (dictT[c] == 0) {
                r++;
                continue;
            }

            window[c] += 1;
            if (window[c] == dictT[c]) {
                formed++;
            }

            // l <= r: for cases that t.length() == 1
            while (l <= r && formed == dictSize) {
                char c1 = s.charAt(l);
                if (dictT[c1] > 0) {
                    if (r - l < ansEnd - ansStart) {
                        ansStart = l;
                        ansEnd = r;
                    }

                    int newAmount = window[c1] - 1;
                    window[c1] -= 1;

                    if (window[c1] < dictT[c1]) {
                        formed--;
                    }
                }

                l++;
            }

            r++;
        }

        return ansStart == -1 ? "" : s.substring(ansStart, ansEnd + 1);
    }

}
