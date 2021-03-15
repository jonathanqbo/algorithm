package leecode.bq.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <b> </b>
 *
 * @Author : jonathan.q.bo@gmail.com
 * @Since : V1.0
 * Created on 3/10/21 10:34 AM
 */
public class Q131PalindromePartitioning {

    /**
     * solution: backtracking
     *
     * Runtime: 8 ms, faster than 79.54% of Java online submissions for Palindrome Partitioning.
     * Memory Usage: 53 MB, less than 55.08% of Java online submissions for Palindrome Partitioning.
     *
     */
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> result = new LinkedList<>();

            backtrack(s, 0, new ArrayList<String>(), result);

            return result;
        }

        private void backtrack(String s, int first, List<String> parts, List<List<String>> result) {
            if (first == s.length()) {
                result.add(new ArrayList<>(parts));
                return;
            }

            // check each palindrom substring starting from first
            for (int i = first; i < s.length(); i++) {
                if (!isPalindrome(s, first, i)) {
                    continue;
                }

                parts.add(s.substring(first, i + 1));
                backtrack(s, i + 1, parts, result);
                parts.remove(parts.size() - 1);
            }
        }

        private boolean isPalindrome(String s, int i, int j) {
            while (i < j) {
                if (s.charAt(i++) != s.charAt(j--)) {
                    return false;
                }
            }

            return true;
        }

    }


    /**
     * solution 2: backtracking + dp (for Palindrome substring check)
     *
     * Runtime: 8 ms, faster than 79.54% of Java online submissions for Palindrome Partitioning.
     * Memory Usage: 53.2 MB, less than 49.46% of Java online submissions for Palindrome Partitioning.
     *
     */
    class Solution2 {
        public List<List<String>> partition(String s) {
            List<List<String>> result = new LinkedList<>();

            boolean[][] dp = new boolean[s.length()][s.length()];

            backtrack(s, 0, new ArrayList<String>(), result, dp);

            return result;
        }

        private void backtrack(String s, int first, List<String> parts, List<List<String>> result, boolean[][] dp) {
            if (first == s.length()) {
                result.add(new ArrayList<>(parts));
                return;
            }

            // check each palindrom substring starting from first
            for (int i = first; i < s.length(); i++) {
                // if (!isPalindrome(s, first, i)) {
                //     continue;
                // }

                // KEY:
                // first == end AND (length <=2 OR length > 2 and substr[first+1, end-1])
                if (s.charAt(i) == s.charAt(first) && (i - first <= 2 || dp[first + 1][i - 1])) {
                    dp[first][i] = true;

                    parts.add(s.substring(first, i + 1));
                    backtrack(s, i + 1, parts, result, dp);
                    parts.remove(parts.size() - 1);
                }


            }
        }

    }

}
