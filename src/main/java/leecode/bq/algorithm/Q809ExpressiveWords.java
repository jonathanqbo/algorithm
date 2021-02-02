package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/1/21 10:58 PM
 */
public class Q809ExpressiveWords {

    /**
     * solution 1: two pointers
     *
     * Runtime: 1 ms, faster than 99.06% of Java online submissions for Expressive Words.
     * Memory Usage: 37.6 MB, less than 60.16% of Java online submissions for Expressive Words.
     *
     * @param S
     * @param words
     * @return
     */
    public int expressiveWords(String S, String[] words) {
        int count = 0;

        for (String word: words) {
            if (isStretchy(S, word)) {
                count++;
            }
        }

        return count;
    }


    private boolean isStretchy(String s, String word) {
        int p1 = 0, p2 = 0;
        int n1 = s.length();
        int n2 = word.length();

        while (p1 < n1 && p2 < n2) {
            int c1 = s.charAt(p1);
            int c2 = word.charAt(p2);
            if (c1 != c2) {
                return false;
            }

            int amount1 = 1;
            p1++;
            while (p1 < n1 && s.charAt(p1) == c1) {
                amount1++;
                p1++;
            }

            int amount2 = 1;
            p2++;
            while (p2 < n2 && word.charAt(p2) == c2) {
                amount2++;
                p2++;
            }

            if (amount2 > amount1 || (amount2 < amount1 && amount1 < 3)) {
                return false;
            }
        }

        return p1 == n1 && p2 == n2;
    }

}

class Solution2 {

    /**
     * solution 2: Run Length Encoding
     *
     * Runtime: 4 ms, faster than 41.84% of Java online submissions for Expressive Words.
     * Memory Usage: 40.5 MB, less than 5.60% of Java online submissions for Expressive Words.
     *
     * @param S
     * @param words
     * @return
     */
    public int expressiveWords(String S, String[] words) {
        RunLengthEncode rs = new RunLengthEncode(S);

        int count = 0;
        for (String word: words) {
            if (isStrethy(rs, new RunLengthEncode(word))) {
                count++;
            }
        }

        return count;
    }

    private boolean isStrethy(RunLengthEncode s, RunLengthEncode word) {
        if (!s.key.equals(word.key)) {
            return false;
        }

        for (int i = 0; i < word.counts.size(); i++) {
            int amountWord = word.counts.get(i);
            int amountS = s.counts.get(i);

            if (amountS == amountWord || (amountS > amountWord && amountS >= 3)) {
                continue;
            }

            return false;
        }

        return true;
    }

    static class RunLengthEncode {
        String key;
        List<Integer> counts;

        public RunLengthEncode(String word) {
            int n = word.length();
            counts = new ArrayList();
            StringBuilder sb = new StringBuilder();

            int count = 0;
            for (int i = 0; i < n; i++) {
                count++;

                // key: if it's last one or n[i] != n[i+1]
                char c = word.charAt(i);
                if (i == n - 1 || c != word.charAt(i + 1)) {
                    sb.append(c);
                    this.counts.add(count);
                    count = 0;
                }
            }

            this.key = sb.toString();
        }
    }
}