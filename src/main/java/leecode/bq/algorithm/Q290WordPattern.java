package leecode.bq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/21/21 10:28 PM
 */
public class Q290WordPattern {

    /**
     * solution: word pattern
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Word Pattern.
     * Memory Usage: 36.8 MB, less than 88.73% of Java online submissions for Word Pattern.
     *
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        int[] charToIdx = new int[26];
        Map<String, Integer> wordToIdx = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            int idx1 = charToIdx[c - 'a'];
            int idx2 = wordToIdx.getOrDefault(word, 0);
            if (idx1 != idx2) {
                return false;
            }

            if (idx1 == 0) {
                charToIdx[c - 'a'] = i + 1;
                wordToIdx.put(word, i + 1);
            }
        }

        return true;
    }

}
