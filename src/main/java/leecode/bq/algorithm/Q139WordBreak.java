package leecode.bq.algorithm;

import java.util.*;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 2/28/21 3:45 PM
 */
public class Q139WordBreak {

    /**
     * solution: DP
     *
     * dp[i]: substring s[0:i] is boolean or not
     * dp[n] = any of (dp[i < n] and its substring[i, n] in dict)
     *
     * Runtime: 6 ms, faster than 64.86% of Java online submissions for Word Break.
     * Memory Usage: 39 MB, less than 77.03% of Java online submissions for Word Break.
     *
     */
    class Solution {

        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> dict = new HashSet<>(wordDict);
            int n = s.length();

            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && dict.contains(s.substring(j, i))) {
                        dp[i] = true;
                    }
                }
            }

            return dp[n];
        }

    }

    /**
     * solution: recursion + memory
     *
     * Runtime: 6 ms, faster than 64.86% of Java online submissions for Word Break.
     * Memory Usage: 39 MB, less than 82.35% of Java online submissions for Word Break.
     */
    class Solution2 {
        public boolean wordBreak(String s, List<String> wordDict) {
            Map<String, Boolean> mem = new HashMap<>();
            return helper(s, new HashSet<>(wordDict), mem);
        }

        private boolean helper(String word, Set<String> dict, Map<String, Boolean> mem) {
            if (word.isEmpty()) {
                return true;
            }

            if (mem.containsKey(word)) {
                return mem.get(word);
            }

            // KEY: <= n, because of substring
            for (int i = 1; i <= word.length(); i++) {
                if (dict.contains(word.substring(0, i)) && helper(word.substring(i), dict, mem)) {
                    mem.put(word, true);
                    return true;
                }
            }

            mem.put(word, false);

            return false;
        }
    }


    /**
     * solution 3: recursion without memory
     * Time limit exceeded
     */
    class Solution1 {
        public boolean wordBreak(String s, List<String> wordDict) {
            return helper(s, new HashSet<>(wordDict));
        }

        private boolean helper(String word, Set<String> dict) {
            if (word.isEmpty()) {
                return true;
            }

            // KEY: <= n, because of substring
            for (int i = 1; i <= word.length(); i++) {
                if (dict.contains(word.substring(0, i)) && helper(word.substring(i), dict)) {
                    return true;
                }
            }

            return false;
        }
    }

}
